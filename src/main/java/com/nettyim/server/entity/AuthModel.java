package com.nettyim.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 认证消息模型
 */
public class AuthModel {

    @JsonProperty("shell_id")
    private long shellId;
    
    @JsonProperty("token")
    private String token;

    public long getShellId() {
		return shellId;
	}

	public void setShellId(long shellId) {
		this.shellId = shellId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("AuthToken{shellId:").append(this.shellId).append(", ");
        sb.append("token:").append(this.token).append("}");
        return sb.toString();
    }
}
