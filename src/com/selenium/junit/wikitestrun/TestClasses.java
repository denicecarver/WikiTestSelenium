package com.selenium.junit.wikitestrun;

import java.util.Collection;

import com.selenium.wikitest.bugs.PrivacyPolicyError;
import com.selenium.wikitest.bugs.SearchError;
import com.selenium.wikitest.wikipage.homepage.automatedtests.DataGoToWikiInLanguage;
import com.selenium.wikitest.wikipage.homepage.automatedtests.DataSearchRedirectedTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.DataSearchTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.GoToOtherProjects;
import com.selenium.wikitest.wikipage.homepage.automatedtests.GoToWikiInLanguage;
import com.selenium.wikitest.wikipage.homepage.automatedtests.IsLanguageDisplayed;
import com.selenium.wikitest.wikipage.homepage.automatedtests.SearchForTermsTypes;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.InteractionNavigation;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.PortalNavigation;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.ToolsNavigation;

public class TestClasses {

	private static final java.lang.Class<?>[] errorTests = {
		PrivacyPolicyError.class,
		SearchError.class
	};

	private static final java.lang.Class<?>[] homePageTests = {
		DataGoToWikiInLanguage.class,
		DataSearchRedirectedTerms.class,
		DataSearchTerms.class,
		IsLanguageDisplayed.class,
		GoToWikiInLanguage.class,
		GoToOtherProjects.class,
		SearchForTermsTypes.class
	};

	private static final java.lang.Class<?>[] resultPageTests = {
		InteractionNavigation.class,
		PortalNavigation.class,
		ToolsNavigation.class
	};
	
	public static java.lang.Class<?>[] getErrorTests() {
		return errorTests;
	}
	
	public static java.lang.Class<?>[] getHomePageTests() {
		return homePageTests;
	}
	
	public static java.lang.Class<?>[] getResultPageTests() {
		return resultPageTests;
	}
	
	public static java.lang.Class<?>[] getAllTests() {
		int allTestLength = errorTests.length + homePageTests.length + resultPageTests.length;
		java.lang.Class<?>[] allTests = new java.lang.Class<?>[allTestLength];
		int countErrorTests = 0;
		int countHomeTests = 0;
		int countResultTests = 0;
		int countAllTests = 0;
		
		for (; countErrorTests < errorTests.length; countErrorTests++) {
			allTests[countErrorTests] = errorTests[countErrorTests];
		}
		countAllTests += countErrorTests;

		for (; countHomeTests < homePageTests.length; countHomeTests++) {
			allTests[countAllTests + countHomeTests] = homePageTests[countHomeTests];
		}
		countAllTests += countHomeTests;
		
		for (; countResultTests < resultPageTests.length; countResultTests++) {
			allTests[countAllTests + countResultTests] = resultPageTests[countResultTests];
		}
		countAllTests += countResultTests;
		
		return allTests;
	}

}
