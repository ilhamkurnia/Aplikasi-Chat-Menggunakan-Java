package com.aplikasi.chat;


import java.util.Date;

public class ChatMessage {
    private String sender;
    private String message;
    private ChatAction action;
    private Date datetime;

    public String getSender(){
        return sender;
    }
    public void setSender(String sender){
        this.sender=sender;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public ChatAction getAction(){
        return action;
    }
    public void setAction(ChatAction action){
        this.action=action;
    }
    public Date getDatetime(){
        return datetime;
    }
    public void setDatetime(Date datetime){
        this.datetime=datetime;
    }
}
