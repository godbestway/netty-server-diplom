package version2.server;

/**
 * @Author: Chenglin Ding
 * @Date: 29.12.2020 16:59
 * @Description:
 */
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import version2.coder.ConnServerDecoder;
import version2.zmove.single.OperationManager;
import version2.channel.ConnectionChannelHandler;
import version2.coder.ConnServerEncoder;

public class InitializerServerConn extends ChannelInitializer<SocketChannel>{
    private OperationManager operationManager;

    public InitializerServerConn(OperationManager operationManager) {
        this.operationManager = operationManager;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception
    {
        ChannelPipeline pipeline=socketChannel.pipeline();
        pipeline.addLast("Protobuf decoder", new ConnServerDecoder());//设置我们的proto文件生成的实例，其实就是我们的目标Java类
        pipeline.addLast("Protobuf encoder",new ConnServerEncoder());//protobuf编码器
        pipeline.addLast("handler", new ConnectionChannelHandler(this.operationManager));
    }
}
