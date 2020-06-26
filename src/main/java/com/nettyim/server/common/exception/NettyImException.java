package com.nettyim.server.common.exception;


@SuppressWarnings("serial")
public abstract class NettyImException extends Exception {
 
    public NettyImException(String message) {
        super(message);
    }

    public NettyImException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
