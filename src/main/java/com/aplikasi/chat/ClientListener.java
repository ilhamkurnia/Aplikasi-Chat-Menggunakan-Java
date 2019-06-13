package com.aplikasi.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientListener extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception {
        String json = msg.toString();
        ChatMessage chatMessage = ChatMessageConverter.convertFromJSON(json);

        if (chatMessage.getAction().equals(ChatAction.LOGIN)){
            String pesan = chatMessage.getSender() + "masuk chat room";
            System.out.println(pesan);
        }else if (chatMessage.getAction().equals(ChatAction.LOGOUT)){
            String pesan =  chatMessage.getSender() + "keluar chat room";
            System.out.println(pesan);
        }else if(chatMessage.getAction().equals(ChatAction.CHAT)){
            String pesan = chatMessage.getSender()+ " : " + chatMessage.getMessage();
            System.out.println(pesan);
        }
    }
}
