package zsfc;

import Server.OperationManager;
import interfaces.NetworkFunction;
import interfaces.stepControl.NextStepTask;
import interfaces.stepControl.ProcessCondition;
import interfaces.stepControl.ProcessControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import traceload.TraceLoad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SFCProcessControl implements ProcessControl, ProcessCondition, Runnable {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final int numInstances = 2;
    private Map<String, NetworkFunction> runNFs;
    private OperationManager operationManager;
    public static boolean isFirstRecv = false;
    protected static Logger logger = LoggerFactory.getLogger(SFCProcessControl.class);
    private TraceLoad traceLoad;
    protected short traceSwitchPort;
    private String traceHost;
    private short tracePort;
    private String traceFile;
    private int traceRate;
    private int traceNumPkts;
    private String switchid;
    private int replayPort;
    private int NF1Input;
    private int NF1Output;
    private int NF2Input;
    private int NF2Output;
    private int NF3Input;



    public SFCProcessControl(){
        parseConfigFile();
    }

    public SFCProcessControl(OperationManager operationManager){
        runNFs = new HashMap<String, NetworkFunction>();
        this.operationManager = operationManager;

        parseConfigFile();
    }

    public void parseConfigFile(){
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/sharestate/sfc-config.properties");
            prop.load(fileInputStream);
            this.traceSwitchPort = Short.parseShort(prop.getProperty("TraceReplaySwitchPort"));
            this.traceHost = prop.getProperty("TraceReplayHost");
            this.traceFile = prop.getProperty("TraceReplayFile");
            this.traceRate = Short.parseShort(prop.getProperty("TraceReplayRate"));
            this.traceNumPkts  = Integer.parseInt(prop.getProperty("TraceReplayNumPkts"));
            this.switchid = prop.getProperty("Switchid");
            logger.info("switchid"+switchid);
            this.replayPort = Integer.parseInt(prop.getProperty("TraceReplaySwitchPort"));
            this.NF1Input = Integer.parseInt(prop.getProperty("TraceReplayNF1Input"));
            logger.info("nf1 input"+NF1Input);
            this.NF1Output = Integer.parseInt(prop.getProperty("TraceReplayNF1Output"));
            logger.info("nf1 output"+NF1Output);
            this.NF2Input= Integer.parseInt(prop.getProperty("TraceReplayNF2Input"));
            logger.info("nf2 input"+NF2Input);
            this.NF2Output = Integer.parseInt(prop.getProperty("TraceReplayNF2Output"));
            logger.info("nf2 output"+NF2Output);
            this.NF3Input = Integer.parseInt(prop.getProperty("TraceReplayNF3Input"));
            logger.info("nf3 input"+NF3Input);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * The NF will be added by operation manager, if we got enough number of NF, execute the move operation
     * @param nf
     */
    private synchronized void addNetworkFunction(NetworkFunction nf){
        if (this.runNFs.containsValue(nf))
        { return; }

        for (int i = 1; i <= numInstances; i++)
        {
            String nfID = "nf".concat(Integer.toString(i));
            if (!this.runNFs.containsKey(nfID))
            {
                this.runNFs.put(nfID, nf);
                break;
            }
        }

        if (numInstances == this.runNFs.size())
        { this.executeStep(0); }
    }

    /**
     * The NF will be added by operation manager
     * @param nf
     */
    public void NFConnected(NetworkFunction nf) {
        if(!this.runNFs.containsValue(nf)){
            this.addNetworkFunction(nf);
        }
    }

    public void startMove(){
        //ActionStateStorage actionStateStorage = ActionStateStorage.getInstance(runNFs.get("nf2"), this);
        //((ActionMsgProcessor)operationManager.getActionMsgProcessors()).addActionStateStorage(actionStateStorage);
        ConnStateStorage connStateStorage = ConnStateStorage.getInstance(this.runNFs,this);
        ((ConnMsgProcessor)operationManager.getConnMsgProcessors()).addConnStateStorage(connStateStorage);

    }

    public void initialForwarding(){
        String curl_cmd1 = "{\"switch\":\""+this.switchid+"\",\"name\":\"flow-mod-1\",\"in_port\":\""+this.replayPort+"\",\"active\":\"true\", \"actions\":\"output="+this.NF1Input+"\"}";
        String[] cmd1={"curl","-X", "POST","-d", curl_cmd1,"http://127.0.0.1:8080/wm/staticflowpusher/json"};

        System.out.println(cmd1);

        System.out.println(execCurl(cmd1));

        String curl_cmd2 = "{\"switch\":\""+this.switchid+"\",\"name\":\"flow-mod-2\",\"in_port\":\""+this.NF1Output+"\",\"active\":\"true\", \"actions\":\"output="+this.NF2Input+"\"}";
        String[] cmd2={"curl","-X", "POST","-d", curl_cmd2,"http://127.0.0.1:8080/wm/staticflowpusher/json"};

        System.out.println(cmd2);
        System.out.println(execCurl(cmd2));

        String curl_cmd3 = "{\"switch\":\""+this.switchid+"\",\"name\":\"flow-mod-3\",\"in_port\":\""+this.NF2Output+"\",\"active\":\"true\", \"actions\":\"output="+this.NF3Input+"\"}";
        String[] cmd3={"curl","-X", "POST","-d", curl_cmd3,"http://127.0.0.1:8080/wm/staticflowpusher/json"};

        System.out.println(cmd3);
        System.out.println(execCurl(cmd3));
    }

    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;

    }

    public void executeStep(int step) {
        this.traceLoad = new TraceLoad(this.traceHost, this.traceRate , this.traceNumPkts);
        int startNextAfter;
        switch(step)
        {
            case 0:
                startNextAfter = 2;
                break;
            case 1:
                startMove();
                initialForwarding();
                boolean started = this.traceLoad.startTrace(this.traceFile);
                if (started)
                { logger.info("Started replaying trace"); }
                else
                { logger.error("Failed to start replaying trace"); }
                startNextAfter = 0;
                break;
            default:
                return;
        }
        this.scheduler.schedule(new NextStepTask(step+1, this), startNextAfter,
                TimeUnit.SECONDS);


    }

    @Override
    public void changeForwarding() {
    }

    public void run() {
        operationManager.addProcessCondition(this);
    }

}
