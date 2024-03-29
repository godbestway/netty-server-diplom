package zconnaccopy;

import interfaces.NetworkFunction;
import interfaces.msgprocessors.Allflows.ActionProcessAllflows;
import interfaces.msgprocessors.Perflow.ActionProcessPerflow;
import interfaces.msgprocessors.ProcessReceiveMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyActionMessageProto;
import proto.MyConnMessageProto;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 11:27
 * @Description:
 */
public class ActionMsgProcessor extends ActionProcessAllflows {
    private volatile int receiveCount;

    private volatile int countPerflow;
    private volatile int totalPerflow ;
    private volatile int countMultiflow;
    private volatile int totalMultiflow ;
    private volatile int countAllflow;
    private volatile int totalAllflow ;
    private boolean perflowAck;
    private boolean multiflowAck;
    private boolean allflowAck;

    private ActionStateStorage actionStateStorage;
    private ExecutorService threadPool;
    //private ConcurrentLinkedQueue<ActionStateChunk> statesList;
    protected static Logger logger = LoggerFactory.getLogger(ActionMsgProcessor.class);

    private ConcurrentLinkedQueue<Integer> ackCxidList;
    private ConcurrentLinkedQueue<Integer> receiveCxidList;

    public ActionMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
        this.countPerflow = 0;
        this.countMultiflow = 0;
        this.countAllflow = 0;
        this.perflowAck = false;
        this.multiflowAck = false;
        this.allflowAck = false;
        //this.statesList = new ConcurrentLinkedQueue<ActionStateChunk>();
        this.ackCxidList = new ConcurrentLinkedQueue<Integer>();
        this.receiveCxidList = new ConcurrentLinkedQueue<Integer>();
    }

    public void showAckList(){
        logger.info("showAckList");

        Iterator it1 = this.ackCxidList.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next()+", ");
        }


    }

    public void showReceiveList(){
        logger.info("action showReveiveList");
        Iterator it1 = this.receiveCxidList.iterator();

        while(it1.hasNext()){
            System.out.print(it1.next()+", ");
        }

    }

    public void receiveActionStatePerflow(MyActionMessageProto.ActionState actionState) {
        receiveCxidList.add(actionState.getHash());
        receiveCount++;
        //showNATActionState(actionState);
        //logger.info("action receive:"+ receiveCount);

        //showReceiveList();
        //actionState.getSAsset() ;
        //MyActionMessageProto.Asset asset = null;
        //actionState.toBuilder()
        //        .setCAsset(asset)
        //        .setSAsset(asset).build();


        //showFWActionState(actionState);
        //logger.info("action receive state current time "+actionState.getCxid());
        //&& (receiveCount < 36)(receiveCount > 20)&&

        //if((actionState.getHash() == 7074) || (actionState.getHash() == 7330)) {
            ActionStateChunk actionStateChunk = new ActionStateChunk(actionStateStorage.getDst(), actionState);
            threadPool.submit(actionStateChunk);
            //showActionState(actionState);
        //}
    }

    public void getActionPerflowAck(MyActionMessageProto.ActionGetPerflowAckMsg actionGetPerflowAckMsg) {

        totalPerflow = actionGetPerflowAckMsg.getCount();
        logger.info("getPerflowAck action totalnum:"+ totalPerflow);
        //logger.info("getPerflowAck action count:"+ count);
        if(totalPerflow == countPerflow){
            perflowAck = true;
            setActionStateStorageAck();
        }

    }

    public void putActionPerflowAck(MyActionMessageProto.ActionPutPerflowAckMsg actionPutPerflowAckMsg) {
        countPerflow++;
        //ackCxidList.add(actionPutPerflowAckMsg.getHash());
        //showAckList();
        //System.out.println("connection put perflow count"+count);
        //logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        //logger.info("action put perflow cxid"+ actionPutPerflowAckMsg.getCxid());
        //logger.info("action put perflow count"+ countPerflow);
        //logger.info("action put perflow totalnum"+totalnum);
        //logger.info("action put perflow num"+count);
        if(totalPerflow == countPerflow){
            perflowAck = true;
            setActionStateStorageAck();
        }
    }

    @Override
    public void sendActionGetMultiflow(NetworkFunction nf) {
        logger.info("发送了action getpMultiflow");
        MyActionMessageProto.MyActionMessage myActionMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionGetMultiflowMsgType)
                .setActionGetMultiflowMsg(MyActionMessageProto.ActionGetMultiflowMsg.newBuilder().build())
                .build();

        nf.getActionChannel().sendMessage(myActionMessage);
    }

    @Override
    public void getActionMultiflowAck(MyActionMessageProto.ActionGetMultiflowAckMsg actionGetMultiflowAckMsg) {
        totalMultiflow = actionGetMultiflowAckMsg.getCount();
        //logger.info("getMultiflowAck action totalnum:"+ totalMultiflow);
        //logger.info("getPerflowAck action count:"+ count);

        if(totalMultiflow == countMultiflow){
            multiflowAck = true;
            setActionStateStorageAck();
        }


    }

    @Override
    public void receiveActionStateMultiflow(MyActionMessageProto.ActionMultiState actionMultiState) {
        //showNATActionState(actionState);
        //logger.info("action receive: multiflow");
        //showReceiveList();
        //actionStateStorage.getStatesList().add(actionMultiState);
        //showFWActionState(actionState);
        //logger.info("action receive state current time "+actionState.getCxid());
        //&& (receiveCount < 36)(receiveCount > 20)&&

        //if((actionState.getHash() == 7074) || (actionState.getHash() == 7330)) {
        ActionStateChunk actionStateChunk = new ActionStateChunk(actionStateStorage.getDst(), actionMultiState);
        threadPool.submit(actionStateChunk);
        //showAsset(actionMultiState.getMultiState());
        //}

    }

    @Override
    public void putActionMultiflowAck(MyActionMessageProto.ActionPutMultiflowAckMsg actionPutMultiflowAckMsg) {
        countMultiflow++;
        //ackCxidList.add(actionPutPerflowAckMsg.getHash());
        //showAckList();
        //System.out.println("connection put perflow count"+count);
        //logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        //logger.info("action put perflow cxid"+ actionPutPerflowAckMsg.getCxid());
        //logger.info("action put perflow count"+ count);
        //logger.info("action put perflow totalnum"+totalnum);
        //logger.info("action put multiflow num"+countMultiflow);
        if(totalMultiflow == countMultiflow){
            multiflowAck = true;
            setActionStateStorageAck();
        }
    }

    @Override
    public void sendActionGetAllflow(NetworkFunction nf) {
        logger.info("发送了action getAllflow");
        MyActionMessageProto.MyActionMessage myActionMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionGetAllflowMsgType)
                .setActionGetAllflowMsg(MyActionMessageProto.ActionGetAllflowMsg.newBuilder().build())
                .build();

        nf.getActionChannel().sendMessage(myActionMessage);
    }

    @Override
    public void getActionAllflowAck(MyActionMessageProto.ActionGetAllflowAckMsg actionGetAllflowAckMsg) {
        //Allflow has count?
        totalAllflow = actionGetAllflowAckMsg.getCount();
        logger.info("getAllflowAck action totalnum:"+ totalAllflow);
        //logger.info("getPerflowAck action count:"+ count);
        if(totalAllflow == countAllflow){
            allflowAck = true;
            setActionStateStorageAck();
        }
    }

    @Override
    public void receiveActionStateAllflow(MyActionMessageProto.ActionAllState actionAllState) {
        //showNATActionState(actionState);
        logger.info("action allstate receive:");

        //showReceiveList();

        //showFWActionState(actionState);
        //logger.info("action receive state current time "+actionState.getCxid());
        //&& (receiveCount < 36)(receiveCount > 20)&&

        //if((actionState.getHash() == 7074) || (actionState.getHash() == 7330)) {
        ActionStateChunk actionStateChunk = new ActionStateChunk(actionStateStorage.getDst(), actionAllState);
        threadPool.submit(actionStateChunk);
        //showActionState(actionState);
        //}
    }

    @Override
    public void putActionAllflowAck(MyActionMessageProto.ActionPutAllflowAckMsg actionPutAllflowAckMsg) {
        countAllflow++;
        //ackCxidList.add(actionPutPerflowAckMsg.getHash());
        //showAckList();
        //System.out.println("connection put perflow count"+count);
        //logger.info("conn putperflow ack current time"+System.currentTimeMillis());
        //logger.info("action put perflow cxid"+ actionPutPerflowAckMsg.getCxid());
        //logger.info("action put perflow count"+ count);
        logger.info("action put ALlflow totalnum"+countAllflow);
        //logger.info("action put perflow num"+count);
        if(totalAllflow == countAllflow){
            allflowAck = true;
            setActionStateStorageAck();
        }
    }

    public void sendActionGetPerflow(NetworkFunction nf, short hwParameters, byte protoParameters) {
        logger.info("发送了action getperflow");
        MyActionMessageProto.MyActionMessage myMessage = MyActionMessageProto.MyActionMessage.newBuilder()
                .setDataType(MyActionMessageProto.MyActionMessage.DataType.ActionGetPerflowMsgType)
                .setActionGetPerflowMsg(MyActionMessageProto.ActionGetPerflowMsg.newBuilder()
                        .setHwProto(hwParameters)
                        .setProto(protoParameters).build())
                .build();

        nf.getActionChannel().sendMessage(myMessage);
    }

    public void addActionStateStorage(ActionStateStorage actionStateStorage){
        //logger.info("添加了connection storage");
        this.actionStateStorage = actionStateStorage;
    }

    public void setActionStateStorageAck(){
        //logger.info("set a ActionStorage Ack");
        if(multiflowAck && allflowAck && perflowAck){
            this.actionStateStorage.setAck();
        }
    }

    public void showFWActionState(MyActionMessageProto.ActionState actionState){
        logger.info("action cxid"+actionState.getCxid());
        logger.info("action hash"+actionState.getHash());
        logger.info("action last packet time"+actionState.getLastPktTime());
        logger.info("action state"+actionState.getFwstate());
    }

    public void showNATActionState(MyActionMessageProto.ActionState actionState){
        logger.info("action external ip"+actionState.getExternalIp());
        logger.info("action external port"+actionState.getExternalPort());
        logger.info("action cxid"+actionState.getCxid());
        logger.info("action hash"+actionState.getHash());
        logger.info("action nat hash"+actionState.getNatHash());
        logger.info("action last packet time"+actionState.getLastPktTime());

    }


    public void showActionState(MyActionMessageProto.ActionState actionState){
        logger.info("actionstate start time"+ actionState.getStartTime());
        logger.info("action last packet time"+actionState.getLastPktTime());
        logger.info("action cxid"+actionState.getCxid());
        logger.info("action reversed"+actionState.getReversed());
        logger.info("action af"+actionState.getAf());
        logger.info("action s_total_pkts"+actionState.getSTotalPkts());
        logger.info("action s_total_bytes"+actionState.getSTotalBytes());
        logger.info("action d_total_pkts"+actionState.getDTotalPkts());
        logger.info("action d_total_pkts"+actionState.getDTotalBytes());
        logger.info("action s_tcp_flas"+actionState.getSTcpFlags());
        logger.info("action pad"+actionState.getPad());
        logger.info("action d_tcp_flags"+actionState.getDTcpFlags());
        logger.info("action check"+actionState.getCheck());
        logger.info("action hash"+actionState.getHash());
        if(actionState.hasCAsset()){
            logger.info("c asset exits");
            MyActionMessageProto.Asset c_asset = actionState.getCAsset();
            showAsset(c_asset);
        }
        if(actionState.hasSAsset()){
            logger.info("s asset exits");
            MyActionMessageProto.Asset s_asset = actionState.getSAsset();
            showAsset(s_asset);
        }
    }

    public void showAsset(MyActionMessageProto.Asset asset){
        logger.info("asset  firstSeen"+ asset.getFirstSeen());
        logger.info("asset  lastSeen"+ asset.getLastSeen());
        logger.info("asset  Iattempts"+ asset.getIAttempts());
        logger.info("asset  af"+ asset.getAf());
        logger.info("asset  vlan"+ asset.getVlan());
        logger.info("asset  sip"+ asset.getSIp());
        if(asset.hasServices()){
            showServAsset(asset.getServices());
        }
        if(asset.hasOs()){
            showOSAsset(asset.getOs());
        }
    }

    public void showServAsset(MyActionMessageProto.ServAsset servAsset){
        logger.info("servAsset first_seen"+servAsset.getFirstSeen());
        logger.info("servAsset last_seen"+servAsset.getLastSeen());
        logger.info("servAsset i_attempts"+servAsset.getIAttempts());
        logger.info("servAsset proto"+servAsset.getProto());
        logger.info("servAsset port"+servAsset.getPort());
        logger.info("servAsset ttl"+servAsset.getTtl());
        logger.info("servAsset bservice"+servAsset.getBservice().getData());
        logger.info("servAsset bapplication"+servAsset.getBapplication().getData());
        logger.info("servAsset role"+servAsset.getRole());
        logger.info("servAsset unknown"+servAsset.getUnknown());
    }

    public void showOSAsset(MyActionMessageProto.OsAsset osAsset){
        logger.info("OsAsset first_seen"+osAsset.getFirstSeen());
        logger.info("OsAsset last_seen"+osAsset.getLastSeen());
        logger.info("OsAsset itempts"+osAsset.getIAttempts());
        logger.info("OsAsset bvendor"+osAsset.getBvendor().getData());
        logger.info("OsAsset bos"+osAsset.getBos().getData());
        logger.info("OsAsset detection"+osAsset.getDetection());
        logger.info("OsAsset raw_fp"+osAsset.getRawFp().getData());
        logger.info("OsAsset matched_fp"+osAsset.getMatchedFp().getData());
        logger.info("OsAsset mactch_os"+osAsset.getMatchOs());
        logger.info("OsAsset mactch_desc"+osAsset.getMatchDesc());
        logger.info("OsAsset port"+osAsset.getPort());
        logger.info("OsAsset mtu"+osAsset.getMtu());
        logger.info("OsAsset ttl"+osAsset.getTtl());
        logger.info("OsAsset uptime"+osAsset.getUptime());

    }
}














