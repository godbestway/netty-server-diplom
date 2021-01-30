package zmove;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.Perflow.ActionProcessPerflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyMessageProto;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:27
 * @Description:
 */
public class ActionMsgProcessor extends ActionProcessPerflow {
    private volatile int count ;
    private volatile int totalnum ;
    private ActionStateStorage actionStateStorage;
    private ExecutorService threadPool;
    //private ConcurrentLinkedQueue<ActionStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ActionMsgProcessor.class);

    public ActionMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        //this.statesList = new ConcurrentLinkedQueue<ActionStateChunk>();
    }

    public void receiveActionStatePerflow(MyMessageProto.ActionState actionState) {
        //logger.info("conn receive state current time "+System.currentTimeMillis()+" data="+connState.getData());
        ActionStateChunk actionStateChunk = new ActionStateChunk(actionStateStorage.getDst(), actionState);
        threadPool.submit(actionStateChunk);

    }

    public void getActionPerflowAck(MyMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg) {
        totalnum = actionGetPerflowAckMsg.getCount();
        logger.info("action totalnum:"+ totalnum);
    }

    public void putActionPerflowAck(MyMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg) {
        count++;
        //System.out.println("connection put perflow count"+count);
        //logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        //logger.info("connection put perflow count"+count);
        //logger.info("connection put perflow totalnum"+totalnum);
        if(count == totalnum){
            setActionStateStorageAck();
        }
    }


    public void sendActionGetPerflow(NetworkFunction nf, String key) {
        logger.info("发送了action getperflow");
        MyMessageProto.MyMessage myMessage = MyMessageProto.MyMessage.newBuilder()
                .setDataType(MyMessageProto.MyMessage.DataType.ActionGetPerflowMsgType)
                .setActionGetPerflowMsg(MyMessageProto.ActionGetPerflowMsg.newBuilder()
                        .setKey(key).build())
                .build();

        nf.getActionChannel().sendMessage(myMessage);

    }

    public void addActionStateStorage(ActionStateStorage actionStateStorage){
        //logger.info("添加了connection storage");
        this.actionStateStorage = actionStateStorage;
    }

    public void setActionStateStorageAck(){
        //logger.info("set a stateStorage Ack");
        this.actionStateStorage.setAck();
    }
}
