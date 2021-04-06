package zconnaccopy;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.Perflow.ConnProcessPerflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;

import java.util.Iterator;
import java.util.List;
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
    private volatile int receiveCount ;
    public static volatile int totalnum ;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;
    //private ConcurrentLinkedQueue<ConnStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ConnMsgProcessor.class);

    private ConcurrentLinkedQueue<Integer> ackCxidList;
    private ConcurrentLinkedQueue<Integer> receiveCxidList;

    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.count = 0;
        this.receiveCount = 0;
        this.ackCxidList = new ConcurrentLinkedQueue<Integer>();
        this.receiveCxidList = new ConcurrentLinkedQueue<Integer>();
        //this.statesList = new ConcurrentLinkedQueue<ConnStateChunk>();
    }

    public void showReceiveList(){
        logger.info("conn showReveiveList");
        Iterator it1 = this.receiveCxidList.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next()+", ");
            //logger.info(it1.next()+", ");
        }
        System.out.println(" ");

    }

    public void receiveConnStatePerflow(MyConnMessageProto.ConnState connState) {
        receiveCxidList.add(connState.getHash());
        receiveCount++;
        //logger.info("conn receive state current time "+System.currentTimeMillis());
        //logger.info("conn receive:"+ receiveCount);

        //showReceiveList();

        //showConnState(connState);
        ConnStateChunk connStateChunk = null;
        connStateChunk = new ConnStateChunk(connStateStorage.getDst(), connState);
        threadPool.submit(connStateChunk);
    }

    public void getConnPerflowAck(MyConnMessageProto.ConnGetPerflowAckMsg connGetPerflowAckMsg) {
        totalnum = connGetPerflowAckMsg.getCount();
        logger.info("getPerflowAck connection totalnum:"+ totalnum);
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

    //mode = 1 is move operation, mode = 2 is copy
    public void sendConnGetPerflow(NetworkFunction nf, short hwParameters, byte protoParameters, int mode) {
        logger.info("发送了connection getperflow");
        MyConnMessageProto.MyConnMessage myMessage = MyConnMessageProto.MyConnMessage.newBuilder()
                .setDataType(MyConnMessageProto.MyConnMessage.DataType.ConnGetPerflowMsgType)
                .setConnGetPerflowMsg(MyConnMessageProto.ConnGetPerflowMsg.newBuilder()
                        .setHwProto(hwParameters)
                        .setProto(protoParameters)
                        .setMode(mode)
                        .build())
                .build();

        nf.getConnectionChannel().sendMessage(myMessage);
    }

    public void showConnState(MyConnMessageProto.ConnState connState){

        List<Integer> src_etherList = connState.getEtherSrcList();
        StringBuilder src_ethernet = new StringBuilder();
        for (int i = 0; i < src_etherList.size(); i++) {
            Integer src_num = src_etherList.get(i);
            //logger.info("src"+i+"src num"+src_num);
            src_ethernet.append(src_num);
            src_ethernet.append(":");
        }
        logger.info("connstate src_ethernet" + src_ethernet);
        /*
        List<Integer> dst_etherList = connState.getEtherDstList();
        StringBuilder dst_ethernet = new StringBuilder();
        for(int i = 0; i< dst_etherList.size();i++){
            Integer dst_num = dst_etherList.get(i);
            //logger.info("dst"+i+"dst num"+dst_num);
            dst_ethernet.append(dst_num);
            dst_ethernet.append(":");
        }
        logger.info("connstate dst_ethernet"+dst_ethernet);
        */
        logger.info("connstate sip"+connState.getSIp());
        logger.info("connstate dip"+connState.getDIp());
        logger.info("connstate s_port"+connState.getSPort());
        //logger.info("connstate d_port"+connState.getDPort());
        //logger.info("connstate hw_proto"+connState.getHwProto());
        logger.info("connstate proto"+connState.getProto());
        logger.info("connstate cxid"+connState.getCxid());
        logger.info("connstate hash"+connState.getHash());
        logger.info("connstate nat_hash"+connState.getNatHash());
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
