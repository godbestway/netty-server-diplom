package interfaces.msgprocessors.Perflow;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.ProcessReceiveMsg;
import proto.MyMessageProto;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:24
 * @Description:
 */
public abstract class ConnProcessPerflow implements ProcessReceiveMsg {

    public void receiveActionStatePerflow(MyMessageProto.ActionState actionState){}

    public void getActionPerflowAck(MyMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg){}

    public void putActionPerflowAck(MyMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg){}

    public void receiveStateMultiflow(){}
    public void receiveStateConfig(){}

    public void getMultiflowAck(){}
    public void getAllflowAck(){}
    public void getConfigAck(){}

    public void putMultiflowAck(){}
    public void putAllflowAck(){}
    public void putConfigAck(){}
    public void sendActionGetPerflow(NetworkFunction nf, String key){}
}
