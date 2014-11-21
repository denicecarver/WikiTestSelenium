package com.selenium.wikitest.shared;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CommonPagesText {
	private static final String BUNDLE_NAME = "com.selenium.wikitest.shared.commontext"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private CommonPagesText() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
