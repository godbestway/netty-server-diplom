package interfaces.msgprocessors.Allflows;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.ProcessReceiveMsg;
import proto.MyActionMessageProto;
import proto.MyConnMessageProto;

public abstract class ActionProcessShareStateAllflows implements ProcessReceiveMsg {
    public void receiveConnStatePerflow(MyConnMessageProto.ConnState connState){}

    public void getConnPerflowAck(MyConnMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg){}

    public void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg){}

    public void sendConnGetPerflow(NetworkFunction nf, short hwParameters, byte protoParameters, int mode) {}

    public void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState){};

    public void sendActionGetPerflow(NetworkFunction nf,short hwParameters, byte protoParameters, int share){}
}
