package zsfc;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.Perflow.ConnProcessPerflow;
import interfaces.msgprocessors.sfc.ConnProcessSfc;
import interfaces.msgprocessors.sfc.UnlockSfc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;



import java.util.Map;
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
        //System.out.println(connState.getCxid());
        logger.info("receive the conn state perflow");
        connStateStorage.getStateMap().put(connState.getCxid(),connState);
        logger.info("connstate cxid"+connState.getCxid());
        logger.info("connstate hash"+connState.getHash());
        ConnStateChunk connStateChunk = null;
        logger.info(connStateStorage.getRunNFs().get("nf2").toString());
        connStateChunk = new ConnStateChunk(connStateStorage.getRunNFs().get("nf2"), connState);
        threadPool.submit(connStateChunk);
    }

    @Override
    public void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg) {
        if(connPutPerflowAckMsg.hasHash()){
            logger.info("hash hash"+connPutPerflowAckMsg.getHash());
        }
        if(connPutPerflowAckMsg.hasCxid()) {
            logger.info("has cxid" + connPutPerflowAckMsg.getCxid());
        }
        logger.info("has firewall state"+connPutPerflowAckMsg.hasFwstate()+connPutPerflowAckMsg.getFwstate());
        if(connPutPerflowAckMsg.hasFwstate()){
            logger.info("unlock the packet in prads");
            //step 4: receive the firewall(NF2) ack and unlock the packet in NF1
            unlock(connStateStorage.getRunNFs().get("nf1"));
           if(connPutPerflowAckMsg.getFwstate() == MyConnMessageProto.ConnPutPerflowAckMsg.fwState.OPEN){
               //step 5: if is open, send the state to NAT(NF3)
               ConnStateChunk connStateChunk = null;
               connStateChunk = new ConnStateChunk(connStateStorage.getRunNFs().get("nf3"),
                       connStateStorage.getStateMap().get(connPutPerflowAckMsg.getCxid()) );
               threadPool.submit(connStateChunk);
           }
        } else if(connPutPerflowAckMsg.hasNatHash()){
            //step 6: unlock the packet in NF2
            logger.info("unlock the packet in firewall");
            unlock(connStateStorage.getRunNFs().get("nf2"));
        }else{
            logger.info("no firewall state");
        }

    }

    public void addConnStateStorage(ConnStateStorage connStateStorage){
        logger.info("添加了connection storage");
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
















