package version2.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version2.interfaces.NetworkFunction;
import version2.proto.object.*;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 16.01.2021 18:15
 * @Description:
 */
public class ActionStateChunk implements Callable<Boolean> {
    private NetworkFunction dst;
    //Todo for Multiflow
    private ActionStateProto.ActionState actionState;

    protected static Logger logger = LoggerFactory.getLogger(ActionStateChunk.class);

    public ActionStateChunk(NetworkFunction dst,ActionStateProto.ActionState actionState ) {
        this.dst = dst;
        this.actionState = actionState;
    }


    public Boolean call() throws Exception {
        logger.info("ActionStateChuck call"+System.currentTimeMillis()+" actionState"+actionState.getCxid());
        ActionPutPerflowProto.ActionPutPerflowMsg actionPutPerflowMsg = ActionPutPerflowProto.ActionPutPerflowMsg
                .newBuilder().setState(this.actionState).build();

        //System.out.println("send putperflow");
        logger.info("send a action putPerflowMsg actionState"+actionState.getCxid());
        this.dst.getActionChannel().sendMessage(actionPutPerflowMsg);

        return true;
    }

}
