package com.packtpub.celebrities.data;

import java.util.List;

import com.packtpub.celebrities.model.Celebrity;

public interface IDataSource {
	public List<Celebrity> getAllCelebrities();

	public Celebrity getCelebrityById(long id);

	public void addCelebrity(Celebrity c);
}
