package com.packtpub.celebrities.pages;

//import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.Security;

/**
 * Start page of application celebrities.
 */
public class Start {
	
	private String userName;
	private String password;

	// @ApplicationState
	@SessionState
	private User user;

	@Component
	private Form loginForm;

	@Inject
	private Messages messages;

	Object onSuccess() {
		return ShowAll.class;
	}

	void onValidate() {
		if (userName != null && password != null) {
			User authenticatedUser = Security.authenticate(userName, password);
			if (authenticatedUser != null) {
				user = authenticatedUser;
			} else {
				loginForm.recordError(messages.get("authentication-failed"));
			}
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrRegisterLabel() {
		return messages.get("or-register");
	}

}