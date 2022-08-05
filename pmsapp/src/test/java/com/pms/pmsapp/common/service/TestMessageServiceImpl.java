package com.pms.pmsapp.common.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.common.repository.MessageRepository;
import com.pms.pmsapp.fixture.MessageFixture;

@TestInstance(Lifecycle.PER_CLASS)
public class TestMessageServiceImpl extends TestWithSpringBoot {

	@Autowired
	private MessageServiceImpl messageServiceImpl;

	@Autowired
	private MessageRepository messageRepository;

	private List<Message> messageList;

	@BeforeAll
	public void setup() throws Exception {

		messageList = MessageFixture.createTriggerMessageListFixture();

		messageRepository.saveAll(messageList);

	}

	@AfterAll
	public void teardown() throws Exception {
		messageRepository.deleteAll(messageList);
	}

	@Test
	public void testGenWatchlistNotiMsg() {
		messageServiceImpl.genWatchlistNotiMsg();
	}

	@Test
	public void testRetrieveMsg() {
		List<Message> userMessages1 = messageServiceImpl.retrieveMsg("user1");

		assertEquals(3, userMessages1.size());
	}

	@Test
	public void testRetrieveMsgCnt() {
		int count = messageServiceImpl.retrieveMsgCnt("user1");

		assertEquals(3, count);
	}

	@Test
	public void testSoftDelReadMsg() {
		String loginUser = "user2";
		messageServiceImpl.softDelReadMsg(loginUser);
		List<Message> messages = messageRepository.findByUsername("user2");
		assertEquals(3, messages.size());
		messages.forEach(message -> assertEquals("Y", message.getDelInd()));
	}

	@Test
	@Transactional
	public void testDeleteByUsername() {
		messageServiceImpl.deleteAllMsg("user2");
		List<Message> messages = messageRepository.findByUsername("user2");
		assertEquals(0, messages.size());
	}

}
