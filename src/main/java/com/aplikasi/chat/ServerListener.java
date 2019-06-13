package com.aplikasi.chat;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerListener  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception{

        String json = msg.toString();
        ChatMessage chatMessage = ChatMessageConverter.convertFromJSON(json);

        if(chatMessage.getAction().equals(ChatAction.LOGIN)){
            ClientDatabase.login(ctx.channel());
            ClientDatabase.chat(ctx.channel(), json);
        }else if (chatMessage.getAction().equals(ChatAction.LOGOUT)){
            ClientDatabase.logout(ctx.channel());
            ClientDatabase.chat(ctx.channel(), json);
            ctx.channel().close();
        }else if(chatMessage.getAction().equals(ChatAction.CHAT)){
            ClientDatabase.chat(ctx.channel(), json);
        }
    }

    }


