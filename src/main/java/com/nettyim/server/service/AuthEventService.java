package com.nettyim.server.service;

import io.netty.channel.Channel;

import org.springframework.stereotype.Component;

import com.nettyim.server.common.constrants.AttributeKeyConstrants;
import com.nettyim.server.entity.AuthModel;


@Component
public class AuthEventService {

    /**
     * 设置AuthTokenModel     
     * @param ch
     * @return
     */
    public AuthModel getAuthToken(Channel ch) {
        return ch.attr(AttributeKeyConstrants.KEY_SHELL_ID).get();
    }

    /**
     * 获取AuthTokenModel   
     * @param ch
     * @param token
     */
    public void setAuthToken(Channel ch, AuthModel token) {
        ch.attr(AttributeKeyConstrants.KEY_SHELL_ID).set(token);
    }
    
    /**
     * 清空AuthTokenModel	    
     * @param ch
     * @param token
     */
    public void clearAuthToken(Channel ch) {
        if (getAuthToken(ch) != null) {
            ch.attr(AttributeKeyConstrants.KEY_SHELL_ID).remove();
        }
    }
}