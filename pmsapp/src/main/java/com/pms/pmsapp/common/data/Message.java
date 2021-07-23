package com.pms.pmsapp.common.data;

import java.util.Date;

public class Message {
	private Long msgId;
	private String type;
	private String subject;
	private String msg;
	private String username;
	private String delInd;
	private Date genDt;
	
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDelInd() {
		return delInd;
	}
	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}
	public Date getGenDt() {
		return genDt;
	}
	public void setGenDt(Date genDt) {
		this.genDt = genDt;
	}
}
