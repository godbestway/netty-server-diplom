package version2.zmove.single;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import version2.channel.ActionChannel;
import version2.channel.BaseChannel;
import version2.channel.ConnectionChannel;
import version2.interfaces.NetworkFunction;
import version2.interfaces.stepControl.ProcessCondition;
import version2.server.InitializerServerAction;
import version2.server.InitializerServerConn;
import version2.server.ServerListener;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 20:02
 * @Description:
 */
public class OperationManager {
    private ConcurrentHashMap<String, NetworkFunction> nfs;
    private ConnMsgProcessor connMsgProcessors;
    private ActionMsgProcessor actionMsgProcessors;
    private ProcessCondition processCondition;
    protected static Logger logger = LoggerFactory.getLogger(OperationManager.class);


    public int port1;
    public int port2;
    public  static  int serverSet;


    public OperationManager(){

        nfs = new ConcurrentHashMap<String, NetworkFunction>();
        port1 = 18080;
        port2 = 18081;
    }

    public OperationManager(ConnMsgProcessor connMsgProcessors, ActionMsgProcessor actionMsgProcessors ) {
        this.connMsgProcessors = connMsgProcessors;
        this.actionMsgProcessors = actionMsgProcessors;
        port1 = 18080;
        port2 = 18081;
        nfs = new ConcurrentHashMap<String, NetworkFunction>();
    }

    public OperationManager(ConnMsgProcessor connMsgProcessors, ActionMsgProcessor actionMsgProcessors,
                            ProcessCondition processCondition) {
        this.connMsgProcessors = connMsgProcessors;
        this.actionMsgProcessors = actionMsgProcessors;
        this.processCondition = processCondition;
        port1 = 18080;
        port2 = 18081;
        nfs = new ConcurrentHashMap<String, NetworkFunction>();
    }

    public void run() throws Exception
    {
        //负责接收客户端的连接
        EventLoopGroup connBossGroup=new NioEventLoopGroup();

        //负责处理消息I/O
        EventLoopGroup connWorkerGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap first = new ServerBootstrap();//用于启动NIO服务
            first.group(connBossGroup,connWorkerGroup)
                    .channel(NioServerSocketChannel.class) //通过工厂方法设计模式实例化一个channel
                    .localAddress(new InetSocketAddress(port1))//设置监听端口
                    .option(ChannelOption.SO_BACKLOG,128)//最大保持连接数128，option主要是针对boss线程组
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//启用心跳保活机制，childOption主要是针对worker线程组
                    .childHandler(new InitializerServerConn(this));

            //绑定服务器，该实例将提供有关IO操作的结果或状态的信息
            //ChannelFuture firstChannelFuture= first.bind();
            //System.out.println("在" + firstChannelFuture.channel().localAddress()+"上开启监听");


            bind(first, port1);
            //notifyAll();

            //阻塞操作，closeFuture()开启了一个channel的监听器（这期间channel在进行各项工作），直到链路断开
            //channelFuture.channel().closeFuture().sync();
        } finally {
            //bossGroup.shutdownGracefully().sync();//关闭EventLoopGroup并释放所有资源，包括所有创建的线程
            //workerGroup.shutdownGracefully().sync();
        }

        //负责接收客户端的连接
        EventLoopGroup actionBossGroup=new NioEventLoopGroup();

