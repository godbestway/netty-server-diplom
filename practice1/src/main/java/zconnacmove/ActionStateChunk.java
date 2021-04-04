package zconnacmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyActionMessageProto;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 18:19
 * @Description:
 */
public class ActionStateChunk implements Callable<Boolean> {
    private NetworkFunction dst;
    //Todo for Multiflow
    private MyActionMessageProto.ActionState actionState;

    protected static Logger logger = LoggerFactory.getLogger(ActionStateChunk.class);

    public ActionStateChunk(NetworkFunction dst,MyActionMessageProto.ActionState actionState ) {
        this.dst = dst;
        this.actionState = actionState;
    }

    /**
     * Use the putPerflow send the state to the destination
     */
    public Boolean call() throws Exception {
        //logger.info("ActionStateChuck call"+System.currentTimeMillis()+" actionState"+actionState.getData());
        MyActionMessageProto.MyActionMessage putPerflowMessage = null;
        putPerflowMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionPutPerflowMsgType)
                .setActionPutPerflowMsg(MyActionMessageProto.ActionPutPerflowMsg.
                        newBuilder().setState(this.actionState).build())
                .build();

        //logger.info("send a action putPerflowMsg actionState"+actionState.getData());
        this.dst.getActionChannel().sendMessage(putPerflowMessage);

        return true;
    }

}
