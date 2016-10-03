package com.packtpub.t5first.pages;

import java.util.Date;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;


import com.packtpub.t5first.util.User;
//import org.apache.tapestry.annotations.ApplicationState;
//import org.apache.tapestry.annotations.InjectPage;

/**
 * Start page of application t5first.
 */
public class Start {

	@InjectPage
	private Another another;

	@ApplicationDefaults
	private User user;
	
	private boolean userExists; 
	public boolean getUserExists() {
		return userExists;
	}

	private int someValue = 12345;

	private String message = "initial value";

	public User getUser() {
		return user;
	}

	/*
	 * @OnEvent(value="submit", component="userInputForm") Object onFormSubmit() {
	 * System.out.println("Handling form submission!");
	 * another.setPassedMessage(message); return another; }
	 */

	Object onSubmitFromUserInputForm() {
		System.out.println("Handling form submission!");

		String[] words = message.split(" ");

		if (words.length > 0) {
			user.setFirstName(words[0]);
			if (words.length > 1) {
				user.setLastName(words[1]);
			}
		}

		another.setPassedMessage(message);
		return another;
	}

	public int getSomeValue() {
		return someValue;
	}

	public void setSomeValue(int value) {
		this.someValue = value;
	}

	public Date getCurrentTime() {
		return new Date();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("Setting the message: " + message);
		this.message = message;
	}
}