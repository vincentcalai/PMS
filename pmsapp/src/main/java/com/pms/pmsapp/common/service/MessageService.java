package com.pms.pmsapp.common.service;

import java.util.List;

import com.pms.pmsapp.common.data.Message;

public interface MessageService {

	void genWatchlistNotiMsg();

	List<Message> retrieveMsg(String loginUser);

	int retrieveMsgCnt(String loginUser);

	void softDelReadMsg(String loginUser);

	void deleteAllMsg(String loginUser);
}
