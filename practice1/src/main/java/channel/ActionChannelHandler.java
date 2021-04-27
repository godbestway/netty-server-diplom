package channel;

import Server.OperationManager;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:14
 * @Description:
 */
public class ActionChannelHandler extends BaseChannelHandler {
    protected static Logger logger = LoggerFactory.getLogger(ActionChannelHandler.class);

    public ActionChannelHandler(OperationManager operationManager) {
        super(operationManager);
    }


    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming=ctx.channel();
        ActionChannel actionChannel = new ActionChannel(incoming, this.operationManager);
        //新建立连接时触发的动作
        Attribute<BaseChannel> attr = ctx.attr(AttributeMapConstant.NETTY_CHANNEL_KEY);
        attr.setIfAbsent(actionChannel);
        //System.out.println("客户端："+incoming.remoteAddress()+"已连接上Connection来");
        logger.info("客户端："+incoming.remoteAddress()+"已连接上action来");

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
        //System.out.println("客户端："+incoming.remoteAddress()+"已断开");
        logger.info("客户端："+incoming.remoteAddress()+"已断开");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        //通道处于活动状态触发的动作，该方法只会在通道建立时调用一次
        Channel incoming=ctx.channel();
        //System.out.println("客户端："+incoming.remoteAddress()+"在线");
        logger.info("客户端："+incoming.remoteAddress()+"在线");


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        //通道处于非活动状态触发的动作，该方法只会在通道失效时调用一次
        Channel incoming=ctx.channel();
        //System.out.println("客户端："+incoming.remoteAddress()+"掉线");
        logger.info("客户端："+incoming.remoteAddress()+"掉线");
    }

}
