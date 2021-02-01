package zmove;

import Server.OperationManager;
import interfaces.NetworkFunction;
import interfaces.stepControl.NextStepTask;
import interfaces.stepControl.ProcessCondition;
import interfaces.stepControl.ProcessControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:27
 * @Description:
 */
public class MoveProcessControl implements ProcessControl, ProcessCondition, Runnable {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final int numInstances = 1;
    private Map<String, NetworkFunction> runNFs;
    private OperationManager operationManager;
    public static long movestart;
    //public static long movestart2;
    private CountDownLatch latch;
    private static CyclicBarrier cyclicBarrier;
    protected static Logger logger = LoggerFactory.getLogger(MoveProcessControl.class);

    public MoveProcessControl(OperationManager operationManager){
        runNFs = new HashMap<String, NetworkFunction>();
        this.operationManager = operationManager;
        this.movestart = -1;
        //this.movestart2 = -1;
        latch = new CountDownLatch(2);
        cyclicBarrier = new CyclicBarrier(1);
    }


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

    public void NFConnected(NetworkFunction nf) {
        if(!this.runNFs.containsValue(nf)){
            this.addNetworkFunction(nf);
        }
    }

    public void startMove(){
        ConnStateStorage connStateStorage = ConnStateStorage.getInstance(runNFs.get("nf1"), this);
        operationManager.getConnMsgProcessors().addConnStateStorage(connStateStorage);
        ActionStateStorage actionStateStorage = ActionStateStorage.getInstance(runNFs.get("nf1"), this);
        operationManager.getActionMsgProcessors().addActionStateStorage(actionStateStorage);
        //movestart = System.currentTimeMillis();
        //receiveDoubleAck();

        new Thread(new Runnable() {
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                operationManager.getConnMsgProcessors().sendConnGetPerflow(runNFs.get("nf1"), "all");
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
            logger.info("receive double ack"+System.currentTimeMillis());
            changeForwarding();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeForwarding() {
        long endMovetime = System.currentTimeMillis();
        long movetime = System.currentTimeMillis() - this.movestart;


        logger.info("begin to change forward direction");
        logger.info("end move time"+endMovetime);
        logger.info("total move time"+movetime);
    }


    public void executeStep(int step) {
        int startNextAfter = 0;
        switch(step)
        {
            case 0:
                startNextAfter = 2;
                break;
            case 1:
                //System.out.println("线程开始了");
                logger.info("a simulation of move start");
                startMove();
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
