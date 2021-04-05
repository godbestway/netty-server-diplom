package zconnaccopy;

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
    private MyActionMessageProto.ActionMultiState actionMultiState;
    private MyActionMessageProto.ActionAllState actionAllState;

    protected static Logger logger = LoggerFactory.getLogger(ActionStateChunk.class);

    public ActionStateChunk(NetworkFunction dst,MyActionMessageProto.ActionState actionState ) {
        this.dst = dst;
        this.actionState = actionState;
    }

    public ActionStateChunk(NetworkFunction dst,MyActionMessageProto.ActionMultiState actionMultiState) {
        this.dst = dst;
        this.actionMultiState = actionMultiState;
    }

    public ActionStateChunk(NetworkFunction dst,MyActionMessageProto.ActionAllState actionAllState ) {
        this.dst = dst;
        this.actionAllState = actionAllState;
    }

    /**
     * Use the putPerflow send the state to the destination
     */
    public Boolean call() throws Exception {
        //logger.info("ActionStateChuck call"+System.currentTimeMillis()+" actionState"+actionState.getData());
        MyActionMessageProto.MyActionMessage putPerflowMessage = null;
        if(this.actionState != null) {
            putPerflowMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                    .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionPutPerflowMsgType)
                    .setActionPutPerflowMsg(MyActionMessageProto.ActionPutPerflowMsg.
                            newBuilder().setState(this.actionState).build())
                    .build();
        }else if(this.actionMultiState != null){
            putPerflowMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                    .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionPutMultiflowMsgType)
                    .setActionPutMultiflowMsg(MyActionMessageProto.ActionPutMultiflowMsg.
                            newBuilder().setMultiState(this.actionMultiState).build())
                    .build();
        }else if(this.actionAllState != null){
            putPerflowMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                    .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionPutAllflowMsgType)
                    .setActionPutAllflowMsg(MyActionMessageProto.ActionPutAllflowMsg.
                            newBuilder().setAllState(this.actionAllState).build())
                    .build();
        }


        //logger.info("send a action putPerflowMsg actionState"+actionState.getData());
        this.dst.getActionChannel().sendMessage(putPerflowMessage);

        return true;
    }

}
