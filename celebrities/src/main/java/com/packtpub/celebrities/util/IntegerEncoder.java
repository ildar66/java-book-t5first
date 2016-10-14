package com.packtpub.celebrities.util;

import org.apache.tapestry5.ValueEncoder;

public class IntegerEncoder implements ValueEncoder<Integer> {

	public String toClient(Integer i) {
		return i.toString();
	}

	public Integer toValue(String s) {
		return new Integer(s);
	}
}