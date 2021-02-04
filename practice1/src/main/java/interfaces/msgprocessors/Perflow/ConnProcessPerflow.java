package interfaces.msgprocessors.Perflow;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.ProcessReceiveMsg;
import proto.MyActionMessageProto;


/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:24
 * @Description:
 */
public abstract class ConnProcessPerflow implements ProcessReceiveMsg {
    public void sendActionGetPerflow(NetworkFunction nf,short hwParameters, byte protoParameters){}

    public void getActionPerflowAck(MyActionMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg){}

    public void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState){}

    public void putActionPerflowAck(MyActionMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg){}

    public void receiveStateMultiflow(){}
    public void receiveStateConfig(){}

    public void getMultiflowAck(){}
    public void getAllflowAck(){}
    public void getConfigAck(){}

    public void putMultiflowAck(){}
    public void putAllflowAck(){}
    public void putConfigAck(){}
}
