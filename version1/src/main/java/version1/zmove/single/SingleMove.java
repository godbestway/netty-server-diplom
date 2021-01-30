package version1.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version1.interfaces.stepControl.ProcessCondition;
import version1.server.OperationManager;

/**
 * @Author: Chenglin Ding
 * @Date: 25.01.2021 23:16
 * @Description:
 */
public class SingleMove {
    protected static Logger logger = LoggerFactory.getLogger(SingleMove.class);

    public static void main(String[] args)  throws Exception
    {
        ConnMsgProcessor connMsgProcessors = new ConnMsgProcessor();
        ActionMsgProcessor actionMsgProcessors = new ActionMsgProcessor();
        OperationManager operationManager = new OperationManager(connMsgProcessors,actionMsgProcessors);
        operationManager.run();
        ProcessCondition moveProcessControl = new MoveProcessControl(operationManager);
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
