package version1.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;

import io.netty.util.AttributeKey;
import version1.OperationManager;
import version1.proto.object.InformationProto;
import version1.proto.object.PersonProto;

/**
 * @Author: Chenglin Ding
 * @Date: 29.12.2020 16:58
 * @Description:
 */
public abstract class BaseChannelHandler extends ChannelInboundHandlerAdapter{
    protected OperationManager operationManager;

    public BaseChannelHandler(OperationManager operationManager){
        this.operationManager =operationManager;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  throws Exception{
        Attribute<BaseChannel> attr = ctx.attr(AttributeMapConstant.NETTY_CHANNEL_KEY);
        BaseChannel baseChannel = (BaseChannel)attr.get();

        try {
            baseChannel.processMessage(msg);

        }catch (Exception e ){
            System.out.println("something went wrong"+e);
        }
    }

    @Override
    public abstract  void handlerAdded(ChannelHandlerContext ctx) throws Exception;
}
