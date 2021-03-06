package version2.channel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version2.zmove.single.OperationManager;

/**
 * @Author: Chenglin Ding
 * @Date: 29.12.2020 16:58
 * @Description:
 */
public abstract class BaseChannelHandler extends ChannelInboundHandlerAdapter{
    protected static Logger logger = LoggerFactory.getLogger(BaseChannelHandler.class);

    protected OperationManager operationManager;

    public BaseChannelHandler(OperationManager operationManager){
        this.operationManager =operationManager;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  throws Exception{
        Attribute<BaseChannel> attr = ctx.attr(AttributeMapConstant.NETTY_CHANNEL_KEY);
        BaseChannel baseChannel = (BaseChannel)attr.get();

        try {
            logger.info("channel read");
            baseChannel.processMessage(msg);

        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Override
    public abstract  void handlerAdded(ChannelHandlerContext ctx) throws Exception;
}
