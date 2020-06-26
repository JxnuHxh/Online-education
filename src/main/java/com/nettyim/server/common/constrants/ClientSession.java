package com.nettyim.server.common.constrants;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;


public class ClientSession {
	
    public static Map<String, ChannelHandlerContext> sessionMap = new HashMap<String, ChannelHandlerContext>();
}
