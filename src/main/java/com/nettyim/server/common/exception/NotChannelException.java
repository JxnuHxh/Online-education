package com.nettyim.server.common.exception;


@SuppressWarnings("serial")
public class NotChannelException extends NettyImException {
    
    public NotChannelException() {
        super("channelHandlerContext not found");
    }
}
