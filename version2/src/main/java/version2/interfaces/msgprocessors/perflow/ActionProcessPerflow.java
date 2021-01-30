package version2.interfaces.msgprocessors.perflow;

import version2.interfaces.NetworkFunction;
import version2.interfaces.msgprocessors.ProcessReceiveMsg;
import version2.proto.object.*;

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
