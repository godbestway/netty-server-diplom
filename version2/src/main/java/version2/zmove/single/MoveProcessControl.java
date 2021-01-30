package version2.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version2.interfaces.NetworkFunction;
import version2.interfaces.stepControl.NextStepTask;
import version2.interfaces.stepControl.ProcessCondition;
import version2.interfaces.stepControl.ProcessControl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;


/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 20:39
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
    private static CyclicBarrier cyclicBarrier;
    protected static Logger logger = LoggerFactory.getLogger(MoveProcessControl.class);

    public MoveProcessControl(OperationManager operationManager){
        runNFs = new HashMap<String, NetworkFunction>();
        this.operationManager = operationManager;
        this.movestart = -1;
        //this.movestart2 = -1;
        latch = new CountDownLatch(2);
        cyclicBarrier = new CyclicBarrier(2);
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
        ConnStateStorage connStateStorage = ConnStateStorage.getInstance(runNFs.get("nf2"), this);
        operationManager.getConnMsgProcessors().addConnStateStorage(connStateStorage);
        ActionStateStorage actionStateStorage = ActionStateStorage.getInstance(runNFs.get("nf2"), this);
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
        new Thread(new Runnable() {
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                operationManager.getActionMsgProcessors().sendActionGetPerflow(runNFs.get("nf1"), "all");
            }
        }).start();
        this.movestart = System.currentTimeMillis();
        //operationManager.getConnMsgProcessors().testSendPutFlow();
        receiveDoubleAck();
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

    public void executeStep(int step) {
        int startNextAfter = 0;
        switch(step)
        {
            case 0:
                startNextAfter = 5;
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


    public void changeForwarding() {
        long endMovetime = System.currentTimeMillis();
        long movetime = System.currentTimeMillis() - this.movestart;


        logger.info("begin to change forward direction");
        //System.out.println("begin to change forward direction");
        logger.info("end move time"+endMovetime);
        logger.info("total move time"+movetime);
        //System.out.println("stateMove time"+stateMovetime);
        //System.out.println("stateMove time"+stateMovetime2);
    }

    public void run() {
        operationManager.addProcessCondition(this);
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}

/*new Thread(new Runnable() {
public void run() {
        System.out.println("begin to run");
        operationManager.getConnMsgProcessors().setConnStateStorageAck();
        }
        }).start();*/

/*new Thread(new Runnable() {
public void run() {
        System.out.println("begin to run");
        operationManager.getActionMsgProcessors().setActionStateStorageAck();
        }
        }).start();*/

 /*public void receiveActionStateAck(){
        System.out.println("wait to receive the action signal");
        this.processLock.lock();
        try {
            this.actionLock.await();
            changeForwarding();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            this.processLock.unlock();
        }
    }*/