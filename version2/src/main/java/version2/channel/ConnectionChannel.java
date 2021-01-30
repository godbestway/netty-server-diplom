package version2.channel;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version2.zmove.single.ConnMsgProcessor;
import version2.zmove.single.OperationManager;
import version2.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:11
 * @Description:
 */
public class ConnectionChannel extends BaseChannel {
    protected static Logger logger = LoggerFactory.getLogger(ConnectionChannel.class);

    public ConnectionChannel(Channel channel, OperationManager operationManager) {

        super(channel, operationManager);
    }


    protected void processMessage(Object msg) {
        logger.info("process message begin");
        ConnMsgProcessor connMsgProcess = (ConnMsgProcessor) operationManager.getConnMsgProcessors();

      if(msg instanceof SynProto.Syn){
            //System.out.println("syn message comes");
            logger.info("syn message comes");
            SynProto.Syn syn = (SynProto.Syn) msg;
            this.host = syn.getHost() ;
            this.pid = syn.getPid();
            operationManager.channelConnected(this);
        }else if(msg instanceof ConnStateProto.ConnState){
            logger.info("receive a connstate"+System.currentTimeMillis());
            connMsgProcess.receiveConnStatePerflow((ConnStateProto.ConnState)msg);

        }else if(msg instanceof ConnGetPerflowAckMsgProto.ConnGetPerflowAckMsg){
            logger.info("receive a  conn getAck"+System.currentTimeMillis());
            connMsgProcess.getConnPerflowAck((ConnGetPerflowAckMsgProto.ConnGetPerflowAckMsg) msg);
        }else if(msg instanceof ConnPutPerflowAckMsgProto.ConnPutPerflowAckMsg){
            logger.info("receive a conn putAck"+System.currentTimeMillis());
            connMsgProcess.putConnPerflowAck((ConnPutPerflowAckMsgProto.ConnPutPerflowAckMsg)msg);
        }

        /*System.out.println(msg.toString());
        InformationProto.Information information=(InformationProto.Information)msg;
        System.out.println("具体数据内容:"+information.getContent());*/
    }

    public void sendMessage(Object msg) {
        /*GetPerflowProto.GetPerflowMsg getPerflowMsg = GetPerflowProto.GetPerflowMsg.newBuilder()
                .setKey("all").build();*/

        channel.writeAndFlush(msg);
    }
}
