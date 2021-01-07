package version1.channel;

import io.netty.channel.Channel;
import version1.OperationManager;
import version1.proto.object.InformationProto;
import version1.proto.object.PersonProto;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:11
 * @Description:
 */
public class ConnectionChannel extends BaseChannel {


    public ConnectionChannel(Channel channel) {
        super(channel);
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
        }

        /*System.out.println(msg.toString());
        InformationProto.Information information=(InformationProto.Information)msg;
        System.out.println("具体数据内容:"+information.getContent());*/
    }

    public void sendMessage(Object msg) {

    }
}
