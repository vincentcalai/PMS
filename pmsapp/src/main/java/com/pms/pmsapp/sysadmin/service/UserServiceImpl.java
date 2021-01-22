package com.pms.pmsapp.sysadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.sysadmin.dao.UserDao;
import com.pms.pmsapp.sysadmin.data.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllUsers(Pageable pageable) {
		return userDao.findAllUsers(pageable);
	}
	
	@Override
	public boolean checkUserExist(String username) {
		return userDao.checkUserExist(username);
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
	public void deleteUser(long id) {
		userDao.deleteUser(id);
	}

	@Override
	public List<String> findUserRoles(String username) {
		return userDao.findUserRoles(username);
	}
}
