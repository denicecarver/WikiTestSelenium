package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

import com.selenium.wikitest.wikipage.homepage.automatedtests.*;

public class RunTest {
	public static void main(String[] args)
	{
		java.lang.Class<?>[] tests = {
				IsLanguageDisplayed.class
		};
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(tests);
	}
}
