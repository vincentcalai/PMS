package com.pms.pmsapp.common.service;

import java.util.List;

import com.pms.pmsapp.common.data.Message;

public interface MessageService {

	public void genWatchlistNotiMsg();
	
	public List<Message> retrieveMsg(String loginUser);
	
	public int retrieveMsgCnt(String loginUser);

	public void softDelReadMsg(String loginUser);
	
	public void deleteAllMsg(String loginUser);
}
