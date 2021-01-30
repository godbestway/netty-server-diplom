package version1.zmove.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version1.interfaces.NetworkFunction;
import version1.proto.object.ConnPutPerflowMsgProto;
import version1.proto.object.ConnStateProto;
import version1.proto.object.FlowStateProto;
import version1.proto.object.PutPerflowProto;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 14.01.2021 14:42
 * @Description:
 */
public class ConnStateChunk implements Callable<Boolean>{
    private NetworkFunction dst;
    //Todo for Multiflow
    private ConnStateProto.ConnState connState;
    private int stateCount;
    protected static Logger logger = LoggerFactory.getLogger(ConnStateChunk.class);

    public ConnStateChunk(NetworkFunction dst,  ConnStateProto.ConnState connState) {
        this.dst = dst;
        this.connState = connState;
    }



    public Boolean call() throws Exception {
        logger.info("ConnstateChuck call before build"+System.currentTimeMillis()+"connState "+connState.getData());
        ConnPutPerflowMsgProto.ConnPutPerflowMsg connPutPerflowMsg = ConnPutPerflowMsgProto.ConnPutPerflowMsg
                .newBuilder().setState(this.connState).build();

        logger.info("send a connection putPerFlowMsg after build"+connState.getData());
        this.dst.getConnectionChannel().sendMessage(connPutPerflowMsg);
        logger.info("send a connection putPerFlowMsg send finish"+connState.getData());

        return true;
    }

    /*public void run() {
        PutPerflowProto.PutPerflowMsg putPerflowMsg = PutPerflowProto.PutPerflowMsg.newBuilder()
                .setState(this.flowState)
                .setCount(this.stateCount)
                .build();
        System.out.println("send putperflow");
        this.dst.getConnectionChannel().sendMessage(putPerflowMsg);


    }*/
}
