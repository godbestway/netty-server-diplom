package version1.interfaces.msgprocessors;

import version1.interfaces.NetworkFunction;
import version1.proto.object.FlowStateProto;
import version1.proto.object.GetPerflowAckProto;
import version1.proto.object.MultiflowStateProto;
import version1.proto.object.PutPerflowAckMsgProto;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 11:41
 * @Description:
 */
public interface ProcessReceiveMsg {
    void receiveStatePerflow(FlowStateProto.FlowState flowState);
    void receiveStateMultiflow(MultiflowStateProto.MultiflowState multiflowState);
    void receiveStateConfig();
    void getPerflowAck(GetPerflowAckProto.GetPerflowAckMsg getPerflowAckMsg);
    void getMultiflowAck();
    void getAllflowAck();
    void getConfigAck();
    void putPerflowAck(PutPerflowAckMsgProto.PutPerflowAckMsg putPerflowAckMsg);
    void putMultiflowAck();
    void putAllflowAck();
    void putConfigAck();
    void sendGetPerflow(NetworkFunction nf, String key);

}
