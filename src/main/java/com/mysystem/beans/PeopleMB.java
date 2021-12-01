package com.mysystem.beans;



import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysystem.dto.PeopleDTO;
import com.mysystem.dto.UserDTO;
import com.mysystem.services.PeopleService;
import com.mysystem.services.UserService;
import com.mysystem.utils.Growl;
import com.mysystem.utils.GrowlType;

@Named(value = "peopleMB")
@ViewScoped
public class PeopleMB {
	
	private String email;
	private String name;
	private Date birth;
	private String password;		
	
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private UserService userService;
	
	public void insertPeople() throws IOException {
		
		if(email == "") {
			Growl growl = new Growl();
			GrowlType type = GrowlType.Error;
			growl.setMessage("Email required!");
			growl.showGrowl(type.getType());
			return;
		}
		
		if(password == "") {
			Growl growl = new Growl();
			GrowlType type = GrowlType.Error;
			growl.setMessage("Password required!");
			growl.showGrowl(type.getType());
			return;
		}		
		
		PeopleDTO people = new PeopleDTO(null, email, name, birth);
		UserDTO user = new UserDTO(null, email, password);
		boolean peopleResponse = peopleService.insert(people) != null;
		boolean userResponse = userService.insert(user) != null;
		if(peopleResponse && userResponse) {
			this.clear();
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.sys");;
		}
	}	
	
	public void clear() {
		this.setEmail(null);
		this.setName(null);
		this.setBirth(null);
		this.setPassword(null);
	}

}
