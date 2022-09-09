package com.pms.pmsapp.sysadmin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.sysadmin.repository.UserRepository;
import com.pms.pmsapp.sysadmin.service.UserServiceImpl;
import com.pms.pmsapp.sysadmin.web.UserForm;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class TestUserServiceImpl extends TestWithSpringBoot {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Mock
	PasswordEncoder passwordEncoder;

	User user1 = null;
	User user2 = null;
	UserForm userForm = null;

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

	@Test
	@Order(6)
	public void testCreateUser_userExistError() {

		userForm = new UserForm();
		userForm.setId(4L);
		userForm.setUsername("testuser");
		userForm.setPassword("password1234");
		userForm.setConfirmPassword("password1234");
		userForm.setContactNo("91234567");
		userForm.setEmail("test@test.com");
		userForm.setSelectedRoles(new String[] { "ADMIN", "USER" });
		userForm.setDelInd("N");

		userServiceImpl = spy(userServiceImpl);

		doReturn(true).when(userServiceImpl).checkUserExist(Mockito.anyString());

		UserForm formResult = userServiceImpl.createUser(userForm, "user1");

		assertEquals("User already exist. Please create user with different name.", formResult.getErrMsg());
	}

	@Test
	@Order(7)
	public void testCreateUser_passwordMismatchError() {

		userForm = new UserForm();
		userForm.setId(4L);
		userForm.setUsername("testuser");
		userForm.setPassword("password5678");
		userForm.setConfirmPassword("password1234");
		userForm.setContactNo("91234567");
		userForm.setEmail("test@test.com");
		userForm.setSelectedRoles(new String[] { "ADMIN", "USER" });
		userForm.setDelInd("N");

		userServiceImpl = spy(userServiceImpl);

		doReturn(false).when(userServiceImpl).checkUserExist(Mockito.anyString());

		UserForm formResult = userServiceImpl.createUser(userForm, "user1");

		assertEquals("Passwords entered does not match.", formResult.getErrMsg());
	}

	@Test
	@Order(8)
	public void testCreateUser_createUserSuccess() {

		userForm = new UserForm();
		userForm.setId(4L);
		userForm.setUsername("testuser");
		userForm.setPassword("password1234");
		userForm.setConfirmPassword("password1234");
		userForm.setContactNo("91234567");
		userForm.setEmail("test@test.com");
		userForm.setSelectedRoles(new String[] { "ADMIN", "USER" });
		userForm.setDelInd("N");

		userServiceImpl = spy(userServiceImpl);

		when(passwordEncoder.encode(userForm.getPassword()))
				.thenReturn("$2a$10$W2jLx/24rOSkJSyV7CdHs.aHGsubPg6g7Er6oBGmTk.Ej7zpWtp5C");

		doReturn(false).when(userServiceImpl).checkUserExist(Mockito.anyString());

		doNothing().when(userServiceImpl).addUser(Mockito.any(User.class));
		doNothing().when(userServiceImpl).addUserRole(Mockito.anyString(), Mockito.anyString());

		UserForm formResult = userServiceImpl.createUser(userForm, "user1");

		verify(userServiceImpl, times(1)).addUser(Mockito.any(User.class));

		verify(userServiceImpl, times(2)).addUserRole(Mockito.anyString(), Mockito.anyString());

		assertEquals("User Created Successfully.", formResult.getSystemMsg());
	}

}
