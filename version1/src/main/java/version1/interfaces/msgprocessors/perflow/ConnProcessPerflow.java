package version1.interfaces.msgprocessors.perflow;

import version1.interfaces.NetworkFunction;
import version1.interfaces.msgprocessors.ProcessReceiveMsg;
import version1.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 12:16
 * @Description:
 */
public abstract class ConnProcessPerflow implements ProcessReceiveMsg {
    public void receiveActionStatePerflow(ActionStateProto.ActionState actionState){}

    public void getActionPerflowAck(ActionGetPerflowAckMsgProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg){}

    public void putActionPerflowAck(ActionPutPerflowAckMsgProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg){}

    public void sendActionGetPerflow(NetworkFunction nf, String key){}

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














