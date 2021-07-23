package com.pms.pmsapp.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.dao.MessageDao;
import com.pms.pmsapp.common.data.Message;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public void genWatchlistNotiMsg() {
		messageDao.genWatchlistNotiMsg();
	}

	@Override
	public List<Message> retrieveMsg(String loginUser) {
		return messageDao.retrieveMsg(loginUser);
	}

	@Override
	public int retrieveMsgCnt(String loginUser) {
		return messageDao.retrieveMsgCnt(loginUser);
	}

	@Override
	public void softDelReadMsg(String loginUser) {
		messageDao.softDelReadMsg(loginUser);
	}
	
	@Override
	public void deleteAllMsg(String loginUser) {
		messageDao.deleteAllMsg(loginUser);
	}
}
