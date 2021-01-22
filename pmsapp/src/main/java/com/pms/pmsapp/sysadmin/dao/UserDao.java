package com.pms.pmsapp.sysadmin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import com.pms.pmsapp.sysadmin.data.User;



public interface UserDao {
	public Optional<User> findUser(String username);

	public List<User> findAllUsers(Pageable pageable);

	boolean checkUserExist(String username);

	public void addUser(User userForm);

	public void addUserRole(String username, String newUserRole);

	public long findAllUserCount();

	public void updateUser(User userForm);

	public void updateUserRole(Long id, String newUserRole);

	public void deleteUser(long id);
	
	public List<String> findUserRoles(String username);
}
