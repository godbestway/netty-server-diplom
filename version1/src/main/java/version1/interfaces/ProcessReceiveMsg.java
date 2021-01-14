package version1.interfaces;

import version1.proto.object.FlowStateProto;
import version1.proto.object.GetPerflowAckProto;
import version1.proto.object.MultiflowStateProto;
import version1.zcore.NetworkFunction;

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
    void putPerflowAck();
    void putMultiflowAck();
    void putAllflowAck();
    void putConfigAck();
    void sendGetPerflow(NetworkFunction nf, String key);
    void sendPutPerflow();

}
