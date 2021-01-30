package zmove;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.Perflow.ConnProcessPerflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyMessageProto;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:27
 * @Description:
 */

public class ConnMsgProcessor extends ConnProcessPerflow{
    private volatile int count ;
    private volatile int totalnum ;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;
    //private ConcurrentLinkedQueue<ConnStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ConnMsgProcessor.class);

    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        //this.statesList = new ConcurrentLinkedQueue<ConnStateChunk>();
    }


    public void receiveConnStatePerflow(MyMessageProto.ConnState connState) {
        //logger.info("conn receive state current time "+System.currentTimeMillis()+" data="+connState.getData());
        ConnStateChunk connStateChunk = null;
        connStateChunk = new ConnStateChunk(connStateStorage.getDst(), connState);
        threadPool.submit(connStateChunk);
    }

    public void getConnPerflowAck(MyMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg) {
        totalnum = connGetPerflowAckMsg.getCount();
        logger.info("connection totalnum:"+ totalnum);
    }

    public void putConnPerflowAck(MyMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg) {
        count++;
        //System.out.println("connection put perflow count"+count);
        //logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        //logger.info("connection put perflow count"+count);
        //logger.info("connection put perflow totalnum"+totalnum);
        if(count == totalnum){
            setConnStateStorageAck();
        }

    }

    public void sendConnGetPerflow(NetworkFunction nf, String key) {
        logger.info("发送了connection getperflow");
        MyMessageProto.MyMessage myMessage = MyMessageProto.MyMessage.newBuilder()
                .setDataType(MyMessageProto.MyMessage.DataType.ConnGetPerflowMsgType)
                .setConnGetPerflowMsg(MyMessageProto.ConnGetPerflowMsg.newBuilder()
                        .setKey(key).build())
                .build();

        nf.getConnectionChannel().sendMessage(myMessage);
    }

    public void addConnStateStorage(ConnStateStorage connStateStorage){
        //logger.info("添加了connection storage");
        this.connStateStorage = connStateStorage;
    }


    public void setConnStateStorageAck(){
        //logger.info("set a stateStorage Ack");
        this.connStateStorage.setAck();
    }
}
