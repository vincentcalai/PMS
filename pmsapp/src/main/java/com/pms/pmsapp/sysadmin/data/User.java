package com.pms.pmsapp.sysadmin.data;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PMS_USR")
@SequenceGenerator(name = "UserSeqGenerator", sequenceName = "SQ_PMS_USR", allocationSize = 1)
public class User {

	private Long id;
	private String username;
	private String password;
	private String roles;
	private String email;
	private String contactNo;
	private String createdBy;
	private Date createdDt;
	private String delInd;

	public User() {
		super();
	}

	public User(Long id, String username, String password, String roles, String email, String contactNo,
			String createdBy, Date createdDt, String delInd) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.email = email;
		this.contactNo = contactNo;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.delInd = delInd;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PWD", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USR_NAM", nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ROLES", nullable = false, length = 100)
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Column(name = "EMAIL", nullable = true, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CONTACT_NO", nullable = true, length = 30)
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "CREATED_BY", nullable = true, length = 20)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DT", nullable = true)
	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	@Column(name = "DEL_IND", nullable = true, length = 1)
	public String getDelInd() {
		return delInd;
	}

	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contactNo, other.contactNo) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createdDt, other.createdDt) && Objects.equals(delInd, other.delInd)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(username, other.username);
	}

}
