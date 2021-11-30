package com.mysystem.dto;

import java.io.Serializable;
import java.util.Date;

import com.mysystem.entities.People;

public class PeopleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String name;
	private Date birth;
	
	public PeopleDTO() {}

	public PeopleDTO(Long id, String email, String name, Date birth) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
	}
	
	public PeopleDTO(People entity) {
		id = entity.getId();
		email = entity.getEmail();
		name = entity.getName();
		birth = entity.getBirth();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}	
	
}
