package zmove;

import Server.OperationManager;
import interfaces.HwProtoParameters;
import interfaces.NetworkFunction;
import interfaces.ProtoParameters;
import interfaces.msgprocessors.Perflow.ActionProcessPerflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyActionMessageProto;
import proto.MyConnMessageProto;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:27
 * @Description:
 */
public class ActionMsgProcessor extends ActionProcessPerflow {
    private volatile int receiveCount;
    private volatile int count;
    private volatile int totalnum ;
    private ActionStateStorage actionStateStorage;
    private ExecutorService threadPool;
    //private ConcurrentLinkedQueue<ActionStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ActionMsgProcessor.class);

    public ActionMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.count = 0;
        //this.statesList = new ConcurrentLinkedQueue<ActionStateChunk>();
    }

    public void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState) {
        receiveCount++;
        logger.info("action num:"+ receiveCount);
        //showActionState(actionState);
        //logger.info("action receive state current time "+actionState.getCxid());
        ActionStateChunk actionStateChunk = new ActionStateChunk(actionStateStorage.getDst(), actionState);
        threadPool.submit(actionStateChunk);

    }

    public void getActionPerflowAck(MyActionMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg) {
        totalnum = actionGetPerflowAckMsg.getCount();
        logger.info("getPerflowAck action totalnum:"+ totalnum);
        //logger.info("getPerflowAck action count:"+ count);
        if(totalnum == count){
            setActionStateStorageAck();
        }

    }

    public void putActionPerflowAck(MyActionMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg) {
        count++;
        //System.out.println("connection put perflow count"+count);
        //logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        //logger.info("action put perflow cxid"+ actionPutPerflowAckMsg.getCxid());
        //logger.info("action put perflow count"+ count);
        logger.info("action put perflow totalnum"+totalnum);
        logger.info("action put perflow num"+count);
        if(totalnum == count){
            setActionStateStorageAck();
        }
    }

    public void sendActionGetPerflow(NetworkFunction nf, String key) {
        logger.info("发送了action getperflow");
        MyActionMessageProto.MyActionMessage myMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionGetPerflowMsgType)
                .setActionGetPerflowMsg(MyActionMessageProto.ActionGetPerflowMsg.newBuilder()
                        .setHwProto(HwProtoParameters.TYPE_IPv4)
                        .setProto(ProtoParameters.PROTOCOL_TCP).build())
                .build();

        nf.getActionChannel().sendMessage(myMessage);
    }

    public void addActionStateStorage(ActionStateStorage actionStateStorage){
        //logger.info("添加了connection storage");
        this.actionStateStorage = actionStateStorage;
    }

    public void setActionStateStorageAck(){
        logger.info("set a ActionStorage Ack");
        this.actionStateStorage.setAck();
    }

    public void showActionState(MyActionMessageProto.ActionState actionState){
        logger.info("actionstate start time"+ actionState.getStartTime());
        logger.info("action last packet time"+actionState.getLastPktTime());
        logger.info("action cxid"+actionState.getCxid());
        logger.info("action reversed"+actionState.getReversed());
        logger.info("action af"+actionState.getAf());
        logger.info("action s_total_pkts"+actionState.getSTotalPkts());
        logger.info("action s_total_bytes"+actionState.getSTotalBytes());
        logger.info("action d_total_pkts"+actionState.getDTotalPkts());
        logger.info("action d_total_pkts"+actionState.getDTotalBytes());
        logger.info("action s_tcp_flas"+actionState.getSTcpFlags());
        logger.info("action pad"+actionState.getPad());
        logger.info("action d_tcp_flags"+actionState.getDTcpFlags());
        logger.info("action check"+actionState.getCheck());
        logger.info("action hash"+actionState.getHash());
    }
}
