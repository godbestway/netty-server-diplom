package test.testOthers;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import version1.zmove.single.OperationManager;
import version1.server.InitializerServerConn;

import java.net.InetSocketAddress;

/**
 * @Author: Chenglin Ding
 * @Date: 11.01.2021 16:13
 * @Description:
 */
public class PortServer {
    public int port1;

    private OperationManager operationManager;

    public PortServer(int port1, OperationManager operationManager) {
        this.port1 = port1;
        this.operationManager = operationManager;
    }

    public void run() throws Exception
    {
        //负责接收客户端的连接
        EventLoopGroup bossGroup=new NioEventLoopGroup();

        //负责处理消息I/O
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap first = new ServerBootstrap();//用于启动NIO服务
            first.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //通过工厂方法设计模式实例化一个channel
                    .localAddress(new InetSocketAddress(port1))//设置监听端口
                    .option(ChannelOption.SO_BACKLOG,128)//最大保持连接数128，option主要是针对boss线程组
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//启用心跳保活机制，childOption主要是针对worker线程组
                    .childHandler(new InitializerServerConn(this.operationManager));

            //绑定服务器，该实例将提供有关IO操作的结果或状态的信息
            //ChannelFuture firstChannelFuture= first.bind();
            //System.out.println("在" + firstChannelFuture.channel().localAddress()+"上开启监听");


            //bind(first, port1);
            ChannelFuture f = first.bind().sync();
            System.out.println("在" + f.channel().localAddress()+"上开启监听");
            f.channel().closeFuture().sync();
            //阻塞操作，closeFuture()开启了一个channel的监听器（这期间channel在进行各项工作），直到链路断开
            //channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully().sync();//关闭EventLoopGroup并释放所有资源，包括所有创建的线程
            workerGroup.shutdownGracefully().sync();
        }
    }

    /*public static void bind(ServerBootstrap serverBootstrap, int port) {
        ChannelFuture channelFuture = serverBootstrap.bind(port);

        channelFuture.addListener(new ServerListener(port,serverBootstrap));
    }*/

    public static void main(String[] args)  throws Exception
    {
        OperationManager operationManager = new OperationManager();
        new PortServer(18080, operationManager).run();
        System.out.println("进行下面的步骤");
        //new AppServerPB(10000).run();
    }

}
