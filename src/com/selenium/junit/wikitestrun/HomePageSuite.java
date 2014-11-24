package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

import com.selenium.wikitest.wikipage.homepage.automatedtests.*;

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
		
		runner.run(tests);
	}

}
