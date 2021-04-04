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

    void sendConnGetPerflow(NetworkFunction nf, short hwParameters, byte protoParameters);
    void getConnPerflowAck(MyConnMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg);
    void receiveConnStatePerflow(MyConnMessageProto.ConnState connState);
    void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg);



    void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState);
    void getActionPerflowAck(MyActionMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg);
    void putActionPerflowAck(MyActionMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg);


    void receiveStateMultiflow();
    void receiveStateConfig();
    void getMultiflowAck();
    void getAllflowAck();
    void getConfigAck();
    void putMultiflowAck();
    void putAllflowAck();
    void putConfigAck();

    void sendActionGetPerflow(NetworkFunction nf, short hwParameters, byte protoParameters);
}
