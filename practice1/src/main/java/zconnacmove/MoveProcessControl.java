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

    public MoveProcessControl() {
        parseConfigFile();
    }

    public MoveProcessControl(OperationManager operationManager){
        runNFs = new HashMap<String, NetworkFunction>();
        this.operationManager = operationManager;
        this.movestart = -1;
        //this.movestart2 = -1;
        latch = new CountDownLatch(2);
        //cyclicBarrier = new CyclicBarrier(1);
        parseConfigFile();
    }

    public void parseConfigFile(){
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/godbestway/IdeaProjects/practice1/src/main/java/traceload/config.properties");
            prop.load(fileInputStream);
            this.traceSwitchPort = Short.parseShort(prop.getProperty("TraceReplaySwitchPort"));
            this.traceHost = prop.getProperty("TraceReplayHost");
            this.traceFile = prop.getProperty("TraceReplayFile");
            this.traceRate = Short.parseShort(prop.getProperty("TraceReplayRate"));
            this.traceNumPkts  = Integer.parseInt(prop.getProperty("TraceReplayNumPkts"));
            System.out.println("traceNumPkts"+traceNumPkts);
            this.operationDelay= Integer.parseInt(prop.getProperty("OperationDelay"));
            System.out.println("operationdelay"+operationDelay);
            this.stopDelay= Integer.parseInt(prop.getProperty("StopDelay"));
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
        operationManager.getConnMsgProcessors().addConnStateStorage(connStateStorage);
        ActionStateStorage actionStateStorage = ActionStateStorage.getInstance(runNFs.get("nf2"), this);
        operationManager.getActionMsgProcessors().addActionStateStorage(actionStateStorage);
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
                        HwProtoParameters.TYPE_IPv4, ProtoParameters.PROTOCOL_TCP);
            }
        }).start();
        /*new Thread(new Runnable() {
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                logger.info("send a getperflow");
                operationManager.getActionMsgProcessors().sendActionGetPerflow(runNFs.get("nf1"), "all");
            }
        }).start();*/
        this.movestart = System.currentTimeMillis();
        receiveDoubleAck();
        //operationManager.getConnMsgProcessors().testSendPutFlow();
        //receiveDoubleAck();
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
        String[] cmd={"curl","-X", "POST","-d", "{\"switch\":\"00:00:00:00:00:00:00:01\",\"name\":\"flow-mod-1\"," +
                "\"in_port\":\"1\",\"active\":\"true\", \"actions\":\"output=2\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};
        System.out.println(execCurl(cmd));
    }

    public void deleteForwarding(){
        String[] cmd={"curl","-X", "DELETE","-d", "{\"name\":\"flow-mod-1\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};
        System.out.println(execCurl(cmd));
    }

    public void changeForwarding() {
        long movetime = System.currentTimeMillis() - this.movestart;

        logger.info("begin to change forward direction");
        String[] cmd={"curl","-X", "POST","-d", "{\"switch\":\"00:00:00:00:00:00:00:01\",\"name\":\"flow-mod-1\"," +
                "\"in_port\":\"1\",\"active\":\"true\", \"actions\":\"output=3\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};
        System.out.println(execCurl(cmd));
        logger.info("total move time"+movetime);
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
