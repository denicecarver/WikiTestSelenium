package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.selenium.wikitest.bugs.PrivacyPolicyError;
import com.selenium.wikitest.bugs.SearchError;
import com.selenium.wikitest.webpage.homepage.automatedtests.*;

@RunWith(Suite.class)
@SuiteClasses({ TestDataLanguageLinks.class,
				TestDataRedirectFromHomePage.class,
				TestDataSearchFromHomePage.class,
				TestLanguageDisplay.class,
				TestLanguageLinks.class,
				TestOtherProjectLinks.class,
				TestSearchFromHomePage.class })
public class HomePageSuite {
	public static void main(String[] args)
	{
		java.lang.Class<?>[] tests = {
				TestDataLanguageLinks.class,
				TestDataRedirectFromHomePage.class,
				TestDataSearchFromHomePage.class,
				TestLanguageDisplay.class,
				TestLanguageLinks.class,
				TestOtherProjectLinks.class,
				TestSearchFromHomePage.class
		};
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(tests);
	}

}