        //负责处理消息I/O
        EventLoopGroup actionWorkerGroup=new NioEventLoopGroup();
        try {
            //绑定服务器，该实例将提供有关IO操作的结果或状态的信息
            //ChannelFuture firstChannelFuture= first.bind();
            //System.out.println("在" + firstChannelFuture.channel().localAddress()+"上开启监听");

            ServerBootstrap second = new ServerBootstrap();//用于启动NIO服务
            second.group(actionBossGroup,actionWorkerGroup)
                    .channel(NioServerSocketChannel.class) //通过工厂方法设计模式实例化一个channel
                    .localAddress(new InetSocketAddress(port2))//设置监听端口
                    .option(ChannelOption.SO_BACKLOG,128)//最大保持连接数128，option主要是针对boss线程组
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//启用心跳保活机制，childOption主要是针对worker线程组
                    .childHandler(new InitializerServerAction(this));

            //绑定服务器，该实例将提供有关IO操作的结果或状态的信息
            //ChannelFuture secondChannelFuture=second.bind();
            //System.out.println("在" + secondChannelFuture.channel().localAddress()+"上开启监听");

            bind(second , port2);
            //notifyAll();

            //阻塞操作，closeFuture()开启了一个channel的监听器（这期间channel在进行各项工作），直到链路断开
            //channelFuture.channel().closeFuture().sync();
        } finally {
            //bossGroup.shutdownGracefully().sync();//关闭EventLoopGroup并释放所有资源，包括所有创建的线程
            //workerGroup.shutdownGracefully().sync();
        }
    }

    public void bind(ServerBootstrap serverBootstrap, int port) {
        ChannelFuture channelFuture = serverBootstrap.bind(port);
        channelFuture.addListener(new ServerListener(port, this));

    }



    public NetworkFunction obtainNetworkFunction(String host, int pid){
        //System.out.println("find a NF");
        logger.info("a new NF is found");
        NetworkFunction nf;
        synchronized (this.nfs){
            String id = NetworkFunction.constructId(host , pid );
            if(nfs.containsKey(id)){
                nf = nfs.get(id);
            }else{
                nf = new NetworkFunction(host , pid);
                nfs.put(id , nf);
                //System.out.println("set a NF successful");
                logger.info("set a NF successful");
            }
        }
        return nf;
    }

    public void channelConnected(BaseChannel channel){
        //System.out.println("channel try to connect");
        logger.info("channel try to connect");
        NetworkFunction nf = obtainNetworkFunction(channel.getHost(),  channel.getPid());
        boolean connected = false;
        synchronized (nf){
            channel.setNetworkFunction(nf);
            if(channel instanceof ConnectionChannel){
                //System.out.println("try to set a connection channel");
                logger.info("try to set a connection channel");
                nf.setConnectionChannel((ConnectionChannel) channel);
            }
            else if(channel instanceof ActionChannel){
                //System.out.println("try to set a action channel");
                logger.info("try to set a action channel");
                nf.setActionChannel((ActionChannel)channel);
            }

            if(nf.isFullyConnected()){
                connected = true;
            }
        }
        if(connected){
            //System.out.println(NetworkFunction.constructId(nf.getHost(), nf.getPid())+"has already fully connected");
            logger.info(NetworkFunction.constructId(nf.getHost(), nf.getPid())+"has already fully connected");
        }
        else{
            if(nf.hasConnectionChannel()){
                //System.out.println("connection channel has connected");
                logger.info("connection channel has connected");
            }
            else{
                //System.out.println("action channel has connected");
                logger.info("action channel has connected");
            }
        }

        if(connected){
            processCondition.NFConnected(nf);
        }

    }

    public void addProcessCondition(ProcessCondition processCondition){
        this.processCondition = processCondition;
        //System.out.println("a new condition is added");
        logger.info("a new condition is added");
    }

    public ConnMsgProcessor getConnMsgProcessors() {
        return connMsgProcessors;
    }

    public void setConnMsgProcessors(ConnMsgProcessor connMsgProcessors) {
        this.connMsgProcessors = connMsgProcessors;
    }

    public ActionMsgProcessor getActionMsgProcessors() {
        return actionMsgProcessors;
    }

    public void setActionMsgProcessors(ActionMsgProcessor actionMsgProcessors) {
        this.actionMsgProcessors = actionMsgProcessors;
    }

    public static void main(String[] args)  throws Exception
    {
        ConnMsgProcessor connMsgProcessors = new ConnMsgProcessor();
        ActionMsgProcessor actionMsgProcessors = new ActionMsgProcessor();
        OperationManager operationManager = new OperationManager(connMsgProcessors,actionMsgProcessors);
        operationManager.run();
        ProcessCondition moveProcessControl = new MoveProcessControl(operationManager);
        new Thread((Runnable) moveProcessControl).start();


        synchronized (operationManager){
            while(OperationManager.serverSet != 2){
                try {
                    operationManager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println("netty server is set up");
            logger.info("netty server is set up");
        }


    }

}
