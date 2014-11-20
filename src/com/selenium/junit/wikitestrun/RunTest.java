package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

import com.selenium.wikitest.webpage.homepage.automatedtests.*;

public class RunTest {
	public static void main(String[] args)
	{
		java.lang.Class<?>[] tests = {
				IsLanguageDisplayed.class
//				TestSearchFromHomePage.class
		};
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(tests);
	}
}
