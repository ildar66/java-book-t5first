package com.packtpub.celebrities.pages;

import java.text.Format;
import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.SessionState;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;
import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.Formats;

public class ShowAll {
	//@ApplicationState
	@SessionState
    private User user;
    private boolean userExists;
    
    //@ApplicationState
    @SessionState
    private IDataSource dataSource;
    
    @InjectPage
    private Details detailsPage; 
    
    private Celebrity celebrity;
    
    String onActivate() {
        if (!userExists) return "Start";
        return null;
    }
    
 /*   @OnEvent(component="detailsLink")
    Object onShowDetails(long id) {
        Celebrity celebrity = 
				dataSource.getCelebrityById(id);
        detailsPage.setCelebrity(celebrity);
        return detailsPage;
    }*/
    
    public List<Celebrity> getAllCelebrities() {
        return dataSource.getAllCelebrities();
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
}
