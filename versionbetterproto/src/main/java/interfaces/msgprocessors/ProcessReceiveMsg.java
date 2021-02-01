package interfaces.msgprocessors;

import interfaces.NetworkFunction;
import proto.MyActionMessageProto;
import proto.MyConnMessageProto;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:21
 * @Description:
 */
public interface ProcessReceiveMsg {
    void receiveConnStatePerflow(MyConnMessageProto.ConnState connState);
    void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState);
    void receiveStateMultiflow();
    void receiveStateConfig();

    void getConnPerflowAck(MyConnMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg);
    void getActionPerflowAck(MyActionMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg);

    void getMultiflowAck();
    void getAllflowAck();
    void getConfigAck();
    void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg);
    void putActionPerflowAck(MyActionMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg);
    void putMultiflowAck();
    void putAllflowAck();
    void putConfigAck();
    void sendConnGetPerflow(NetworkFunction nf, String key);
    void sendActionGetPerflow(NetworkFunction nf, String key);
}
