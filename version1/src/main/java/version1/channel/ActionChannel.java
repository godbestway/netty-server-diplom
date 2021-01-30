package version1.channel;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version1.proto.object.*;
import version1.zmove.single.ActionMsgProcessor;
import version1.server.OperationManager;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:12
 * @Description:
 */
public class ActionChannel extends BaseChannel{
    protected static Logger logger = LoggerFactory.getLogger(ActionChannel.class);


    public ActionChannel(Channel channel, OperationManager operationManager) {
        super(channel, operationManager);
    }

    protected void processMessage(Object msg) {
        ActionMsgProcessor actionMsgProcessor = (ActionMsgProcessor) operationManager.getActionMsgProcessors();

        if(msg instanceof SynProto.Syn){
            //System.out.println("syn message comes");
            logger.info("syn message comes");
            SynProto.Syn syn = (SynProto.Syn) msg;
            this.host = syn.getHost() ;
            this.pid = syn.getPid();
            operationManager.channelConnected(this);
        }else if(msg instanceof ActionStateProto.ActionState){
            logger.info("receive a actionstate"+System.currentTimeMillis());
            actionMsgProcessor.receiveActionStatePerflow((ActionStateProto.ActionState)msg);
        }else if(msg instanceof ActionGetPerflowAckMsgProto.ActionGetPerflowAckMsg){
            logger.info("receive a action get ack"+System.currentTimeMillis());
            actionMsgProcessor.getActionPerflowAck((ActionGetPerflowAckMsgProto.ActionGetPerflowAckMsg)msg);
        }else if(msg instanceof ActionPutPerflowAckMsgProto.ActionPutPerflowAckMsg){
            logger.info("receive a action put ack"+System.currentTimeMillis());
            actionMsgProcessor.putActionPerflowAck((ActionPutPerflowAckMsgProto.ActionPutPerflowAckMsg)msg);
        }
    }


    public void sendMessage(Object msg) {
        channel.writeAndFlush(msg);
    }
}
