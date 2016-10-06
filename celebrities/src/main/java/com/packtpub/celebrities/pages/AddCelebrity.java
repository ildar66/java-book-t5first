package com.packtpub.celebrities.pages;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;

public class AddCelebrity {
/*	@Inject
	@Path("context:assets/styles.css")
	private Asset styles;

	//@ApplicationState
	@SessionState
	private IDataSource dataSource;

	public Asset getStyles() {
		return styles;
	}*/

	@Persist
	private Celebrity celebrity;

/*	Object onSubmitFromCelebrity() {
		dataSource.addCelebrity(celebrity);
		return ShowAll.class;
	}*/

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}
}
