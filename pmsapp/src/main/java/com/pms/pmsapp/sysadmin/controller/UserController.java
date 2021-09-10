package com.pms.pmsapp.sysadmin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pmsapp.sysadmin.data.User;
import com.pms.pmsapp.sysadmin.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/sysadmin/userlist", method=RequestMethod.GET)
	public Page<User> findAllUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
		log.info("findAllUsers in Controller");
		Pageable pageable = PageRequest.of(page-1, size);
		
		List<User> users= userService.findAllUsers(pageable);
		long totalRec = userService.findAllUserCount();
		
		PageImpl<User> usersPage = new PageImpl((List<User>) users, pageable, totalRec);
		return usersPage;
	}
	
	@RequestMapping(value="/sysadmin/createuser", method=RequestMethod.POST)
	public User createUser(@RequestBody User userForm, Authentication authentication) {
		 log.info("createUser in Controller.. ");
		 
		 String username = userForm.getUsername();
		 String createdBy = authentication.getName();
		 
		 if(createdBy != null) {
			 userForm.setCreatedBy(createdBy);
		 }
		 
		 userForm.setRoles(String.join(", ", userForm.getSelectedRoles()));
		 
		 boolean userExist = userService.checkUserExist(userForm.getUsername());
		 if(userExist) {
			 //userForm.setPassword(null);
			 //userForm.setConfirmPassword(null);
			 userForm.setErrMsg("User already exist. Please create user with different name.");
		 } else if (!userForm.getConfirmPassword().equals(userForm.getPassword())){
			 //userForm.setPassword(null);
			 //userForm.setConfirmPassword(null);
			 userForm.setErrMsg("Passwords entered does not match.");
		 } else {
			//encode password
			 userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
			 
			 userService.addUser(userForm);
			 for( int i=0; i<userForm.getSelectedRoles().length; i++) {
				 String newUserRole = userForm.getSelectedRoles()[i];
				 userService.addUserRole(username, newUserRole);
			 }
			 userForm.setSystemMsg("User Created Successfully.");
		 }
		 return userForm;
	}
	
	@RequestMapping(value="/sysadmin/updateuser/{id}", method=RequestMethod.POST)
	public User updateuser(@PathVariable long id, @RequestBody User userForm, Authentication authentication) {
		 log.info("updateuser in Controller.. ");
			 
		 userForm.setId(id);
		 String createdBy = authentication.getName();
		 
		 if(createdBy != null) {
			 userForm.setCreatedBy(createdBy);
		 }
		 
		 userForm.setRoles(String.join(", ", userForm.getSelectedRoles()));
			 
		 userService.updateUser(userForm);
		 userService.clearUserRole(userForm.getId());
		 for( int i=0; i<userForm.getSelectedRoles().length; i++) {
			 String newUserRole = userForm.getSelectedRoles()[i];
			 userService.updateUserRole(userForm.getId(), newUserRole);
		 }
		 userForm.setSystemMsg("User updated Successfully.");
		 
		 return userForm;
	}
	
	
	@RequestMapping(value="/sysadmin/deleteuser/{id}", method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable long id) {
		User user = new User();
		log.info("deleteUser in Controller");
		userService.deleteUser(id);
		
		user.setSystemMsg("User deleted successfully.");
		
		return user;
	}
	
	@RequestMapping(value="/user/roles", method=RequestMethod.POST)
	public List<String> getLoginUserRoles(@RequestBody String username) {
		 log.info("getRoles in Controller.. ");
		 
		 List<String> roles = userService.findUserRoles(username);
		
		 return roles;
	}
	
}
