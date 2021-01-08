package version1.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import version1.OperationManager;
import version1.proto.object.InformationProto;
import version1.proto.object.PersonProto;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 20:21
 * @Description:
 */
public class ActionChannelHandler extends BaseChannelHandler {


    public ActionChannelHandler(OperationManager operationManager) {
        super(operationManager);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
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

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //新建立连接时触发的动作
        Channel incoming=ctx.channel();
        System.out.println("客户端："+incoming.remoteAddress()+"已连接上来");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        //出现异常的时候执行的动作（打印并关闭通道）
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception
    {
        //连接断开时触发的动作
        Channel incoming=ctx.channel();
        System.out.println("客户端："+incoming.remoteAddress()+"已断开");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        //通道处于活动状态触发的动作，该方法只会在通道建立时调用一次
        Channel incoming=ctx.channel();
        System.out.println("客户端："+incoming.remoteAddress()+"在线");

        System.out.println("msg send");
        PersonProto.Person guy =   PersonProto.Person.newBuilder()
                .setName("xiaofei")
                .setAge(18)
                .setAddress("str").build();

        System.out.println(guy.getSerializedSize());
        ctx.writeAndFlush(guy);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        //通道处于非活动状态触发的动作，该方法只会在通道失效时调用一次
        Channel incoming=ctx.channel();
        System.out.println("客户端："+incoming.remoteAddress()+"掉线");
    }
}
