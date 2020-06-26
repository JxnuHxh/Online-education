package com.nettyim.server.task;

import io.netty.channel.ChannelHandlerContext;

import com.nettyim.server.model.ProtocolModel;


public interface ITask {

    /**
     * 执行处理任务	  
     * @param ctx
     * @param protocolModel
     * @throws Exception
     */
    public void excute(ChannelHandlerContext ctx, ProtocolModel protocolModel) throws Exception;
}
