package com.pms.pmsapp.common.dao;

import java.util.List;

import com.pms.pmsapp.common.data.Message;



public interface MessageDao {

	public void genWatchlistNotiMsg();

	public List<Message> retrieveMsg(String loginUser);
	
	public int retrieveMsgCnt(String loginUser);

	public void softDelReadMsg(String loginUser);
	
	public void deleteAllMsg(String loginUser);

}
