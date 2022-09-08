package com.pms.pmsapp.sysadmin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.sysadmin.repository.UserRepository;
import com.pms.pmsapp.sysadmin.service.UserServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class TestUserServiceImpl extends TestWithSpringBoot {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;

	User user1 = null;
	User user2 = null;

	@BeforeAll
	public void setup() throws Exception {
		user1 = new User(1L, "user1", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S", "ADMIN, USER",
				"test@test.com", "91234567", "user1", new Date(), "N");
		user2 = new User(2L, "user2", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S", "ADMIN, USER",
				"test@test.com", "91234567", "user2", new Date(), "Y");
		userRepository.save(user1);
		userRepository.save(user2);
	}

	@AfterAll
	public void teardown() throws Exception {
		userRepository.deleteAll();
	}

	@Test
	@Order(1)
	public void testCheckUserExist_shouldExist() {
		boolean isUserExist = userServiceImpl.checkUserExist("user2");
		assertTrue(isUserExist);
	}

	@Test
	@Order(2)
	public void testCheckUserExist_shouldNotExist() {
		boolean isUserExist = userServiceImpl.checkUserExist("user3");
		assertFalse(isUserExist);
	}

	@Test
	@Order(3)
	public void testAddUser() {
		User user3 = new User(3L, "user3", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S",
				"ADMIN, USER", "test@test.com", "91234567", "user3", new Date(), "N");
		userServiceImpl.addUser(user3);
		assertEquals(userRepository.count(), 3);
	}

	@Test
	@Order(4)
	public void testFindAllUserCount() {
		long count = userServiceImpl.findAllUserCount();
		assertEquals(count, 2);
	}

	@Test
	@Order(5)
	public void testUpdateUser() {
		User user = userRepository.findById(3L).get();
		user.setDelInd("Y");
		userServiceImpl.updateUser(user);
		long count = userServiceImpl.findAllUserCount();
		assertEquals(count, 1);
	}

}
