package version1.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import version1.coder.ActionServerDecoder;
import version1.coder.ActionServerEncoder;
import version1.channel.ActionChannelHandler;


/**
 * @Author: Chenglin Ding
 * @Date: 08.01.2021 11:59
 * @Description:
 */
public class InitializerServerAction extends ChannelInitializer<SocketChannel> {
    private OperationManager operationManager;

    public InitializerServerAction(OperationManager operationManager) {
        this.operationManager = operationManager;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception
    {
        ChannelPipeline pipeline=socketChannel.pipeline();
        pipeline.addLast("Protobuf decoder", new ActionServerDecoder());//设置我们的proto文件生成的实例，其实就是我们的目标Java类
        pipeline.addLast("Protobuf encoder",new ActionServerEncoder());//protobuf编码器
        pipeline.addLast("handler", new ActionChannelHandler(this.operationManager));
    }
}
