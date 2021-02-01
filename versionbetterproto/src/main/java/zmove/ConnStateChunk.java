package zmove;

import interfaces.NetworkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proto.MyConnMessageProto;

import java.util.concurrent.Callable;

/**
 * @Author: Chenglin Ding
 * @Date: 29.01.2021 13:02
 * @Description:
 */
public class ConnStateChunk  implements Callable<Boolean> {
    private NetworkFunction dst;
    //Todo for Multiflow
    private MyConnMessageProto.ConnState connState;
    private int stateCount;
    protected static Logger logger = LoggerFactory.getLogger(ConnStateChunk.class);

    public ConnStateChunk(NetworkFunction dst,  MyConnMessageProto.ConnState connState) {
        this.dst = dst;
        this.connState = connState;
    }



    public Boolean call() throws Exception {
        logger.info("send a connState "+connState.getCxid());

        MyConnMessageProto.MyConnMessage putPerflowMessage = null;
        putPerflowMessage = MyConnMessageProto.MyConnMessage.newBuilder()
                .setDataType(MyConnMessageProto.MyConnMessage.DataType.ConnPutPerflowMsgType)
                .setConnPutPerflowMsg(MyConnMessageProto.ConnPutPerflowMsg
                        .newBuilder().setState(this.connState).build())
                .build();
        this.dst.getConnectionChannel().sendMessage(putPerflowMessage);
        //logger.info("send a connection putPerFlowMsg send finish"+connState.getData());

        return true;
    }


}
