package zconnaccopy;

import Server.OperationManager;
import interfaces.msgprocessors.ProcessReceiveMsg;
import interfaces.stepControl.ProcessCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Chenglin Ding
 * @Date: 01.02.2021 21:33
 * @Description:
 */
public class SingleCopy {
    protected static Logger logger = LoggerFactory.getLogger(SingleCopy.class);

    public static void main(String[] args) {
        ProcessReceiveMsg connMsgProcessors = new ConnMsgProcessor();
        ProcessReceiveMsg actionMsgProcessors = new ActionMsgProcessor();
        OperationManager operationManager = new OperationManager(connMsgProcessors,actionMsgProcessors);

        try {
            operationManager.run1();
            //operationManager.run2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProcessCondition moveProcessControl = new CopyProcessControl(operationManager);
        new Thread((Runnable) moveProcessControl).start();

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
