package com.packtpub.celebrities.pages;

//import org.apache.tapestry.annotations.ApplicationState;
import java.util.Locale;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

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

	@Component
	private Form loginForm;

	@Inject
	private Messages messages;
	
	@Inject
	private PersistentLocale persistentLocale;
	@Inject
	private Locale currentLocale;	
	@Persist
	private String localeLabel;
	
	public String getLocaleLabel() {
		if (localeLabel == null) {
			if (currentLocale.equals(Locale.GERMAN)) {
				localeLabel = new Locale("en").getDisplayName(Locale.ENGLISH);
			} else {
				localeLabel = new Locale("de").getDisplayName(Locale.GERMAN);
			}
		}
		return localeLabel;
	}

	@OnEvent(component = "switchlocale")
	void changeLocale() {
		localeLabel = currentLocale.getDisplayName(currentLocale);
		if (currentLocale.equals(Locale.GERMAN)) {
			persistentLocale.set(Locale.ENGLISH);
		} else {
			persistentLocale.set(Locale.GERMAN);
		}
	}

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