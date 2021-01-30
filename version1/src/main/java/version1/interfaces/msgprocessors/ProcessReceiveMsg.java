package version1.interfaces.msgprocessors;

import version1.interfaces.NetworkFunction;
import version1.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 11:41
 * @Description:
 */
public interface ProcessReceiveMsg {
    void receiveConnStatePerflow(ConnStateProto.ConnState connState);
    void receiveActionStatePerflow(ActionStateProto.ActionState actionState);
    void receiveStateMultiflow();
    void receiveStateConfig();
    void getConnPerflowAck(ConnGetPerflowAckMsgProto.ConnGetPerflowAckMsg connGetPerflowAckMsg);
    void getActionPerflowAck(ActionGetPerflowAckMsgProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg);

    void getMultiflowAck();
    void getAllflowAck();
    void getConfigAck();
    void putConnPerflowAck(ConnPutPerflowAckMsgProto.ConnPutPerflowAckMsg connPutPerflowAckMsg);
    void putActionPerflowAck(ActionPutPerflowAckMsgProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg);
    void putMultiflowAck();
    void putAllflowAck();
    void putConfigAck();
    void sendConnGetPerflow(NetworkFunction nf, String key);
    void sendActionGetPerflow(NetworkFunction nf, String key);

}
