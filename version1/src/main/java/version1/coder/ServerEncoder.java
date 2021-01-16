package version1.coder;

import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import version1.proto.object.*;

/**
 * @Author: Chenglin Ding
 * @Date: 30.12.2020 10:08
 * @Description:
 */
public class ServerEncoder extends MessageToByteEncoder<MessageLite> {
    public ServerEncoder() {
    }

    protected void encode(ChannelHandlerContext channelHandlerContext, MessageLite msg, ByteBuf out) throws Exception {
        byte[] body = msg.toByteArray();
        byte[] header = encodeHeader(msg, (short)body.length);
        System.out.println("msg encode");
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

        return;
    }

    private byte[] encodeHeader(MessageLite msg, short bodyLength) {

        byte messageType = 0x0f;

        if (msg instanceof PersonProto.Person) {
            System.out.println("person");
            messageType = 0x00;
        } else if (msg instanceof InformationProto.Information) {
            System.out.println("information");
            messageType = 0x01;
        } else if(msg instanceof SynProto.Syn){
            System.out.println("syn message");
            messageType = 0x02;
        }else if(msg instanceof GetPerflowProto.GetPerflowMsg){
            messageType = 0x03;
        }else if(msg instanceof PutPerflowProto.PutPerflowMsg){
            messageType = 0x04;
        }

        byte[] header = new byte[4];
        header[0] = (byte) (bodyLength & 0xff);
        header[1] = (byte) ((bodyLength >> 8) & 0xff);
        header[2] = 0; // 保留字段
        header[3] = messageType; // message type
        return header;

    }
}
