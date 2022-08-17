package com.pms.pmsapp.sysadmin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
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

	}

}
