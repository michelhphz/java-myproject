package com.mysystem.utils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "growl")
@ViewScoped
public class Growl {
	
	private String id;
	private String message;			
	
    public Growl() {
	}

	public Growl(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	// Methods
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(this.id, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Info Message", this.message);
    }

    public void showWarn() {
        addMessage(FacesMessage.SEVERITY_WARN, "Warn Message", this.message);
    }

    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", this.message);
    }

}