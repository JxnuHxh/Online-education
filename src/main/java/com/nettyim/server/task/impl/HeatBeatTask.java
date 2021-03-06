package com.nettyim.server.task.impl;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.nettyim.server.enums.EventEnum;
import com.nettyim.server.model.ProtocolModel;
import com.nettyim.server.task.ITask;

/**
 * 心跳包任务
 */
public class HeatBeatTask implements ITask {

    private static final Logger logger = LoggerFactory.getLogger(HeatBeatTask.class);

    @Override
    public void excute(ChannelHandlerContext ctx, ProtocolModel protocolModel) throws Exception {
        logger.info("task[heart-beat-message] msg:{}", protocolModel); 
        // 回写ACK
        ProtocolModel reqProtocolModel = new ProtocolModel();
        BeanUtils.copyProperties(protocolModel, reqProtocolModel);
        reqProtocolModel.setCommandId(EventEnum.HEART_BEAT_RESP.getValue());
        ctx.pipeline().writeAndFlush(reqProtocolModel);
    }
}