package version1.zmove.single;

import version1.interfaces.NetworkFunction;
import version1.interfaces.msgprocessors.perflow.ProcessPerflow;
import version1.proto.object.FlowStateProto;
import version1.proto.object.GetPerflowAckProto;
import version1.proto.object.GetPerflowProto;
import version1.proto.object.PutPerflowAckMsgProto;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 19:43
 * @Description:
 */
public class ActionMsgProcessor extends ProcessPerflow{
    private ActionStateStorage actionStateStorage;
    private volatile int count ;
    private volatile int totalnum ;
    private ExecutorService threadPool;
    private ConcurrentLinkedQueue<StateChunk> statesList;

    public ActionMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.statesList = new ConcurrentLinkedQueue<StateChunk>();
    }

    public void receiveStatePerflow(FlowStateProto.FlowState flowState) {
        System.out.println("receive a state, data="+flowState.getData());
        //actionStateStorage.getStatesMap().get(0).add(flowState);
        StateChunk stateChunk = null;

        stateChunk = new StateChunk(actionStateStorage.getDst() , flowState,flowState.getData());
        threadPool.submit(stateChunk);
    }


    public void releaseStates(){
        try {
            threadPool.invokeAll(statesList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getPerflowAck(GetPerflowAckProto.GetPerflowAckMsg msg) {
        totalnum = msg.getCount();
        System.out.println("totalnum:"+ totalnum);
    }

    public void putPerflowAck(PutPerflowAckMsgProto.PutPerflowAckMsg msg) {
        count++;
        System.out.println("put perflow count"+count);
        if(count == totalnum){
            setActionStateStorageAck();
        }
    }

    public void sendGetPerflow(NetworkFunction nf, String key) {
        System.out.println("发送了getperflow");
        GetPerflowProto.GetPerflowMsg getPerflowMsg = GetPerflowProto.GetPerflowMsg.newBuilder()
                .setKey(key).build();
        nf.getConnectionChannel().sendMessage(getPerflowMsg);

    }
    public void addActionStateStorage(ActionStateStorage actionStateStorage){
        System.out.println("添加了conn storage");
        this.actionStateStorage = actionStateStorage;
    }
    public void setActionStateStorageAck(){
        System.out.println("test receive ack process");
        this.actionStateStorage.setAck();
    }

}
