package zconnacmove;

import Server.OperationManager;
import interfaces.HwProtoParameters;
import interfaces.NetworkFunction;
import interfaces.ProtoParameters;
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
import java.util.concurrent.*;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:27
 * @Description:
 */
public class MoveProcessControl implements ProcessControl, ProcessCondition, Runnable {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final int numInstances = 2;
    private Map<String, NetworkFunction> runNFs;
    private OperationManager operationManager;
    public static boolean isFirstRecv = false;
    public static long movestart;
    //public static long movestart2;
    private CountDownLatch latch;
    //private static CyclicBarrier cyclicBarrier;
    protected static Logger logger = LoggerFactory.getLogger(MoveProcessControl.class);
    private TraceLoad traceLoad;
    protected short traceSwitchPort;
    private String traceHost;
    private short tracePort;
    private String traceFile;
    private int traceRate;
    private int traceNumPkts;
    private int operationDelay;
    private int stopDelay;
    private int advanced;
    private String switchid;
    private int replayPort;
    private int srcPort;
    private int dstPort;
    //private String replayNF;

    public MoveProcessControl() {
        parseConfigFile();
    }

    public MoveProcessControl(OperationManager operationManager){
        runNFs = new HashMap<String, NetworkFunction>();
        this.operationManager = operationManager;
        //this.movestart2 = -1;
        //latch = new CountDownLatch(2);
        //cyclicBarrier = new CyclicBarrier(1);
        parseConfigFile();
        if(advanced == 1){
            logger.info("advanced = 1, countDownlatch = 1");
            latch = new CountDownLatch(1);
        }else{
            latch = new CountDownLatch(2);
        }
    }

    public void parseConfigFile(){
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/sharestate/config.properties");
            prop.load(fileInputStream);
            this.traceSwitchPort = Short.parseShort(prop.getProperty("TraceReplaySwitchPort"));
            this.traceHost = prop.getProperty("TraceReplayHost");
            this.traceFile = prop.getProperty("TraceReplayFile");
            this.traceRate = Short.parseShort(prop.getProperty("TraceReplayRate"));
            this.traceNumPkts  = Integer.parseInt(prop.getProperty("TraceReplayNumPkts"));
            this.operationDelay= Integer.parseInt(prop.getProperty("OperationDelay"));
            logger.info("operationdelay"+operationDelay);
            this.stopDelay= Integer.parseInt(prop.getProperty("StopDelay"));
            this.advanced = Integer.parseInt(prop.getProperty("AdvanceMode"));
            logger.info("advanced: "+advanced);
            this.switchid = prop.getProperty("Switchid");
            logger.info("switchid"+switchid);
            this.replayPort = Integer.parseInt(prop.getProperty("TraceReplaySwitchPort"));
            this.srcPort = Integer.parseInt(prop.getProperty("TraceReplaySrcPort"));
            this.dstPort = Integer.parseInt(prop.getProperty("TraceReplayDstPort"));
            //this.replayNF = prop.getProperty("TraceReplayNF");

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
        ConnStateStorage connStateStorage = ConnStateStorage.getInstance(runNFs.get("nf2"), this);
        ((ConnMsgProcessor)operationManager.getConnMsgProcessors()).addConnStateStorage(connStateStorage);
        ActionStateStorage actionStateStorage = ActionStateStorage.getInstance(runNFs.get("nf2"), this, this.advanced);
        ((ActionMsgProcessor)operationManager.getActionMsgProcessors()).addActionStateStorage(actionStateStorage);
        //movestart = System.currentTimeMillis();
        //receiveDoubleAck();

        new Thread(new Runnable() {
            public void run() {
                /*try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }*/
                operationManager.getConnMsgProcessors().sendConnGetPerflow(runNFs.get("nf1"),
                        HwProtoParameters.TYPE_IPv4, ProtoParameters.PROTOCOL_TCP, 1);
            }
        }).start();

        receiveDoubleAck();


        //only for advanced prads
        //if(this.advanced == 1 && actionStateStorage.getStatesList().size() != 0) {
        //    logger.info("release all action state");
        //    logger.info("stateslist size" + actionStateStorage.getStatesList().size());
            try {
                actionStateStorage.getThreadPool().invokeAll(actionStateStorage.getStatesList());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}

        //this.threadPool.invokeAll(this.statesList);

    }

    public void receiveDoubleAck(){
        try {
            latch.await();
            //logger.info("receive double ack"+System.currentTimeMillis());
            changeForwarding();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initialForwarding(){
        String curl_cmd = "{\"switch\":\""+this.switchid+"\",\"name\":\"flow-mod-1\",\"in_port\":\""+this.replayPort+"\",\"active\":\"true\", \"actions\":\"output="+this.srcPort+"\"}";
        String[] cmd={"curl","-X", "POST","-d", curl_cmd,"http://127.0.0.1:8080/wm/staticflowpusher/json"};

        //String[] cmd={"curl","-X", "POST","-d", "{\"switch\":\"00:00:00:00:00:00:00:01\",\"name\":\"flow-mod-1\"," +
        //        "\"in_port\":\"1\",\"active\":\"true\", \"actions\":\"output=2\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};
        /*String[] cmd2={"curl","-X", "POST","-d", "{\"switch\":\"00:00:00:00:00:00:00:01\",\"name\":\"flow-mod-1\"," +
                        "\"in_port\":\"1\",\"active\":\"true\", \"actions\":\"output=2\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};
        for(int i = 0; i< cmd.length; i++){
            System.out.println(cmd[i]);
            System.out.println(cmd2[i]);
            if(!cmd[i].equals(cmd2[i])){
                System.out.println(cmd[i]);
            }
        }*/
        System.out.println(execCurl(cmd));
    }

    public void deleteForwarding(){
        String[] cmd={"curl","-X", "DELETE","-d", "{\"name\":\"flow-mod-1\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};
        System.out.println(execCurl(cmd));
    }

    public void changeForwarding() {
        long movetime = System.currentTimeMillis() - this.movestart;

        logger.info("begin to change forward direction");
        String curl_cmd = "{\"switch\":\""+this.switchid+"\",\"name\":\"flow-mod-1\",\"in_port\":\""+this.replayPort+"\",\"active\":\"true\", \"actions\":\"output="+this.dstPort+"\"}";
        String[] cmd={"curl","-X", "POST","-d", curl_cmd,"http://127.0.0.1:8080/wm/staticflowpusher/json"};
        System.out.println(execCurl(cmd));
        //logger.info("total move time"+movetime);
	    logger.info(String.format("[MOVE_TIME] elapse=%d ", movetime));
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
                initialForwarding();
                boolean started = this.traceLoad.startTrace(this.traceFile);
                if (started)
                { logger.info("Started replaying trace"); }
                else
                { logger.error("Failed to start replaying trace"); }
                startNextAfter = this.operationDelay;
                break;
            case 2:
                //System.out.println("线程开始了");
                //deleteForwarding();
                logger.info("a simulation of move start");
                startMove();
                startNextAfter = 0;
                break;
            default:
                return;
        }
        this.scheduler.schedule(new NextStepTask(step+1, this), startNextAfter,
                TimeUnit.SECONDS);


    }


    public void run() {
        operationManager.addProcessCondition(this);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}
