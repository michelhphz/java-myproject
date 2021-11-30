package com.mysystem.dto;

import java.io.Serializable;

import com.mysystem.entities.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String password;
	
	public UserDTO() {}

	public UserDTO(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		email = entity.getEmail();
		password = entity.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
