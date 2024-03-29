package zconnacmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyActionMessageProto;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 18:20
 * @Description:
 */
public class ActionStateStorage {
    private static volatile ActionStateStorage actionStateStorage;
    private ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>> statesMap;
    private ConcurrentLinkedQueue<ActionStateChunk> statesList;
    private NetworkFunction dst;
    private boolean ack;
    private  MoveProcessControl moveProcessControl;
    private int advanced;
    private ExecutorService threadPool;
    protected static Logger logger = LoggerFactory.getLogger(ActionStateStorage.class);

    private ActionStateStorage(){
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>>();
    }

    private ActionStateStorage(NetworkFunction dst, MoveProcessControl moveProcessControl, int advanced){
        this.moveProcessControl = moveProcessControl;
        this.dst = dst;
        this.ack = false;
        this.advanced = advanced;
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>>();
        statesList = new ConcurrentLinkedQueue<>();
        this.threadPool = Executors.newCachedThreadPool();
    }

    public static ActionStateStorage getInstance(NetworkFunction dst, MoveProcessControl moveProcessControl, int advanced){
        if(actionStateStorage == null){
            synchronized (ActionStateStorage.class){
                if(actionStateStorage == null){
                    actionStateStorage = new ActionStateStorage(dst, moveProcessControl, advanced);
                }
            }
        }
        return actionStateStorage;
    }

    public ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>> getStatesMap() {
        return statesMap;
    }

    public void setStatesMap(ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>> statesMap) {
        this.statesMap = statesMap;
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public NetworkFunction getDst() {
        return dst;
    }

    public void setDst(NetworkFunction dst) {
        this.dst = dst;
    }

    public int getAdvanced() {
        return advanced;
    }

    public ConcurrentLinkedQueue<ActionStateChunk> getStatesList() {
        return statesList;
    }

    public void setStatesList(ConcurrentLinkedQueue<ActionStateChunk> statesList) {
        this.statesList = statesList;
    }

    /**
     * the number of putAcks is equal to the total nums
     */
    public void setAck(){
        //logger.info("set a action stateStorage ack");
        try {
            if(!this.ack)
            {
                this.ack = true;
                if(this.advanced == 0) {
                    this.moveProcessControl.getLatch().countDown();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
