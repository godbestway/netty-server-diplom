package backup;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @Author: Chenglin Ding
 * @Date: 31.01.2021 18:33
 * @Description:
 */
@ChannelHandler.Sharable
public class MyEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {
    public MyEncoder() {
    }

    protected void encode(ChannelHandlerContext ctx, MessageLiteOrBuilder msg, List<Object> out) throws Exception {
        if (msg instanceof MessageLite) {
            out.add(Unpooled.wrappedBuffer(((MessageLite)msg).toByteArray()));
        } else {
            if (msg instanceof MessageLite.Builder) {
                out.add(Unpooled.wrappedBuffer(((MessageLite.Builder)msg).build().toByteArray()));
            }

        }
    }
}
