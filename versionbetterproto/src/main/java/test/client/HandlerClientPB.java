package test.client;

import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import proto.InformationProto;
import proto.MyMessageProto;


/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 12:09
 * @Description:
 */
public class HandlerClientPB extends SimpleChannelInboundHandler<InformationProto.Information> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InformationProto.Information msg) throws Exception
    {
        //读取消息，得到反序列后的实体对象
        System.out.println(msg.getPersonnum());
        System.out.println(msg.getContent());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        /**
         * @Author 江成军
         * @Date 2020/6/1 11:20
         * @Description  处理I/O事件的异常
         **/
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        MyMessageProto.MyMessage myMessage = null;
        myMessage = MyMessageProto.MyMessage.newBuilder()
                .setDataType(MyMessageProto.MyMessage.DataType.PersonType)
                .setPerson(MyMessageProto.Person.newBuilder()
                        .setName("xiaolin")
                        .setAddress("haydn")
                        .setAge(20).build())
                .build();


        ctx.writeAndFlush(myMessage);

    }


}
