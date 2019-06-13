package com.aplikasi.chat;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;

public class ClientDatabase {
private static List<Channel>channels = new ArrayList<>();
    public static void login(Channel channel) {
        channels.add(channel);
    }
    public static void logout(Channel channel) {
        channels.remove(channel);
    }
    public static void chat(Channel sender, String json) {

        List<Channel> hasilFilter = new ArrayList<>();
        for (Channel channel : channels) {
            if (channel != sender) {

                hasilFilter.add(channel);
            }
        }

        for (Channel channel : hasilFilter) {
            channel.writeAndFlush(json);
        }
    }
}
