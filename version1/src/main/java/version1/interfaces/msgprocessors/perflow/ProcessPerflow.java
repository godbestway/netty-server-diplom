package version1.interfaces.msgprocessors.perflow;

import version1.interfaces.msgprocessors.ProcessReceiveMsg;
import version1.proto.object.MultiflowStateProto;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 12:16
 * @Description:
 */
public abstract class ProcessPerflow implements ProcessReceiveMsg {

    public void receiveStateMultiflow(MultiflowStateProto.MultiflowState multiflowState) {}

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














