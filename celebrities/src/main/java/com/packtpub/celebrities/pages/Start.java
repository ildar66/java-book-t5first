package com.packtpub.celebrities.pages;

//import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.Security;

/**
 * Start page of application celebrities.
 */
public class Start {
	@Inject
	@Path("context:assets/styles.css")
	private Asset styles;

	public Asset getStyles() {
		return styles;
	}

	private String userName;
	private String password;

	// @ApplicationState
	@SessionState
	private User user;

	Object onSubmitFromLoginForm() {
		Class<?> nextPage = null;
		User authenticatedUser = null;
		authenticatedUser = Security.authenticate(userName, password);
		if (authenticatedUser != null) {
			user = authenticatedUser;
			nextPage = ShowAll.class;
		} else {
			nextPage = Registration.class;
		}
		return nextPage;
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
}