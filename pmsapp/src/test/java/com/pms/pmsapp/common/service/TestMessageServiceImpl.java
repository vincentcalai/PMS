package com.pms.pmsapp.common.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.common.repository.MessageRepository;
import com.pms.pmsapp.common.repository.dao.MessageDaoImpl;
import com.pms.pmsapp.fixture.MessageFixture;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { MessageServiceImpl.class, MessageDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TestMessageServiceImpl {

	@Autowired
	MessageServiceImpl messageServiceImpl;

	@Autowired
	MessageRepository messageRepository;

	@Mock
	Message message;

	List<Message> messageList;

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
	public void testDeleteByUsername() {
		messageServiceImpl.deleteAllMsg("user2");
		List<Message> messages = messageRepository.findByUsername("user2");
		assertEquals(0, messages.size());
	}

}
