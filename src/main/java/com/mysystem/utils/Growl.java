package com.mysystem.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "growl")
@ViewScoped
public class Growl {
	
	private String message;			
	
    public Growl() {
	}

	public Growl(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	// Methods
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
	
    public void showGrowl(Severity type) {
        addMessage(type, "", this.message);
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