package channel;

import Server.OperationManager;
import interfaces.msgprocessors.Perflow.ActionProcessPerflow;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.InformationProto;
import proto.MyMessageProto;
import zmove.ConnMsgProcessor;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:13
 * @Description:
 */
public class ActionChannel extends BaseChannel{
    protected static Logger logger = LoggerFactory.getLogger(ActionChannel.class);


    public ActionChannel(Channel channel, OperationManager operationManager) {
        super(channel, operationManager);
    }

    protected void processMessage(MyMessageProto.MyMessage myMessage) {
        ActionProcessPerflow actionMsgProcess = operationManager.getActionMsgProcessors();
        MyMessageProto.MyMessage.DataType dataType = myMessage.getDataType();
        if(dataType == MyMessageProto.MyMessage.DataType.PersonType){
            MyMessageProto.Person person = myMessage.getPerson();
            System.out.println("name "+person.getName());
            System.out.println("address "+person.getAddress());
            System.out.println("age "+ person.getAge());
        }
        else if(dataType == MyMessageProto.MyMessage.DataType.SynType){
            logger.info("syn message comes");
            MyMessageProto.Syn syn = myMessage.getSyn();
            this.host = syn.getHost() ;
            logger.info("host: "+this.host);
            this.pid = syn.getPid();
            logger.info("pid: "+this.pid);
            operationManager.channelConnected(this);
        }else if(dataType == MyMessageProto.MyMessage.DataType.ActionStateType){
            //logger.info("receive a connstate"+System.currentTimeMillis());
            actionMsgProcess.receiveActionStatePerflow(myMessage.getActionState());

        }else if(dataType == MyMessageProto.MyMessage.DataType.ActionGetPerflowAckMsgType){
            //logger.info("receive a  conn getAck"+System.currentTimeMillis());
            actionMsgProcess.getActionPerflowAck(myMessage.getActionGetPerflowAckMsg());
        }else if(dataType == MyMessageProto.MyMessage.DataType.ActionPutPerflowAckMsgType){
            //logger.info("receive a conn putAck"+System.currentTimeMillis());
            actionMsgProcess.putActionPerflowAck(myMessage.getActionPutPerflowAckMsg());
        }

    }


    public void sendMessage(Object msg) {
        channel.writeAndFlush(msg);
    }
}
