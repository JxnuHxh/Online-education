package com.nettyim.server.activator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nettyim.server.server.ChatServer;
import com.nettyim.server.server.WebSocketChatServer;

@SpringBootApplication
@ComponentScan("com.nettyim.server")
public class RunMain implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RunMain.class);

    @Autowired
    private ChatServer chatServer;
    @Autowired
    private WebSocketChatServer webSocketChatServer;
    
    public static void main(String[] args) {
        SpringApplication.run(RunMain.class, args);
    }
    
    public void run(String... strings) throws Exception {
        try {
        	chatServer.start();
        	webSocketChatServer.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            logger.error("startup error!", e);
        }
    }
}
