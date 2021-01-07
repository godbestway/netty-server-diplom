package version1.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import version1.coder.ServerDecoder;
import version1.coder.ServerEncoder;

/**
 * @Auther: 江成军
 * @Date: 2020/6/2 16:05
 * @Description: 客户端handler初始化配置类，在Channel注册到EventLoop后，对这个Channel添加一些初始化的Handler
 */
public class InitializerClientPB extends ChannelInitializer<SocketChannel>
{
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception
    {
        ChannelPipeline pipeline=socketChannel.pipeline();
        pipeline.addLast("Protobuf decoder", new ServerDecoder());//设置我们的proto文件生成的实例，其实就是我们的目标Java类
        pipeline.addLast("Protobuf encoder",new ServerEncoder());//protobuf编码器
        pipeline.addLast("handler", new HandlerClientPB());
    }
}
