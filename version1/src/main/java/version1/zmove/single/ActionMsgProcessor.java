package version1.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version1.channel.ActionChannel;
import version1.interfaces.NetworkFunction;
import version1.interfaces.msgprocessors.perflow.ActionProcessPerflow;
import version1.proto.object.*;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 19:43
 * @Description:
 */
public class ActionMsgProcessor extends ActionProcessPerflow {
    private ActionStateStorage actionStateStorage;
    private volatile int count ;
    private volatile int totalnum ;
    private ExecutorService threadPool;
    private ConcurrentLinkedQueue<ActionStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ActionMsgProcessor.class);

    public ActionMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.statesList = new ConcurrentLinkedQueue<ActionStateChunk>();
    }

    public void receiveActionStatePerflow(ActionStateProto.ActionState actionState) {

        logger.info("action receive state current time"+System.currentTimeMillis()+" data= "+actionState.getData());

        ActionStateChunk actionStateChunk = null;
        actionStateChunk = new ActionStateChunk(actionStateStorage.getDst() ,actionState);
        logger.info("before send action state"+System.currentTimeMillis());
        threadPool.submit(actionStateChunk);
        logger.info("after send action state"+System.currentTimeMillis());
    }


    public void releaseStates(){
        try {
            threadPool.invokeAll(statesList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getActionPerflowAck(ActionGetPerflowAckMsgProto.ActionGetPerflowAckMsg msg) {
        totalnum = msg.getCount();
        //System.out.println("action totalnum:"+ totalnum);
        logger.info("action totalnum:"+ totalnum);
    }

    public void putActionPerflowAck(ActionPutPerflowAckMsgProto.ActionPutPerflowAckMsg msg) {
        count++;
        //System.out.println("action put perflow count"+count);
        logger.info("action put perflow current time"+System.currentTimeMillis());
        logger.info("action put perflow count"+count);
        logger.info("action put perflow totalnum"+totalnum);
        if(count == totalnum){
            setActionStateStorageAck();
        }
    }

    public void sendActionGetPerflow(NetworkFunction nf, String key) {
        //System.out.println("发送了action getperflow");
        logger.info("发送了action getperflow");
        ActionGetPerflowMsgProto.ActionGetPerflowMsg actionGetPerflowMsg = ActionGetPerflowMsgProto.ActionGetPerflowMsg
                .newBuilder().setKey(key).build();
        nf.getActionChannel().sendMessage(actionGetPerflowMsg);

    }
    public void addActionStateStorage(ActionStateStorage actionStateStorage){
        //System.out.println("添加了action storage");
        logger.info("添加了action storage");
        this.actionStateStorage = actionStateStorage;
    }
    public void setActionStateStorageAck(){
        //System.out.println("test receive ack process");
        logger.info("test receive ack process");
        this.actionStateStorage.setAck();
    }

}
