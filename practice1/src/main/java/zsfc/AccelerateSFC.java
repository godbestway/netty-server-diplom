package zsfc;

import Server.OperationManager;
import interfaces.stepControl.ProcessCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccelerateSFC {
    protected static Logger logger = LoggerFactory.getLogger(AccelerateSFC.class);

    public static void main(String[] args) {
        ConnMsgProcessor connMsgProcessors = new ConnMsgProcessor();
        //ActionMsgProcessor actionMsgProcessor = new ActionMsgProcessor();
        OperationManager operationManager = new OperationManager(connMsgProcessors, null);

        try {
            operationManager.run1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProcessCondition sfcProcessControl = new SFCProcessControl(operationManager);
        new Thread((Runnable) sfcProcessControl).start();

        synchronized (operationManager){
            while(OperationManager.serverSet != 2){
                try {
                    operationManager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println("netty server is set up");
            logger.info("netty server is set up");
        }

    }
}
