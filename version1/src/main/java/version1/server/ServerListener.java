package version1.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 14:42
 * @Description:
 */
public class ServerListener implements ChannelFutureListener {
    private int port;
    //ServerBootstrap serverBootstrap;
    private OperationManager operationManager;
    protected static Logger logger = LoggerFactory.getLogger(ServerListener.class);


    public ServerListener(int port, OperationManager operationManager) {
        this.port = port;
        this.operationManager = operationManager;
    }


    public ServerListener(int port) {
        this.port = port;
    }


    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (channelFuture.isSuccess()) {
            //System.out.println("bind success at port: " + this.port);
            logger.info("bind success at port:"+this.port);
            synchronized(operationManager) {
                OperationManager.serverSet++;
                operationManager.notify();
            }

            //System.out.println("Netty setServer"+NettyServer.serverSet);
        } else {
            //NettyServer.bind(this.serverBootstrap, port);
            //System.out.println("port is occupied");
            logger.warn("bind success at port:"+this.port);
        }
    }


}
