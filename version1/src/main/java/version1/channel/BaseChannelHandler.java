package version1.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import version1.proto.object.InformationProto;
import version1.proto.object.PersonProto;

/**
 * @Author: Chenglin Ding
 * @Date: 29.12.2020 16:58
 * @Description:
 */
public abstract class BaseChannelHandler extends ChannelInboundHandlerAdapter{

    @Override
    public abstract void channelRead(ChannelHandlerContext ctx, Object msg)  throws Exception;

    @Override
    public abstract  void handlerAdded(ChannelHandlerContext ctx) throws Exception;
}
