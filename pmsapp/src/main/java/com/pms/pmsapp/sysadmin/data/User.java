package com.pms.pmsapp.sysadmin.data;

import java.util.Date;

public class User {

	private Long id;
	private String username;
	private String password;
	private String confirmPassword;
	private String roles;
	private String email;
	private String contactNo;
	private String createdBy;
	private Date createdDt;
	private String delInd;

	private String[] selectedRoles;

	public User() {
		super();
	}

	public User(Long id, String username, String password, String confirmPassword, String roles, String email,
			String contactNo, String createdBy, Date createdDt, String delInd, String[] selectedRoles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.roles = roles;
		this.email = email;
		this.contactNo = contactNo;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.delInd = delInd;
		this.selectedRoles = selectedRoles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getDelInd() {
		return delInd;
	}

	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}

	public String[] getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(String[] selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

}
