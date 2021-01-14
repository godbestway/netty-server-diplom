package version1.zcore;

import version1.interfaces.perflow.ProcessPerflow;
import version1.proto.object.FlowStateProto;
import version1.proto.object.GetPerflowAckProto;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 19:43
 * @Description:
 */
public class ActionMsgProcessor extends ProcessPerflow{
    public void receiveStatePerflow(FlowStateProto.FlowState flowState) {

    }

    public void getPerflowAck(GetPerflowAckProto.GetPerflowAckMsg getPerflowAckMsg) {

    }

    public void putPerflowAck() {

    }

    public void sendGetPerflow(NetworkFunction nf, String key) {

    }

    public void sendPutPerflow() {

    }
}
