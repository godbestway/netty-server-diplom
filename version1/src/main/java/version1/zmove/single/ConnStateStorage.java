package version1.zmove.single;

import version1.interfaces.NetworkFunction;
import version1.interfaces.StateStorage;
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
    private boolean ack;
    private MoveProcessControl moveProcessControl;


    private ConnStateStorage(){

        statesList = new ConcurrentLinkedQueue<FlowStateProto.FlowState>();
    }

    private ConnStateStorage(NetworkFunction dst){
        this.dst = dst;
        statesList = new ConcurrentLinkedQueue<FlowStateProto.FlowState>();
    }

    private ConnStateStorage(NetworkFunction dst, MoveProcessControl moveProcessControl){
        this.ack = false;
        this.dst = dst;
        this.moveProcessControl = moveProcessControl;
        statesList = new ConcurrentLinkedQueue<FlowStateProto.FlowState>();
    }

    public static ConnStateStorage getInstance(NetworkFunction dst, MoveProcessControl moveProcessControl){
        if(connStateStorage == null){
            synchronized (ConnStateStorage.class){
                if(connStateStorage == null){
                    connStateStorage = new ConnStateStorage(dst, moveProcessControl);
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

    /*public void setAck(){
        this.moveProcessControl.getProcessLock().lock();;
        try {

            this.ack = true;
            this.moveProcessControl.getConnLock().signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            this.moveProcessControl.getProcessLock().unlock();
        }
    }*/

    public void setAck(){
        try {
            this.ack = true;
            this.moveProcessControl.getLatch().countDown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
