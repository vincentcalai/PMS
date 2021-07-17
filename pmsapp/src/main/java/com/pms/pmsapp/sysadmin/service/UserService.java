package com.pms.pmsapp.sysadmin.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import com.pms.pmsapp.sysadmin.data.User;

public interface UserService {

	List<User> findAllUsers(Pageable pageable);
	
	boolean checkUserExist(String username);

	void addUser(User userForm);

	void addUserRole(String username, String newUserRole);

	long findAllUserCount();

	void updateUser(User userForm);

	void updateUserRole(Long id, String newUserRole);

	void deleteUser(long id);

	List<String> findUserRoles(String username);

	void clearUserRole(Long id);

}
