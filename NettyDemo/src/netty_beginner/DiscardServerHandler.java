package netty_beginner;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;


public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception { // (2)
////        super.channelRead(ctx, msg);
////        ((ByteBuf) msg).release(); // (3)
//        ByteBuf in = (ByteBuf) msg;
//        try {
//        	
//            ctx.write(msg); // (1)
//            ctx.flush(); // (2)
//        	
//            while (in.isReadable()) {
//                System.out.print((char) in.readByte());
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
//    }
    
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
      
            //do something msg  
            ByteBuf buf = (ByteBuf)msg;  
            byte[] data = new byte[buf.readableBytes()];  
            buf.readBytes(data);  
            String request = new String(data, "utf-8");  
            System.out.println("Server: " + request);  
            //写给客户端  
            String response = "我是反馈的信息";  
//            ctx.writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));  
            ctx.writeAndFlush(request);
            //.addListener(ChannelFutureListener.CLOSE);  
 
    }      

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception { // (5)
//        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
