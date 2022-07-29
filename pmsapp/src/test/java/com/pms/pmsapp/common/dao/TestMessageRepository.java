package com.pms.pmsapp.common.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.common.data.Message;
import com.pms.pmsapp.common.repository.MessageRepository;
import com.pms.pmsapp.common.repository.dao.MessageDaoImpl;
import com.pms.pmsapp.fixture.MessageFixture;

@DataJpaTest
@ContextConfiguration(classes = { MessageDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
public class TestMessageRepository {

	private List<Message> msgList;

	@Autowired
	private MessageRepository messageRepository;

	@BeforeAll
	public void setup() throws Exception {

		msgList = MessageFixture.createTriggerMessageListFixture();

		messageRepository.saveAll(msgList);

	}

	@AfterAll
	public void teardown() throws Exception {
		messageRepository.deleteAll();
	}

	@Test
	public void testFindByUsernameOrderByGenDtDesc_shouldReturnCorrectListSize() {

		List<Message> userMessages1 = messageRepository.findByUsernameOrderByGenDtDesc("user1");

		assertEquals(userMessages1.size(), 3);

		List<Message> userMessages2 = messageRepository.findByUsernameOrderByGenDtDesc("user2");

		assertEquals(userMessages2.size(), 3);
	}

	@Test
	public void testFindByUsernameOrderByGenDtDesc_shouldReturnCorrectOrder() {

		List<Message> userMessages = messageRepository.findByUsernameOrderByGenDtDesc("user1");

		Message firstMessage = userMessages.get(0);
		Message lastMessage = userMessages.get(userMessages.size() - 1);

		System.out.println("firstMessage: " + firstMessage.getGenDt() + " id: " + firstMessage.getMsgId());
		System.out.println("lastMessage: " + lastMessage.getGenDt() + " id: " + lastMessage.getMsgId());

		assertEquals(3, firstMessage.getMsgId());
		assertEquals(1, lastMessage.getMsgId());
	}

	@Test
	public void testCountByUsernameAndDelInd() {
		int count = messageRepository.countByUsernameAndDelInd("user2", "N");

		assertEquals(2, count);

		int delCount = messageRepository.countByUsernameAndDelInd("user2", "Y");

		assertEquals(1, delCount);
	}

	@Test
	public void testFindByUsername() {
		List<Message> messages = messageRepository.findByUsername("user2");

		assertEquals(3, messages.size());
	}

	@Test
	public void testDeleteByUsername() {
		messageRepository.deleteByUsername("user2");
		List<Message> messages = messageRepository.findByUsername("user2");
		assertEquals(0, messages.size());
	}
}
