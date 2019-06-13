package com.aplikasi.chat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChatMessageConverter {
    private static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
    public static String convertToJSON(ChatMessage chatMessage){
        return gson.toJson(chatMessage);
    }
    public static ChatMessage convertFromJSON(String json){
        return gson.fromJson(json, ChatMessage.class);
    }
}
