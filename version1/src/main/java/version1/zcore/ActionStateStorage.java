package version1.zcore;

import version1.proto.object.StateMsgProto;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 17:00
 * @Description:
 */
public class ActionStateStorage {
    private static volatile ActionStateStorage actionStateStorage;
    private ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>> statesMap;

    private ActionStateStorage(){
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>>();
    }

    public static ActionStateStorage getInstance(){
        if(actionStateStorage == null){
            synchronized (ConnStateStorage.class){
                if(actionStateStorage == null){
                    actionStateStorage = new ActionStateStorage();
                }
            }
        }
        return actionStateStorage;
    }

    public ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>> getStatesMap() {
        return statesMap;
    }

    public void setStatesMap(ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>> statesMap) {
        this.statesMap = statesMap;
    }
}
