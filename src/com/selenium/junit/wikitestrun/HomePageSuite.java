package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.selenium.wikitest.bugs.PrivacyPolicyError;
import com.selenium.wikitest.bugs.SearchError;
import com.selenium.wikitest.webpage.homepage.automatedtests.*;

@RunWith(Suite.class)
@SuiteClasses({ DataGoToWikiInLanguage.class,
				DataSearchRedirectedTerms.class,
				DataSearchTerms.class,
				IsLanguageDisplayed.class,
				GoToWikiInLanguage.class,
				GoToOtherProjects.class,
				SearchForTermsTypes.class })
public class HomePageSuite {
	public static void main(String[] args)
	{
		java.lang.Class<?>[] tests = {
				DataGoToWikiInLanguage.class,
				DataSearchRedirectedTerms.class,
				DataSearchTerms.class,
				IsLanguageDisplayed.class,
				GoToWikiInLanguage.class,
				GoToOtherProjects.class,
				SearchForTermsTypes.class
		};
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(tests);
	}

}
