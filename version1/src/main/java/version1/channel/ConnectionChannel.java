package version1.channel;

import io.netty.channel.Channel;
import version1.OperationManager;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:11
 * @Description:
 */
public class ConnectionChannel extends BaseChannel {

    public ConnectionChannel(Channel channel, OperationManager operationManager) {
        super(channel, operationManager);
    }

    protected void processMessage(String line) {

    }

    public void sendMessage(Object msg) {

    }
}
