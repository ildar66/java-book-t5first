package com.packtpub.celebrities.util;

import org.apache.tapestry5.ValueEncoder;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;

public class CelebrityEncoder implements ValueEncoder<Celebrity> {

	private IDataSource source;

	public CelebrityEncoder(IDataSource source) {
		this.source = source;
	}

	public String toClient(Celebrity obj) {
		return "" + obj.getId();
	}

	public Celebrity toValue(String str) {
		return source.getCelebrityById(Integer.parseInt(str));
	}
}