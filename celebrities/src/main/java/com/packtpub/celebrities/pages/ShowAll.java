package com.packtpub.celebrities.pages;

import java.text.Format;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.grid.GridDataSource;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;
import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.CelebrityEncoder;
import com.packtpub.celebrities.util.CelebritySelectModel;
import com.packtpub.celebrities.util.CelebritySource;
import com.packtpub.celebrities.util.Formats;

//import org.apache.tapestry5.annotations.OnEvent;

public class ShowAll {
	// @ApplicationState
	@SessionState
	private User user;
	private boolean userExists;

	// @ApplicationState
	@SessionState
	private IDataSource dataSource;

	@InjectPage
	private Details detailsPage;

	private Celebrity celebrity;

	String onActivate() {
		if (!userExists)
			return "Start";
		return null;
	}

	/*
	 * @OnEvent(component="detailsLink") Object onShowDetails(long id) {
	 * Celebrity celebrity = dataSource.getCelebrityById(id);
	 * detailsPage.setCelebrity(celebrity); return detailsPage; }
	 */

	public List<Celebrity> getAllCelebrities() {
		System.out.println("Getting all celebrities...");
		return dataSource.getAllCelebrities();
	}

	public GridDataSource getCelebritySource() {
		return new CelebritySource(dataSource);
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}

	public Format getDateFormat() {
		return Formats.getDateFormat();
	}

	public SelectModel getCelebrityModel() {
		return new CelebritySelectModel(getAllCelebrities());
	}

	public ValueEncoder<Celebrity> getCelebrityEncoder() {
		return new CelebrityEncoder(dataSource);
	}

	@Persist
	private Celebrity selectedCelebrity;

	public Celebrity getSelectedCelebrity() {
		return selectedCelebrity;
	}

	public void setSelectedCelebrity(Celebrity selectedCelebrity) {
		this.selectedCelebrity = selectedCelebrity;
	}

	public String getSelectedCelebrityName() {
		if (selectedCelebrity == null)
			return "";
		return selectedCelebrity.getFirstName() + " "
				+ selectedCelebrity.getLastName();
	}

	@Persist
	private Date theDate;

	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}

	public Date getLowerLimit() {
		return new Date();
	}

}
