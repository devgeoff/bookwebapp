package com.booksellingapp.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "user_roles", 
	uniqueConstraints = @UniqueConstraint(
		columnNames = { "role", "username" }))
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userRoleId;
	private String role;
	private String username;
	
	
	
	public UserRole() {
		super();
	}

	public UserRole(String role, String username) {
		super();
		this.role = role;
		this.username = username;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_role_id", 
		unique = true, nullable = false)
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
