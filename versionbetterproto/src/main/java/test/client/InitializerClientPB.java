package test.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import proto.MyConnMessageProto;

/**
 * @Author: Chenglin Ding
 * @Date: 27.01.2021 12:12
 * @Description:
 */
public class InitializerClientPB   extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception
    {
        ChannelPipeline pipeline=socketChannel.pipeline();
        pipeline.addLast("framer Decoder",new ProtobufVarint32FrameDecoder());//protobuf的帧解码器，用于解决TCP粘包和拆包问题
        pipeline.addLast("Protobuf decoder", new ProtobufDecoder(MyConnMessageProto.MyConnMessage.getDefaultInstance()));//设置我们的proto文件生成的实例，其实就是我们的目标Java类
        pipeline.addLast("framer Encoder", new ProtobufVarint32LengthFieldPrepender());//protobuf方式的编码器，用于解决TCP粘包和拆包问题
        pipeline.addLast("Protobuf encoder",new ProtobufEncoder());//protobuf编码器
        pipeline.addLast("handler", new HandlerClientPB());
    }

}
