package com.selenium.wikitest.webpage.homepage;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class HomePageText {
	private static final String BUNDLE_NAME = "com.selenium.wikitest.webpage.homepage.homepagetext"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private HomePageText() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			System.out.println("Property key, value not found");
			return "";
		}
	}
}
