package com.pms.pmsapp.sysadmin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

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

	@Test
	void testFindAllUser() {
		User user1 = new User(1L, "user1", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S",
				"ADMIN, USER", "test@test.com", "91234567", "user1", new Date(), "N");
		User user2 = new User(2L, "user2", "$2a$10$9UJdg1Fo1t7wT9WT5NOqNeh2YGfEX1zFyom/Lcfc68svrdjFYjS3S",
				"ADMIN, USER", "test@test.com", "91234567", "user2", new Date(), "Y");
		userRepository.save(user1);
		userRepository.save(user2);
		List<User> userList = userRepository.findAllByDelInd("N");
		assertEquals(1, userList.size());

	}

}
