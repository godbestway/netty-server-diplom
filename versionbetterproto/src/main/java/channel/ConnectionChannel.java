package channel;

import Server.OperationManager;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyMessageProto;
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

    protected void processMessage(MyMessageProto.MyMessage myMessage) {
        ConnMsgProcessor connMsgProcess = operationManager.getConnMsgProcessors();

       MyMessageProto.MyMessage.DataType dataType = myMessage.getDataType();
        if(dataType == MyMessageProto.MyMessage.DataType.PersonType){
            MyMessageProto.Person person = myMessage.getPerson();
            System.out.println("name "+person.getName());
            System.out.println("address "+person.getAddress());
            System.out.println("age "+ person.getAge());
        }
        else if(dataType == MyMessageProto.MyMessage.DataType.SynType){
            MyMessageProto.Syn syn = myMessage.getSyn();
            this.host = syn.getHost() ;
            this.pid = syn.getPid();
            operationManager.channelConnected(this);
        }else if(dataType == MyMessageProto.MyMessage.DataType.ConnStateType){
            //logger.info("receive a connstate"+System.currentTimeMillis());
            connMsgProcess.receiveConnStatePerflow(myMessage.getConnState());

        }else if(dataType == MyMessageProto.MyMessage.DataType.ConnGetPerflowAckMsgType){
            //logger.info("receive a  conn getAck"+System.currentTimeMillis());
            connMsgProcess.getConnPerflowAck(myMessage.getConnGetPerflowAckMsg());
        }else if(dataType == MyMessageProto.MyMessage.DataType.ConnPutPerflowAckMsgType){
            //logger.info("receive a  putAck"+System.currentTimeMillis());
            connMsgProcess.putConnPerflowAck(myMessage.getConnPutPerflowAckMsg());
        }

    }

    public void sendMessage(Object msg) {
        channel.writeAndFlush(msg);
    }
}
