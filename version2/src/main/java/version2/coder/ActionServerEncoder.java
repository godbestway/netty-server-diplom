package version2.coder;

import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import version2.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 25.01.2021 15:36
 * @Description:
 */
public class ActionServerEncoder extends MessageToByteEncoder<MessageLite> {
    protected static Logger logger = LoggerFactory.getLogger(ActionServerEncoder.class);

    public ActionServerEncoder() {
    }

    protected void encode(ChannelHandlerContext channelHandlerContext, MessageLite msg, ByteBuf out) throws Exception {
        logger.info("begin encode"+System.currentTimeMillis());
        byte[] body = msg.toByteArray();
        byte[] header = encodeHeader(msg, (short)body.length);
        //System.out.println("msg encode");

        /*for(int i = 0; i < header.length; i++){
            //System.out.println(body[i]);
            System.out.printf("%x\n",header[i]);
        }*/
        out.writeBytes(header);
        /*for(int i = 0; i < body.length; i++){
            //System.out.println(body[i]);
            System.out.printf("%x\n",body[i]);
        }*/
        out.writeBytes(body);
        logger.info("finish encode"+System.currentTimeMillis());

        return;
    }

    private byte[] encodeHeader(MessageLite msg, short bodyLength) {

        byte messageType = 0x0f;

        if (msg instanceof PersonProto.Person) {
            //System.out.println("person");
            logger.info("msg type: person");
            messageType = 0x00;
        }  else if(msg instanceof SynProto.Syn){
            //System.out.println("syn message");
            logger.info("msg type: syn message");
            messageType = 0x02;
        }else if(msg instanceof ActionGetPerflowMsgProto.ActionGetPerflowMsg){
            messageType = 0x04;
        } else if(msg instanceof ActionPutPerflowProto.ActionPutPerflowMsg){
            messageType = 0x06;
        }

        byte[] header = new byte[4];
        header[0] = (byte) (bodyLength & 0xff);
        header[1] = (byte) ((bodyLength >> 8) & 0xff);
        header[2] = 0; // 保留字段
        header[3] = messageType; // message type
        return header;

    }
}
