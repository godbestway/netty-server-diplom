package version1.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import version1.zmove.single.OperationManager;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 14:42
 * @Description:
 */
public class ServerListener implements ChannelFutureListener {
    private int port;
    //ServerBootstrap serverBootstrap;
    private OperationManager operationManager;


    public ServerListener(int port, OperationManager operationManager) {
        this.port = port;
        this.operationManager = operationManager;
    }


    public ServerListener(int port) {
        this.port = port;
    }


    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (channelFuture.isSuccess()) {
            System.out.println("bind success at port: " + this.port);
            synchronized(operationManager) {
                OperationManager.serverSet++;
                operationManager.notify();
            }

            //System.out.println("Netty setServer"+NettyServer.serverSet);
        } else {
            //NettyServer.bind(this.serverBootstrap, port);
            System.out.println("port is occupied");
        }
    }


}
