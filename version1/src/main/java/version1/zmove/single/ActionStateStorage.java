package version1.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version1.interfaces.NetworkFunction;
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
    private NetworkFunction dst;
    private boolean ack;
    private  MoveProcessControl moveProcessControl;
    protected static Logger logger = LoggerFactory.getLogger(ActionStateStorage.class);

    private ActionStateStorage(){
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>>();
    }

    private ActionStateStorage(NetworkFunction dst, MoveProcessControl moveProcessControl){
        this.moveProcessControl = moveProcessControl;
        this.dst = dst;
        this.ack = false;
        statesMap = new ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>>();
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

    public ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>> getStatesMap() {
        return statesMap;
    }

    public void setStatesMap(ConcurrentHashMap<Integer, ConcurrentLinkedQueue<StateMsgProto.StateMsg>> statesMap) {
        this.statesMap = statesMap;
    }

    public NetworkFunction getDst() {
        return dst;
    }

    public void setDst(NetworkFunction dst) {
        this.dst = dst;
    }

    /*public void setAck(){
        this.moveProcessControl.getProcessLock().lock();;
        try {

            this.ack = true;
            this.moveProcessControl.getActionLock().signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            this.moveProcessControl.getProcessLock().unlock();
        }
    }*/

    public void setAck(){
        logger.info("set a action stateStorage ack");
        try {
            this.ack = true;
            //this.moveProcessControl.getLatch().countDown();
            this.moveProcessControl.changeForwarding();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
