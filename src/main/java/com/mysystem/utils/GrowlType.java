package com.mysystem.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

public enum GrowlType {
	Info(FacesMessage.SEVERITY_INFO), 
	Warn(FacesMessage.SEVERITY_WARN),
	Error(FacesMessage.SEVERITY_ERROR);
	
	private Severity type;
	
	GrowlType(Severity severityInfo){
		this.type = severityInfo;
	}
	
	public Severity getType() {
		return type;
	}
}
