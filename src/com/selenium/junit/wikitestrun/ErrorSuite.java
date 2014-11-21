package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

import com.selenium.wikitest.bugs.*;

public class ErrorSuite {
	public static void main(String[] args)
	{
		java.lang.Class<?>[] tests = {
				PrivacyPolicyError.class,
				SearchError.class
		};
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(tests);
	}
}
