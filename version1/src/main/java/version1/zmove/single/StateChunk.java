package version1.zmove.single;

import version1.interfaces.NetworkFunction;
import version1.proto.object.FlowStateProto;
import version1.proto.object.PutPerflowProto;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 14.01.2021 14:42
 * @Description:
 */
public class StateChunk implements Callable<Boolean>{
    private NetworkFunction dst;
    //Todo for Multiflow
    private FlowStateProto.FlowState flowState;
    private int stateCount;

    public StateChunk(NetworkFunction dst, FlowStateProto.FlowState flowState) {
        this.dst = dst;
        this.flowState = flowState;
    }

    public StateChunk(NetworkFunction dst, FlowStateProto.FlowState flowState, int stateCount) {
        this.dst = dst;
        this.flowState = flowState;
        this.stateCount = stateCount;
    }

    public Boolean call() throws Exception {
        PutPerflowProto.PutPerflowMsg putPerflowMsg = PutPerflowProto.PutPerflowMsg.newBuilder()
                .setState(this.flowState)
                .setCount(this.stateCount)
                .build();
        System.out.println("send putperflow");
        this.dst.getConnectionChannel().sendMessage(putPerflowMsg);

        return true;
    }

    /*public void run() {
        PutPerflowProto.PutPerflowMsg putPerflowMsg = PutPerflowProto.PutPerflowMsg.newBuilder()
                .setState(this.flowState)
                .setCount(this.stateCount)
                .build();
        System.out.println("send putperflow");
        this.dst.getConnectionChannel().sendMessage(putPerflowMsg);


    }*/
}
