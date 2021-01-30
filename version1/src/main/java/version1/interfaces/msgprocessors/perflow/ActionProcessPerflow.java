package version1.interfaces.msgprocessors.perflow;

import version1.interfaces.NetworkFunction;
import version1.interfaces.msgprocessors.ProcessReceiveMsg;
import version1.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 24.01.2021 23:32
 * @Description:
 */
public abstract class ActionProcessPerflow implements ProcessReceiveMsg {
    public void receiveConnStatePerflow(ConnStateProto.ConnState connState){}

    public void getConnPerflowAck(ConnGetPerflowAckMsgProto.ConnGetPerflowAckMsg connGetPerflowAckMsg){}

    public void putConnPerflowAck(ConnPutPerflowAckMsgProto.ConnPutPerflowAckMsg connPutPerflowAckMsg){}

    public void sendConnGetPerflow(NetworkFunction nf, String key){}

    public void receiveStateMultiflow() {}

    public void receiveStateConfig() {}

    public void getMultiflowAck() {}

    public void getAllflowAck() {}

    public void getConfigAck() {}

    public void putMultiflowAck() {
    }

    public void putAllflowAck() {
    }

    public void putConfigAck() {
    }
}
