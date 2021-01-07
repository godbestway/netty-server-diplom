package version1.client;


import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import version1.proto.object.InformationProto;


@ChannelHandler.Sharable
public class HandlerClientPB extends SimpleChannelInboundHandler<Object>
{
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception
    {
        //读取消息，得到反序列后的实体对象
        InformationProto.Information information=(InformationProto.Information)msg;
        System.out.println("具体数据内容:"+information.getContent());

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

        InformationProto.Information information=InformationProto.Information.newBuilder()
                .setPersonnum(178)
                .setContent("hello")
                .build();
        ctx.writeAndFlush(information);

    }
}

