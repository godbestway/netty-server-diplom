package version1.zmove.single;

import version1.interfaces.NetworkFunction;
import version1.interfaces.msgprocessors.perflow.ProcessPerflow;
import version1.proto.object.*;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 12:22
 * @Description:
 */
public class ConnMsgProcessor extends ProcessPerflow {
    private volatile int count ;
    private volatile int totalnum ;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;
    private ConcurrentLinkedQueue<StateChunk> statesList;

    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.statesList = new ConcurrentLinkedQueue<StateChunk>();
    }

    public void receiveStatePerflow(FlowStateProto.FlowState flowState) {
        System.out.println("receive a state, data="+flowState.getData());
        connStateStorage.getStatesList().add(flowState);
        StateChunk stateChunk = null;

        stateChunk = new StateChunk(connStateStorage.getDst() , flowState,flowState.getData());
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
        /*if(count == totalnum){
            setConnStateStorageAck();
        }*/
    }

    public void sendGetPerflow(NetworkFunction nf, String key) {
        System.out.println("发送了getperflow");
        GetPerflowProto.GetPerflowMsg getPerflowMsg = GetPerflowProto.GetPerflowMsg.newBuilder()
                .setKey(key).build();
        nf.getConnectionChannel().sendMessage(getPerflowMsg);

    }

    public void addConnStateStorage(ConnStateStorage connStateStorage){
        System.out.println("添加了conn storage");
        this.connStateStorage = connStateStorage;
    }

    public void testSendPutFlow(){
        System.out.println("test send putperflow");
        StateChunk stateChunk = null;
        for(int i = 1; i <= 5;i++){
            FlowStateProto.FlowState flowState = FlowStateProto.FlowState.newBuilder()
                    .setData(i).build();
            stateChunk = new StateChunk(connStateStorage.getDst() , flowState,i);
            threadPool.submit(stateChunk);
        }
    }

    public void setConnStateStorageAck(){
        System.out.println("test receive ack process");
        this.connStateStorage.setAck();
    }


}
