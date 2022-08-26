package com.pms.pmsapp.sysadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.sysadmin.repository.UserRepository;
import com.pms.pmsapp.sysadmin.repository.dao.UserDao;
import com.pms.pmsapp.sysadmin.web.UserForm;
import com.pms.pmsapp.util.constant.ConstantUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> findAllUsers(Pageable pageable) {
		return userRepository.findAllByDelInd(ConstantUtil.IND_NO);
		// return userDao.findAllUsers(pageable);
	}

	@Override
	public boolean checkUserExist(String username) {
		return (userRepository.countByUsername(username) > 0);
		// return userDao.checkUserExist(username);
	}

	@Override
	public void addUser(User userForm) {
		userDao.addUser(userForm);
	}

	@Override
	public void addUserRole(String username, String newUserRole) {
		userDao.addUserRole(username, newUserRole);
	}

	@Override
	public long findAllUserCount() {
		return userDao.findAllUserCount();
	}

	@Override
	public void updateUser(User userForm) {
		userDao.updateUser(userForm);
	}

	@Override
	public void updateUserRole(Long id, String newUserRole) {
		userDao.updateUserRole(id, newUserRole);
	}

	@Override
	public void deleteUser(long id) throws Exception {
		userDao.deleteUser(id);
	}

	@Override
	public List<String> findUserRoles(String username) {
		return userDao.findUserRoles(username);
	}

	@Override
	public void clearUserRole(Long id) {
		userDao.clearUserRole(id);
	}

	@Override
	public UserForm createUser(UserForm userForm, String createdBy) {

		String username = userForm.getUsername();

		if (createdBy != null) {
			userForm.setCreatedBy(createdBy);
		}

		userForm.setRoles(String.join(", ", userForm.getSelectedRoles()));

		boolean userExist = checkUserExist(username);
		if (userExist) {
			// userForm.setPassword(null);
			// userForm.setConfirmPassword(null);
			userForm.setErrMsg("User already exist. Please create user with different name.");
		} else if (!userForm.getConfirmPassword().equals(userForm.getPassword())) {
			// userForm.setPassword(null);
			// userForm.setConfirmPassword(null);
			userForm.setErrMsg("Passwords entered does not match.");
		} else {
			// encode password
			userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));

			User user = new User(userForm.getId(), userForm.getUsername(), userForm.getPassword(), userForm.getRoles(),
					userForm.getEmail(), userForm.getContactNo(), userForm.getCreatedBy(), userForm.getCreatedDt(),
					userForm.getDelInd());

			addUser(user);

			for (int i = 0; i < userForm.getSelectedRoles().length; i++) {
				String newUserRole = userForm.getSelectedRoles()[i];
				addUserRole(username, newUserRole);
			}
			userForm.setSystemMsg("User Created Successfully.");
		}

		return userForm;
	}

	@Override
	public UserForm updateUser(UserForm userForm, String createdBy) {
		if (createdBy != null) {
			userForm.setCreatedBy(createdBy);
		}

		userForm.setRoles(String.join(", ", userForm.getSelectedRoles()));

		User user = new User(userForm.getId(), userForm.getUsername(), userForm.getPassword(), userForm.getRoles(),
				userForm.getEmail(), userForm.getContactNo(), userForm.getCreatedBy(), userForm.getCreatedDt(),
				userForm.getDelInd());

		updateUser(user);

		clearUserRole(userForm.getId());

		for (int i = 0; i < userForm.getSelectedRoles().length; i++) {
			String newUserRole = userForm.getSelectedRoles()[i];
			updateUserRole(userForm.getId(), newUserRole);
		}

		userForm.setSystemMsg("User updated Successfully.");
		return userForm;
	}
}
