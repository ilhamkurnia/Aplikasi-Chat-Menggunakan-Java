package com.aplikasi.chat;

import io.netty.channel.Channel;

import java.util.Date;
import java.util.Scanner;

public class ChatSender {
    private Scanner input = new Scanner(System.in);
    private String username;

    public void run(Channel server){
        while(true){
            String message = input.nextLine();
            if(message.startsWith("login")&& username == null){
                username = message.substring("login".length()).trim();
                sendLoginMessage(server);
            }else if(message.equals("logout")){
                sendLogoutMessage(server);
                break;
            }else {
                sendChatMessage(server, message);
            }
        }
    }

    public void sendLoginMessage(Channel server){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setAction(ChatAction.LOGIN);
        chatMessage.setDatetime(new Date());
        chatMessage.setSender(username);

        String json =  ChatMessageConverter.convertToJSON(chatMessage);
        server.writeAndFlush(json);
    }

    public void sendLogoutMessage(Channel server){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setAction(ChatAction.LOGOUT);
        chatMessage.setDatetime(new Date());
        chatMessage.setSender(username);

        String json = ChatMessageConverter.convertToJSON(chatMessage);
        server.writeAndFlush(json);
    }

    public void sendChatMessage(Channel server, String message){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setAction((ChatAction.CHAT));
        chatMessage.setDatetime(new Date());
        chatMessage.setSender(username);
        chatMessage.setMessage(message);

        String json = ChatMessageConverter.convertToJSON(chatMessage);
        server.writeAndFlush(json);
    }
}
