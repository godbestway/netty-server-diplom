package zmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyMessageProto;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 18:19
 * @Description:
 */
public class ActionStateChunk implements Callable<Boolean> {
    private NetworkFunction dst;
    //Todo for Multiflow
    private MyMessageProto.ActionState actionState;

    protected static Logger logger = LoggerFactory.getLogger(ActionStateChunk.class);

    public ActionStateChunk(NetworkFunction dst,MyMessageProto.ActionState actionState ) {
        this.dst = dst;
        this.actionState = actionState;
    }


    public Boolean call() throws Exception {
        //logger.info("ActionStateChuck call"+System.currentTimeMillis()+" actionState"+actionState.getData());
        MyMessageProto.MyMessage putPerflowMessage = null;
        putPerflowMessage = MyMessageProto.MyMessage.newBuilder()
                .setDataType(MyMessageProto.MyMessage.DataType.ActionPutPerflowMsgType)
                .setActionPutPerflowMsg(MyMessageProto.ActionPutPerflowMsg.
                        newBuilder().setState(this.actionState).build())
                .build();

        //logger.info("send a action putPerflowMsg actionState"+actionState.getData());
        this.dst.getActionChannel().sendMessage(putPerflowMessage);

        return true;
    }

}
