package com.packtpub.celebrities.util;

import java.util.Locale;

import org.apache.tapestry5.ValueEncoder;

public class LocaleEncoder implements ValueEncoder<Locale> {

	public String toClient(Locale loc) {
		return loc.getLanguage();
	}

	public Locale toValue(String str) {
		return new Locale(str);
	}
}