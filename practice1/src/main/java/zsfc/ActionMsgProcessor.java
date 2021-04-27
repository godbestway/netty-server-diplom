package zsfc;

import interfaces.msgprocessors.Perflow.ActionProcessPerflow;
import proto.MyActionMessageProto;

public class ActionMsgProcessor extends ActionProcessPerflow {
    @Override
    public void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState) {

    }

    @Override
    public void getActionPerflowAck(MyActionMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg) {

    }

    @Override
    public void putActionPerflowAck(MyActionMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg) {

    }
}
