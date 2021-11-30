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
		
		System.out.println(email);
		
		if(email == "") {
			Growl growl = new Growl("email", email);
			growl.showError();
			return;
		}
		
		PeopleDTO people = new PeopleDTO(null, email, name, birth);
		UserDTO user = new UserDTO(null, email, password);
		boolean peopleResponse = peopleService.insert(people) != null;
		boolean userResponse = userService.insert(user) != null;
		if(peopleResponse && userResponse) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://google.com");
		}
	}	

}
