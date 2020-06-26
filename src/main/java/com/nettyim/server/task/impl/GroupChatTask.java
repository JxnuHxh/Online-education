package com.nettyim.server.task.impl;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.nettyim.server.common.constrants.ClientSession;
import com.nettyim.server.enums.EventEnum;
import com.nettyim.server.model.ProtocolModel;
import com.nettyim.server.task.ITask;

/**
 * 群聊消息任务
 */
public class GroupChatTask implements ITask {

    private static final Logger logger = LoggerFactory.getLogger(GroupChatTask.class);

    @Override
    public void excute(ChannelHandlerContext ctx, ProtocolModel protocolModel) throws Exception {
        logger.info("task[group-chat-message] msg:{}", protocolModel);
        
        
        // 回写ACK
        ProtocolModel reqProtocolModel = new ProtocolModel();
        BeanUtils.copyProperties(protocolModel, reqProtocolModel);
        reqProtocolModel.setCommandId(EventEnum.GROUP_CHAT_RESP.getValue());
        ctx.pipeline().writeAndFlush(reqProtocolModel);
        
        // 发送消息
        for (String key : ClientSession.sessionMap.keySet()) {
        	ChannelHandlerContext subCtx = ClientSession.sessionMap.get(key);
        	subCtx.pipeline().writeAndFlush(protocolModel);
        }
    }
}