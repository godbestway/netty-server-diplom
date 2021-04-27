package zsfc;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.Perflow.ConnProcessPerflow;
import interfaces.msgprocessors.sfc.ConnProcessSfc;
import interfaces.msgprocessors.sfc.UnlockSfc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;
import zconnacmove.ConnStateChunk;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnMsgProcessor extends ConnProcessSfc implements UnlockSfc {
    private volatile int count ;
    private volatile int receiveCount ;
    public static volatile int totalnum ;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;


    protected static Logger logger = LoggerFactory.getLogger(ConnMsgProcessor.class);


    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.count = 0;
        this.receiveCount = 0;

    }

    @Override
    public void receiveConnStatePerflow(MyConnMessageProto.ConnState connState) {
        //step 2: send connstate to NF2
        connStateStorage.getStateMap().put(connState.getCxid(),connState);
        ConnStateChunk connStateChunk = null;
        connStateChunk = new ConnStateChunk(connStateStorage.getRunNFs().get("NF2"), connState);
        threadPool.submit(connStateChunk);
    }

    @Override
    public void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg) {
        //step 3: receive the firewall(NF2) ack and unlock the packet in NF1
        if(connPutPerflowAckMsg.hasFwstate()){
            unlock(connStateStorage.getRunNFs().get("NF1"));
           if(connPutPerflowAckMsg.getFwstate() == MyConnMessageProto.ConnPutPerflowAckMsg.fwState.OPEN){
               //step 4: if is open, send the state to NAT(NF3)
               ConnStateChunk connStateChunk = null;
               connStateChunk = new ConnStateChunk(connStateStorage.getRunNFs().get("NF3"),
                       connStateStorage.getStateMap().get(connPutPerflowAckMsg.getCxid()) );
               threadPool.submit(connStateChunk);
           }
        } else if(connPutPerflowAckMsg.hasNatHash()){
            //step 5: unlock the packet in NF2
            unlock(connStateStorage.getRunNFs().get("NF2"));
        }

    }

    public void addConnStateStorage(ConnStateStorage connStateStorage){
        //logger.info("添加了connection storage");
        this.connStateStorage = connStateStorage;
    }

    @Override
    public void unlock(NetworkFunction dst) {
        MyConnMessageProto.MyConnMessage putPerflowMessage = null;
        putPerflowMessage = MyConnMessageProto.MyConnMessage.newBuilder()
                .setDataType(MyConnMessageProto.MyConnMessage.DataType.UnlockMsgType)
                .setUnlockMsg(MyConnMessageProto.UnlockMsg.newBuilder().build()).build();
        dst.getConnectionChannel().sendMessage(putPerflowMessage);
    }
}
















