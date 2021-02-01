package zmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyActionMessageProto;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 18:20
 * @Description:
 */
public class ActionStateStorage {
    private static volatile ActionStateStorage actionStateStorage;
    private ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>> statesMap;
    private NetworkFunction dst;
    private boolean ack;
    private  MoveProcessControl moveProcessControl;
    protected static Logger logger = LoggerFactory.getLogger(ActionStateStorage.class);

    private ActionStateStorage(){
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>>();
    }

    private ActionStateStorage(NetworkFunction dst, MoveProcessControl moveProcessControl){
        this.moveProcessControl = moveProcessControl;
        this.dst = dst;
        this.ack = false;
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<MyActionMessageProto.ActionState>>();
    }

    public static ActionStateStorage getInstance(NetworkFunction dst, MoveProcessControl moveProcessControl){
        if(actionStateStorage == null){
            synchronized (ConnStateStorage.class){
                if(actionStateStorage == null){
                    actionStateStorage = new ActionStateStorage(dst, moveProcessControl);
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

    public NetworkFunction getDst() {
        return dst;
    }

    public void setDst(NetworkFunction dst) {
        this.dst = dst;
    }



    public void setAck(){
        logger.info("set a action stateStorage ack");
        try {
            if(!this.ack)
            {
                this.ack = true;
                this.moveProcessControl.getLatch().countDown();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
