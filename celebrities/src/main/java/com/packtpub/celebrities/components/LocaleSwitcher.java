package com.packtpub.celebrities.components;

import java.util.Locale;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import com.packtpub.celebrities.services.SupportedLocales;
import com.packtpub.celebrities.util.LocaleEncoder;
import com.packtpub.celebrities.util.LocaleSelectModel;

public class LocaleSwitcher {

	@Inject
	private SupportedLocales supportedLocales;

	// @Parameter(defaultPrefix = "literal", required = true)
	// private String supportedLocales;

	@Inject
	private PersistentLocale persistentLocale;

	public Locale getSelectedLocale() {
		return persistentLocale.get();
	}

	public void setSelectedLocale(Locale selectedLocale) {
		persistentLocale.set(selectedLocale);
	}

	public SelectModel getLocaleModel() {
		// return new LocaleSelectModel(supportedLocales);
		return new LocaleSelectModel(supportedLocales.getSupportedLocales());
	}

	public ValueEncoder<Locale> getLocaleEncoder() {
		return new LocaleEncoder();
	}
}