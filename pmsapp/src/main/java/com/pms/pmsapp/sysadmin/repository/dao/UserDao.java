package com.pms.pmsapp.sysadmin.repository.dao;

import java.util.List;

public interface UserDao {

	void addUserRole(String username, String newUserRole);

	void updateUserRole(Long id, String newUserRole);

	void deleteUser(long id) throws Exception;

	List<String> findUserRoles(String username);

	void clearUserRole(Long id);
}
