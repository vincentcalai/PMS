package com.pms.pmsapp.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.common.repository.MessageRepository;
import com.pms.pmsapp.common.repository.dao.MessageDao;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void genWatchlistNotiMsg() {
		messageDao.genWatchlistNotiMsg();
	}

	@Override
	public List<Message> retrieveMsg(String loginUser) {
		return messageRepository.findByUsernameOrderByGenDtDesc(loginUser);
	}

	@Override
	public int retrieveMsgCnt(String loginUser) {
		String delInd = "N";
		return messageRepository.countByUsernameAndDelInd(loginUser, delInd);
	}

	@Override
	public void softDelReadMsg(String loginUser) {
		List<Message> messagesByUser = messageRepository.findByUsername(loginUser);
		messagesByUser.forEach(message -> message.setDelInd("N"));
		messageRepository.saveAll(messagesByUser);
	}

	@Override
	public void deleteAllMsg(String loginUser) {
		messageRepository.deleteByUsername(loginUser);
	}
}
