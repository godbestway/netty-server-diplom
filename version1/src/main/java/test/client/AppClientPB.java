package test.client;

/**
 * @Author: Chenglin Ding
 * @Date: 05.01.2021 14:44
 * @Description:
 */
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Auther: 江成军
 * @Date: 2020/6/1 11:24
 * @Description: 客户端启动类
 */
public class AppClientPB
{
    private final String host;
    private final int port;

    public AppClientPB(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception
    {
        /**
         * @Author 江成军
         * @Date 2020/6/1 11:28
         * @Description  配置相应的参数，提供连接到远端的方法
         **/
        EventLoopGroup group = new NioEventLoopGroup();//I/O线程池
        try {
            Bootstrap bs = new Bootstrap();//客户端辅助启动类
            bs.group(group)
                    .channel(NioSocketChannel.class)//实例化一个Channel
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new InitializerClientPB());

            //连接到远程节点；等待连接完成
            ChannelFuture future=bs.connect().sync();

            //阻塞操作，closeFuture()开启了一个channel的监听器（这期间channel在进行各项工作），直到链路断开
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception
    {
        new AppClientPB("127.0.0.1",18080).run();
    }


}
