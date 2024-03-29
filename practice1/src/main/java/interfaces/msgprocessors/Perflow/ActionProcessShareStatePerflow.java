package interfaces.msgprocessors.Perflow;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.ProcessReceiveMsg;
import proto.MyActionMessageProto;
import proto.MyConnMessageProto;

public abstract class ActionProcessShareStatePerflow implements ProcessReceiveMsg {
    public void receiveConnStatePerflow(MyConnMessageProto.ConnState connState){}

    public void getConnPerflowAck(MyConnMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg){}

    public void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg){}

    public void sendConnGetPerflow(NetworkFunction nf, short hwParameters, byte protoParameters, int mode) {}

    public void sendActionGetMultiflow(NetworkFunction nf){};
    public void getActionMultiflowAck(MyActionMessageProto.ActionGetMultiflowAckMsg actionGetMultiflowAckMsg){};
    public void receiveActionStateMultiflow(MyActionMessageProto.ActionMultiState actionMultiState){};
    public void putActionMultiflowAck(MyActionMessageProto.ActionPutMultiflowAckMsg actionPutMultiflowAckMsg){};

    public void sendActionGetAllflow(NetworkFunction nf){};
    public void getActionAllflowAck(MyActionMessageProto.ActionGetAllflowAckMsg actionGetAllflowAckMsg){};
    public void receiveActionStateAllflow(MyActionMessageProto.ActionAllState actionAllState){};
    public void putActionAllflowAck(MyActionMessageProto.ActionPutAllflowAckMsg actionPutAllflowAckMsg){};

    public void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState){};
}
