package com.selenium.junit.wikitestrun;

import com.selenium.wikitest.bugs.PrivacyPolicyError;
import com.selenium.wikitest.regression.SearchError;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.DataDrivenGoToWikiInLanguage;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.DataDrivenSearchRedirectedTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.DataDrivenSearchTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.GoToFoundationPages;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.GoToOtherProjects;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.GoToWikiInLanguage;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.IsLanguageDisplayed;
import com.selenium.wikitest.wikipage.homepage.automatedtests.junit.GoToSearchTermItems;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.DataResultLanguages;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.InteractionNavigation;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.PortalNavigation;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.ToolsNavigation;

public class JUnitTestClasses {

	private static final java.lang.Class<?>[] errorTests = {
		PrivacyPolicyError.class
	};

	private static final java.lang.Class<?>[] regressionTests = {
		SearchError.class
	};

	private static final java.lang.Class<?>[] homePageJUnitTests = {
		DataDrivenGoToWikiInLanguage.class,
		DataDrivenSearchRedirectedTerms.class,
		DataDrivenSearchTerms.class,
		GoToFoundationPages.class,
		GoToOtherProjects.class,
		GoToWikiInLanguage.class,
		GoToSearchTermItems.class,
		IsLanguageDisplayed.class
	};

	private static final java.lang.Class<?>[] resultPageTests = {
		DataResultLanguages.class,
		InteractionNavigation.class,
		PortalNavigation.class,
		ToolsNavigation.class
	};
	
	public static java.lang.Class<?>[] getErrorTests() {
		return errorTests;
	}
	
	public static java.lang.Class<?>[] getHomePageJUnitTests() {
		return homePageJUnitTests;
	}
	
	public static java.lang.Class<?>[] getResultPageTests() {
		return resultPageTests;
	}
	
	public static java.lang.Class<?>[] getAllTests() {
		int allTestLength = regressionTests.length + errorTests.length + homePageJUnitTests.length + resultPageTests.length;
		java.lang.Class<?>[] allTests = new java.lang.Class<?>[allTestLength];
		int countRegressionTests = 0;
		int countErrorTests = 0;
		int countHomeTests = 0;
		int countResultTests = 0;
		int countAllTests = 0;
		
		for (; countErrorTests < errorTests.length; countErrorTests++) {
			allTests[countAllTests + countErrorTests] = errorTests[countErrorTests];
		}
		countAllTests += countErrorTests;
		
		for (; countRegressionTests < errorTests.length; countRegressionTests++) {
			allTests[countAllTests + countRegressionTests] = regressionTests[countRegressionTests];
		}
		countAllTests += countRegressionTests;

		for (; countHomeTests < homePageJUnitTests.length; countHomeTests++) {
			allTests[countAllTests + countHomeTests] = homePageJUnitTests[countHomeTests];
		}
		countAllTests += countHomeTests;
		
		for (; countResultTests < resultPageTests.length; countResultTests++) {
			allTests[countAllTests + countResultTests] = resultPageTests[countResultTests];
		}
		countAllTests += countResultTests;
		
		return allTests;
	}

}
