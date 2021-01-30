package version1.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version1.interfaces.NetworkFunction;
import version1.interfaces.msgprocessors.perflow.ConnProcessPerflow;
import version1.proto.object.*;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 12:22
 * @Description:
 */
public class ConnMsgProcessor extends ConnProcessPerflow {
    private volatile int count ;
    private volatile int totalnum ;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;
    private ConcurrentLinkedQueue<ConnStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ConnMsgProcessor.class);

    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.statesList = new ConcurrentLinkedQueue<ConnStateChunk>();
    }

    public void receiveConnStatePerflow(ConnStateProto.ConnState connState) {
        logger.info("conn receive state current time "+System.currentTimeMillis()+" data="+connState.getData());

        ConnStateChunk connStateChunk = null;

        connStateChunk = new ConnStateChunk(connStateStorage.getDst(), connState);
        threadPool.submit(connStateChunk);

    }


    public void releaseStates(){
        try {
            threadPool.invokeAll(statesList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getConnPerflowAck(ConnGetPerflowAckMsgProto.ConnGetPerflowAckMsg msg) {
        totalnum = msg.getCount();
        //System.out.println("connection totalnum:"+ totalnum);
        logger.info("connection totalnum:"+ totalnum);
    }

    public void putConnPerflowAck(ConnPutPerflowAckMsgProto.ConnPutPerflowAckMsg msg) {
        count++;
        //System.out.println("connection put perflow count"+count);
        logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        logger.info("connection put perflow count"+count);
        logger.info("connection put perflow totalnum"+totalnum);
        if(count == totalnum){
            setConnStateStorageAck();
        }
    }

    public void sendConnGetPerflow(NetworkFunction nf, String key) {
        logger.info("发送了connection getperflow");
        ConnGetPerflowMsgProto.ConnGetPerflowMsg connGetPerflowMsg = ConnGetPerflowMsgProto.ConnGetPerflowMsg.newBuilder()
                .setKey(key).build();

        nf.getConnectionChannel().sendMessage(connGetPerflowMsg);
    }



    public void addConnStateStorage(ConnStateStorage connStateStorage){
        //System.out.println("添加了connection storage");
        logger.info("添加了connection storage");
        this.connStateStorage = connStateStorage;
    }

    public void testSendPutFlow(){
        System.out.println("test send putperflow");
        ConnStateChunk connStateChunk = null;
        for(int i = 1; i <= 5;i++){
            ConnStateProto.ConnState connState = ConnStateProto.ConnState.newBuilder()
                    .setData(i).build();
            connStateChunk = new ConnStateChunk(connStateStorage.getDst(), connState);
            threadPool.submit(connStateChunk);
        }
    }

    public void setConnStateStorageAck(){
        //System.out.println("test receive ack process");
        logger.info("set a stateStorage Ack");
        this.connStateStorage.setAck();
    }


}
