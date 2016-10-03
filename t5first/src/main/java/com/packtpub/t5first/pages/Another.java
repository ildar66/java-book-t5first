package com.packtpub.t5first.pages;

//import org.apache.tapestry.annotations.ApplicationState;

import org.apache.tapestry5.ioc.services.ApplicationDefaults;

import com.packtpub.t5first.util.User;


public class Another {
	
	@ApplicationDefaults
	private User myUser;
	
	// @Persist
	private String passedMessage;

	public User getMyUser() {
		return myUser;
	}
	
	public String getPassedMessage() {
		return passedMessage;
	}

	public void setPassedMessage(String passedMessage) {
		this.passedMessage = passedMessage;
	}
	
	void onActivate(String message) {
		System.out.println("Another page is activated! The message is: " + message);
		this.passedMessage = message;
	}
	
	String onPassivate() {
		System.out.println("Another page is passivated...");
		return passedMessage;
	}
}
