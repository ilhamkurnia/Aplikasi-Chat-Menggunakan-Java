package com.aplikasi.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ClientApp {
    public static void main(String[] args) throws InterruptedException{
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ClientInitializer());

        Channel server = bootstrap.connect("localhost", 8000).sync().channel();
        ChatSender chatSender = new ChatSender();
        chatSender.run(server);

        group.shutdownGracefully();
    }
}
