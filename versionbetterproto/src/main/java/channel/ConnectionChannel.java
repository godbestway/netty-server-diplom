package channel;

import Server.OperationManager;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;
import zmove.ConnMsgProcessor;


/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:14
 * @Description:
 */
public class ConnectionChannel extends BaseChannel{
    protected static Logger logger = LoggerFactory.getLogger(ConnectionChannel.class);

    public ConnectionChannel(Channel channel, OperationManager operationManager) {
        super(channel, operationManager);
    }

    protected void processMessage(Object msg) {
        ConnMsgProcessor connMsgProcess = operationManager.getConnMsgProcessors();

        MyConnMessageProto.MyConnMessage myMessage = (MyConnMessageProto.MyConnMessage)msg;
        MyConnMessageProto.MyConnMessage.DataType dataType = myMessage.getDataType();
        if(dataType == MyConnMessageProto.MyConnMessage.DataType.SynType){
            MyConnMessageProto.ConnSyn syn = myMessage.getConnsyn();
            this.host = syn.getHost() ;
            this.pid = syn.getPid();
            operationManager.channelConnected(this);
        }else if(dataType == MyConnMessageProto.MyConnMessage.DataType.ConnStateType){
            //logger.info("receive a connstate"+System.currentTimeMillis());
            connMsgProcess.receiveConnStatePerflow(myMessage.getConnState());

        }else if(dataType == MyConnMessageProto.MyConnMessage.DataType.ConnGetPerflowAckMsgType){
            logger.info("receive a  conn getAck"+System.currentTimeMillis());
            connMsgProcess.getConnPerflowAck(myMessage.getConnGetPerflowAckMsg());
        }else if(dataType == MyConnMessageProto.MyConnMessage.DataType.ConnPutPerflowAckMsgType){
            //logger.info("receive a  putAck"+System.currentTimeMillis());
            connMsgProcess.putConnPerflowAck(myMessage.getConnPutPerflowAckMsg());
        }

    }

    public void sendMessage(Object msg) {
        channel.writeAndFlush(msg);
    }
}
