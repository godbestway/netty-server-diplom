package zmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyMessageProto;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 13:02
 * @Description:
 */
public class ConnStateChunk  implements Callable<Boolean> {
    private NetworkFunction dst;
    //Todo for Multiflow
    private MyMessageProto.ConnState connState;
    private int stateCount;
    protected static Logger logger = LoggerFactory.getLogger(ConnStateChunk.class);

    public ConnStateChunk(NetworkFunction dst,  MyMessageProto.ConnState connState) {
        this.dst = dst;
        this.connState = connState;
    }



    public Boolean call() throws Exception {
        //logger.info("ConnstateChuck call before build"+System.currentTimeMillis()+"connState "+connState.getData());

        MyMessageProto.MyMessage putPerflowMessage = null;
        putPerflowMessage = MyMessageProto.MyMessage.newBuilder()
                .setDataType(MyMessageProto.MyMessage.DataType.ConnPutPerflowMsgType)
                .setConnPutPerflowMsg(MyMessageProto.ConnPutPerflowMsg
                        .newBuilder().setState(this.connState).build())
                .build();
        this.dst.getConnectionChannel().sendMessage(putPerflowMessage);
        //logger.info("send a connection putPerFlowMsg send finish"+connState.getData());

        return true;
    }


}
