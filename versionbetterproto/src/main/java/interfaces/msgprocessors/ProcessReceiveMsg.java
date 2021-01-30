package interfaces.msgprocessors;

import interfaces.NetworkFunction;
import proto.MyMessageProto;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:21
 * @Description:
 */
public interface ProcessReceiveMsg {
    void receiveConnStatePerflow(MyMessageProto.ConnState connState);
    void receiveActionStatePerflow(MyMessageProto.ActionState actionState);
    void receiveStateMultiflow();
    void receiveStateConfig();
    void getConnPerflowAck(MyMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg);
    void getActionPerflowAck(MyMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg);

    void getMultiflowAck();
    void getAllflowAck();
    void getConfigAck();
    void putConnPerflowAck(MyMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg);
    void putActionPerflowAck(MyMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg);
    void putMultiflowAck();
    void putAllflowAck();
    void putConfigAck();
    void sendConnGetPerflow(NetworkFunction nf, String key);
    void sendActionGetPerflow(NetworkFunction nf, String key);
}
