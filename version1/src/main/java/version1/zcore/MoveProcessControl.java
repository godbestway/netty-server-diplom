package version1.zcore;

import version1.interfaces.ProcessCondition;
import version1.interfaces.ProcessControl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 20:39
 * @Description:
 */
public class MoveProcessControl implements ProcessControl, ProcessCondition, Runnable {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final int numInstances = 1;
    private Map<String, NetworkFunction> runNFs;
    private OperationManager operationManager;

    public MoveProcessControl(OperationManager operationManager){
        runNFs = new HashMap<String, NetworkFunction>();
        this.operationManager = operationManager;
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
        operationManager.getConnMsgProcessors().sendGetPerflow(runNFs.get("nf1"), "all");
        ConnStateStorage connStateStorage = ConnStateStorage.getInstance(runNFs.get("nf1"));
        operationManager.getConnMsgProcessors().addConnStateStorage(connStateStorage);
    }

    public void executeStep(int step) {
        int startNextAfter = 0;
        switch(step)
        {
            case 0:
                startNextAfter = 5;
                break;
            case 1:
                System.out.println("线程开始了");
                startMove();
            default:
                return;
        }
        this.scheduler.schedule(new NextStepTask(step+1, this), startNextAfter,
                TimeUnit.SECONDS);
    }


    public void changeForwarding() {

    }

    public void run() {
        operationManager.addProcessCondition(this);
    }
}
