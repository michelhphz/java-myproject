package com.mysystem.beans;

import java.io.IOException;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysystem.services.UserService;

@Named(value = "userMB")
@ViewScoped
public class UserMB {
	
	private String email;
	private String password;
	
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

	@Autowired
	private UserService userService;
		
	public void validateUser() throws IOException {
		boolean response = userService.findByEmail(email, password);
		if(response == true) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://google.com");
		}
		else {
			
		}		
	}	
	
	public void signIn() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("newUser.sys");
	}

}
