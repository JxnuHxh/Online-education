package com.nettyim.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GroupChatModel {
    
    @JsonProperty("from_shell_id")
    private Long fromShellId;

    @JsonProperty("content")
    private String content;

    public Long getFromShellId() {
		return fromShellId;
	}

	public void setFromShellId(Long fromShellId) {
		this.fromShellId = fromShellId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ChatMessage{fromShellId:").append(this.fromShellId).append(", ");
        sb.append("content:").append(this.content).append("}");
        return sb.toString();
    }
}
