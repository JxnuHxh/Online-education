package com.nettyim.server.common.constrants;

import io.netty.util.AttributeKey;

import com.nettyim.server.entity.AuthModel;


public class AttributeKeyConstrants {

    // shell_id
    public static final AttributeKey<AuthModel> KEY_SHELL_ID = AttributeKey.valueOf("shell_id");
}
