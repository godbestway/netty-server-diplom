package interfaces.msgprocessors.Perflow;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.ProcessReceiveMsg;
import proto.MyMessageProto;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:23
 * @Description:
 */
public abstract  class ActionProcessPerflow implements ProcessReceiveMsg {
    public void receiveConnStatePerflow(MyMessageProto.ConnState connState){}

    public void getConnPerflowAck(MyMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg){}

    public void putConnPerflowAck(MyMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg){}

    public void sendConnGetPerflow(NetworkFunction nf, String key) {}

    public void putConnPerflowAck(){}

    public void sendConnGetPerflow(){}

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
