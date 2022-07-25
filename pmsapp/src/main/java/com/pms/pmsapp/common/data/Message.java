package com.pms.pmsapp.common.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_MSG")
@SequenceGenerator(name = "MsgSeqGenerator", sequenceName = "SQ_PMS_MSG", allocationSize = 1)
public class Message {

	private Long msgId;
	private String type;
	private String subject;
	private String msg;
	private String username;
	private String delInd;
	private Date genDt;

	public Message() {
		super();
	}

	public Message(Long msgId, String type, String subject, String msg, String username, String delInd, Date genDt) {
		super();
		this.msgId = msgId;
		this.type = type;
		this.subject = subject;
		this.msg = msg;
		this.username = username;
		this.delInd = delInd;
		this.genDt = genDt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MsgSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	@Column(name = "TYPE", nullable = false, length = 50)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "SUBJECT", nullable = true, length = 100)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "MSG", nullable = true, length = 1000)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "USERNAME", nullable = true, length = 25)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "DEL_IND", nullable = true)
	public String getDelInd() {
		return delInd;
	}

	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}

	@Column(name = "GEN_DT", nullable = true)
	public Date getGenDt() {
		return genDt;
	}

	public void setGenDt(Date genDt) {
		this.genDt = genDt;
	}
}
