package version1;

/**
 * @Author: Chenglin Ding
 * @Date: 04.01.2021 10:56
 * @Description:
 */
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
/**
 * @Author: Chenglin Ding
 * @Date: 29.12.2020 16:58
 * @Description:
 */
public class AppServerPB {
    private int port;

    public AppServerPB(int port)
    {
        this.port = port;
    }

    public void run() throws Exception
    {
        //负责接收客户端的连接
        EventLoopGroup bossGroup=new NioEventLoopGroup();

        //负责处理消息I/O
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();//用于启动NIO服务
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //通过工厂方法设计模式实例化一个channel
                    .localAddress(new InetSocketAddress(port))//设置监听端口
                    .option(ChannelOption.SO_BACKLOG,128)//最大保持连接数128，option主要是针对boss线程组
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//启用心跳保活机制，childOption主要是针对worker线程组
                    .childHandler(new InitializerServerPB());

            //绑定服务器，该实例将提供有关IO操作的结果或状态的信息
            ChannelFuture channelFuture= b.bind().sync();
            System.out.println("在" + channelFuture.channel().localAddress()+"上开启监听");

            //阻塞操作，closeFuture()开启了一个channel的监听器（这期间channel在进行各项工作），直到链路断开
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully().sync();//关闭EventLoopGroup并释放所有资源，包括所有创建的线程
            workerGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args)  throws Exception
    {
        new AppServerPB(18080).run();
        //new AppServerPB(10000).run();
    }
}
