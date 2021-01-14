package version1.zcore;

import version1.proto.object.FlowStateProto;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 14:58
 * @Description:
 */
public class ConnStateStorage {
    private static volatile ConnStateStorage connStateStorage;
    private ConcurrentLinkedQueue<FlowStateProto.FlowState> statesList;
    private NetworkFunction dst;

    private ConnStateStorage(){

        statesList = new ConcurrentLinkedQueue<FlowStateProto.FlowState>();
    }

    private ConnStateStorage(NetworkFunction dst){
        this.dst = dst;
        statesList = new ConcurrentLinkedQueue<FlowStateProto.FlowState>();
    }

    public static ConnStateStorage getInstance(NetworkFunction dst){
        if(connStateStorage == null){
            synchronized (ConnStateStorage.class){
                if(connStateStorage == null){
                    connStateStorage = new ConnStateStorage(dst);
                }
            }
        }
        return connStateStorage;
    }

    public ConcurrentLinkedQueue<FlowStateProto.FlowState> getStatesList() {
        return statesList;
    }

    public void setStatesList(ConcurrentLinkedQueue<FlowStateProto.FlowState> statesList) {
        this.statesList = statesList;
    }

    public NetworkFunction getDst() {
        return dst;
    }

    public void setDst(NetworkFunction dst) {
        this.dst = dst;
    }
}
