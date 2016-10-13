package com.packtpub.celebrities.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;

public class AddCelebrity {
	// @ApplicationState
	@SessionState
	private IDataSource dataSource;

	@Persist
	private Celebrity celebrity;

	Object onSubmitFromCelebrity() {
		//dataSource.addCelebrity(celebrity);
		dataSource.addCelebrity((Celebrity) celebrity.clone());
		return ShowAll.class;
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}
}
