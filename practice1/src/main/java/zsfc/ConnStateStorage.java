package zsfc;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnStateStorage {
    private static volatile ConnStateStorage connStateStorage;
    private ConcurrentHashMap<Integer, MyConnMessageProto.ConnState> stateMap;
    private Map<String, NetworkFunction> runNFs;
    private SFCProcessControl sfcProcessControl;
    private boolean ack;
    protected static Logger logger = LoggerFactory.getLogger(ConnStateStorage.class);


    private ConnStateStorage(){
        stateMap = new ConcurrentHashMap<>();
    }

    private ConnStateStorage(Map<String, NetworkFunction> runNFs, SFCProcessControl sfcProcessControl){
        this.ack = false;
        this.runNFs = runNFs;
        this.sfcProcessControl = sfcProcessControl;
        stateMap = new ConcurrentHashMap<>();
    }

    public static ConnStateStorage getInstance(Map<String, NetworkFunction> runNFs, SFCProcessControl sfcProcessControl){
        if(connStateStorage == null){
            synchronized (zconnacmove.ConnStateStorage.class){
                if(connStateStorage == null){
                    connStateStorage = new ConnStateStorage(runNFs, sfcProcessControl);
                }
            }
        }
        return connStateStorage;
    }

    public ConcurrentHashMap<Integer, MyConnMessageProto.ConnState> getStateMap() {
        return stateMap;
    }

    public void setStateMap(ConcurrentHashMap<Integer, MyConnMessageProto.ConnState> stateMap) {
        this.stateMap = stateMap;
    }

    public Map<String, NetworkFunction> getRunNFs() {
        return runNFs;
    }

    public void setRunNFs(Map<String, NetworkFunction> runNFs) {
        this.runNFs = runNFs;
    }

    public void setAck(){
        logger.info("set a conn stateStorage ack");
        try {
            if(!this.ack)
            {
                this.ack = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
