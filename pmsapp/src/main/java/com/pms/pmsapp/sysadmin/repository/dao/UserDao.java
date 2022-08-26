package com.pms.pmsapp.sysadmin.repository.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.sysadmin.data.User;

public interface UserDao {
	Optional<User> findUser(String username);

	List<User> findAllUsers(Pageable pageable);

	boolean checkUserExist(String username);

	void addUser(User userForm);

	void addUserRole(String username, String newUserRole);

	long findAllUserCount();

	void updateUser(User userForm);

	void updateUserRole(Long id, String newUserRole);

	void deleteUser(long id) throws Exception;

	List<String> findUserRoles(String username);

	void clearUserRole(Long id);
}
