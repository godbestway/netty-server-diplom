package version1.zcore;

import version1.interfaces.perflow.ProcessPerflow;
import version1.proto.object.FlowStateProto;
import version1.proto.object.GetPerflowAckProto;
import version1.proto.object.GetPerflowProto;

import javax.xml.transform.Source;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 12:22
 * @Description:
 */
public class ConnMsgProcessor extends ProcessPerflow {
    private int count  = 0;
    private  int totalnum = 0;
    private ConnStateStorage connStateStorage;
    private ExecutorService threadPool;

    public ConnMsgProcessor(){
        this.threadPool = Executors.newCachedThreadPool();
    }

    public void receiveStatePerflow(FlowStateProto.FlowState flowState) {
        System.out.println("receive a state, data="+flowState.getData());


    }

    public void getPerflowAck(GetPerflowAckProto.GetPerflowAckMsg getPerflowAckMsg) {

    }

    public void putPerflowAck() {

    }

    public void sendGetPerflow(NetworkFunction nf, String key) {
        System.out.println("发送了getperflow");
        GetPerflowProto.GetPerflowMsg getPerflowMsg = GetPerflowProto.GetPerflowMsg.newBuilder()
                .setKey(key).build();
        nf.getConnectionChannel().sendMessage(getPerflowMsg);

    }

    public void sendPutPerflow() {

    }

    public void addConnStateStorage(ConnStateStorage connStateStorage){
        this.connStateStorage = connStateStorage;
    }
}
