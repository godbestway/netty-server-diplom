package backup.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: Chenglin Ding
 * @Date: 31.01.2021 18:33
 * @Description:
 */
@ChannelHandler.Sharable
public class MyPerpender extends MessageToByteEncoder<ByteBuf> {
    private  static  volatile int num=0;
    public MyPerpender() {
    }

    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        num++;
        int bodyLen = msg.readableBytes();
        int headerLen = computeRawVarint32Size(bodyLen);
        out.ensureWritable(headerLen + bodyLen);
        writeRawVarint32(out, bodyLen);
        out.writeBytes(msg, msg.readerIndex(), bodyLen);
    }

    static void writeRawVarint32(ByteBuf out, int value) {
        //System.out.println("---------------"+num+"------------------");
        while((value & -128) != 0) {
            out.writeByte(value & 127 | 128);
            //System.out.printf("encoder middle %x",(value & 127 | 128));
            value >>>= 7;
        }
        //System.out.println("encoder final"+value);
        out.writeByte(value);
        //System.out.println("---------------"+num+"------------------");
    }

    static int computeRawVarint32Size(int value) {
        if ((value & -128) == 0) {
            return 1;
        } else if ((value & -16384) == 0) {
            return 2;
        } else if ((value & -2097152) == 0) {
            return 3;
        } else {
            return (value & -268435456) == 0 ? 4 : 5;
        }
    }
}
