package zmove;

import interfaces.HwProtoParameters;
import interfaces.NetworkFunction;
import interfaces.ProtoParameters;
import interfaces.msgprocessors.Perflow.ConnProcessPerflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;


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
    public static volatile int totalnum ;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;
    //private ConcurrentLinkedQueue<ConnStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ConnMsgProcessor.class);

    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        //this.statesList = new ConcurrentLinkedQueue<ConnStateChunk>();
    }


    public void receiveConnStatePerflow(MyConnMessageProto.ConnState connState) {
        //logger.info("conn receive state current time "+System.currentTimeMillis()+" data="+connState.getCxid());
        ConnStateChunk connStateChunk = null;
        //int cxid = (int)connState.getCxid();
        //logger.info("connstate cxid "+connState.getCxid());
        connStateChunk = new ConnStateChunk(connStateStorage.getDst(), connState);
        threadPool.submit(connStateChunk);
    }

    public void getConnPerflowAck(MyConnMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg) {
        totalnum = connGetPerflowAckMsg.getCount();
        //logger.info("connection getperflow totalnum:"+ totalnum);
    }

    public void putConnPerflowAck(MyConnMessageProto.ConnPutPerflowAckMsg connPutPerflowAckMsg) {
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
        MyConnMessageProto.MyConnMessage myMessage = MyConnMessageProto.MyConnMessage.newBuilder()
                .setDataType(MyConnMessageProto.MyConnMessage.DataType.ConnGetPerflowMsgType)
                .setConnGetPerflowMsg(MyConnMessageProto.ConnGetPerflowMsg.newBuilder()
                        .setHwProto(HwProtoParameters.TYPE_IPv4)
                        .setProto(ProtoParameters.PROTOCOL_TCP).build())
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
