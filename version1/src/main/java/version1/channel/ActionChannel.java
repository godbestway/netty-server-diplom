package version1.channel;

import io.netty.channel.Channel;
import version1.OperationManager;

/**
 * @Author: Chenglin Ding
 * @Date: 07.01.2021 16:12
 * @Description:
 */
public class ActionChannel extends BaseChannel{


    public ActionChannel(Channel channel, OperationManager operationManager) {
        super(channel, operationManager);
    }

    protected void processMessage(String line) {

    }

    public void sendMessage(Object msg) {

    }
}
