package version1.channel;

import io.netty.channel.Channel;
import version1.zmove.single.ConnMsgProcessor;
import version1.zmove.single.OperationManager;
import version1.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:11
 * @Description:
 */
public class ConnectionChannel extends BaseChannel {


    public ConnectionChannel(Channel channel, OperationManager operationManager) {

        super(channel, operationManager);
    }


    protected void processMessage(Object msg) {
        ConnMsgProcessor connMsgProcess = (ConnMsgProcessor) operationManager.getConnMsgProcessors();

        if(msg instanceof InformationProto.Information){
            InformationProto.Information info = (InformationProto.Information)msg;
            System.out.println("具体内容:"+info.getContent());
            System.out.println("具体personnum:"+info.getPersonnum());
        }
        else if(msg instanceof  PersonProto.Person){
            PersonProto.Person person = (PersonProto.Person)msg;
            System.out.println("person name:"+person.getName());
            System.out.println("person age:"+person.getAge());
        }else if(msg instanceof SynProto.Syn){
            System.out.println("syn message comes");
            SynProto.Syn syn = (SynProto.Syn) msg;
            this.host = syn.getHost() ;
            this.pid = syn.getPid();
            operationManager.channelConnected(this);
        }else if(msg instanceof FlowStateProto.FlowState){
            connMsgProcess.receiveStatePerflow((FlowStateProto.FlowState)msg);
        }else if(msg instanceof GetPerflowAckProto.GetPerflowAckMsg){
            connMsgProcess.getPerflowAck((GetPerflowAckProto.GetPerflowAckMsg) msg);
        }else if(msg instanceof  PutPerflowAckMsgProto.PutPerflowAckMsg){
            connMsgProcess.putPerflowAck((PutPerflowAckMsgProto.PutPerflowAckMsg)msg);
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
