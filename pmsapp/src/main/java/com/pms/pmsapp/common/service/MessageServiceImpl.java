package com.pms.pmsapp.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.dao.MessageDao;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public void genOtherNotiMsg() {
		messageDao.genOtherNotiMsg();
	}
}
