package com.pms.pmsapp.sysadmin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.sysadmin.repository.UserRepository;
import com.pms.pmsapp.sysadmin.repository.dao.UserDaoImpl;

@DataJpaTest
@ContextConfiguration(classes = { UserDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
class TestUserRepository {

	@Autowired
	private UserRepository userRepository;

	User user1 = null;
	User user2 = null;

	@BeforeAll
	private void setup() {
		user1 = new User(1L, "user1", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S", "ADMIN, USER",
				"test@test.com", "91234567", "user1", new Date(), "N");
		user2 = new User(2L, "user2", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S", "ADMIN, USER",
				"test@test.com", "91234567", "user2", new Date(), "Y");
		userRepository.save(user1);
		userRepository.save(user2);
	}

	@AfterAll
	private void tearDown() {
		userRepository.deleteAll();
	}

	@Test
	void testFindAllUser() {
		List<User> userList = userRepository.findAllByDelInd("N");
		assertEquals(1, userList.size());
	}

	@Test
	void testFindCountOfUser_shouldReturnOne() {
		int userCnt = userRepository.countByUsername("user1");
		assertEquals(1, userCnt);
	}

	@Test
	void testFindByUserNameAndDelIndNo_shouldFindOneCount() {
		Optional<User> user = userRepository.findByUsernameAndDelIndOrderByIdAsc("user1", "N");
		assertTrue(user1.equals(user.get()));
	}

	@Test
	void testFindByUserNameAndDelIndYes_shouldFindZeroCount() {
		Optional<User> user = userRepository.findByUsernameAndDelIndOrderByIdAsc("user1", "Y");
		assertEquals(Optional.empty(), user);
	}

}
