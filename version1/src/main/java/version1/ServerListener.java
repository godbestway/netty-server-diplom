package version1;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 14:42
 * @Description:
 */
public class ServerListener implements ChannelFutureListener {
    int port;

    public ServerListener(int port) {
        this.port = port;
    }

    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if(channelFuture.isSuccess()){
            System.out.println("bind success at port: " + this.port);
        }else{
            System.out.println("port is occupied");
        }
    }
}
