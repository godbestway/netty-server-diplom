package version1.channel;

import io.netty.channel.Channel;
import version1.OperationManager;
import version1.proto.object.InformationProto;
import version1.proto.object.PersonProto;
import version1.proto.object.SynProto;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:12
 * @Description:
 */
public class ActionChannel extends BaseChannel{


    public ActionChannel(Channel channel, OperationManager operationManager) {
        super(channel, operationManager);
    }

    protected void processMessage(Object msg) {
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
        }
    }


    public void sendMessage(Object msg) {

    }
}
