package zmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyMessageProto;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 13:00
 * @Description:
 */
public class ConnStateStorage {
    private static volatile ConnStateStorage connStateStorage;
    private ConcurrentLinkedQueue<MyMessageProto.ConnState> statesList;
    private NetworkFunction dst;
    private boolean ack;
    private MoveProcessControl moveProcessControl;
    protected static Logger logger = LoggerFactory.getLogger(ConnStateStorage.class);


    private ConnStateStorage(){

        statesList = new ConcurrentLinkedQueue<MyMessageProto.ConnState>();
    }

    private ConnStateStorage(NetworkFunction dst){
        this.dst = dst;
        statesList = new ConcurrentLinkedQueue<MyMessageProto.ConnState>();
    }

    private ConnStateStorage(NetworkFunction dst, MoveProcessControl moveProcessControl){
        this.ack = false;
        this.dst = dst;
        this.moveProcessControl = moveProcessControl;
        statesList = new ConcurrentLinkedQueue<MyMessageProto.ConnState>();
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

    public ConcurrentLinkedQueue<MyMessageProto.ConnState> getStatesList() {
        return statesList;
    }

    public void setStatesList(ConcurrentLinkedQueue<MyMessageProto.ConnState> statesList) {
        this.statesList = statesList;
    }

    public NetworkFunction getDst() {
        return dst;
    }

    public void setDst(NetworkFunction dst) {
        this.dst = dst;
    }



    public void setAck(){
        logger.info("set a conn stateStorage ack");
        try {
            this.ack = true;
            this.moveProcessControl.getLatch().countDown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
