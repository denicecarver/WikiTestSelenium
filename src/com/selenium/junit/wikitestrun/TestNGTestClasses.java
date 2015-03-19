package com.selenium.junit.wikitestrun;

import com.selenium.wikitest.bugs.PrivacyPolicyError;
import com.selenium.wikitest.regression.SearchError;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.DataDrivenGoToWikiInLanguage;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.DataDrivenSearchRedirectedTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.DataDrivenSearchTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.DataSearchTerms;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.GoToFoundationPages;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.GoToOtherProjects;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.GoToSearchTermItems;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.GoToWikiInLanguage;
import com.selenium.wikitest.wikipage.homepage.automatedtests.testng.IsLanguageDisplayed;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.DataResultLanguages;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.InteractionNavigation;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.PortalNavigation;
import com.selenium.wikitest.wikipage.resultpage.common.automatedtests.ToolsNavigation;

public class TestNGTestClasses {

	private static final java.lang.Class<?>[] errorTests = {
		PrivacyPolicyError.class
	};

	private static final java.lang.Class<?>[] regressionTests = {
		SearchError.class
	};

	private static final java.lang.Class<?>[] homePageTestNGTests = {
		DataDrivenGoToWikiInLanguage.class,
		DataDrivenSearchRedirectedTerms.class,
		DataDrivenSearchTerms.class,
		DataSearchTerms.class,
		GoToFoundationPages.class,
		GoToOtherProjects.class,
		GoToSearchTermItems.class,
		IsLanguageDisplayed.class,
		GoToWikiInLanguage.class
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
	
	public static java.lang.Class<?>[] getHomePageTestNGTests() {
		return homePageTestNGTests;
	}
	
	public static java.lang.Class<?>[] getResultPageTests() {
		return resultPageTests;
	}
	
	public static java.lang.Class<?>[] getAllTests() {
		int allTestLength = regressionTests.length + errorTests.length + homePageTestNGTests.length + resultPageTests.length;
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

		for (; countHomeTests < homePageTestNGTests.length; countHomeTests++) {
			allTests[countAllTests + countHomeTests] = homePageTestNGTests[countHomeTests];
		}
		countAllTests += countHomeTests;
		
		for (; countResultTests < resultPageTests.length; countResultTests++) {
			allTests[countAllTests + countResultTests] = resultPageTests[countResultTests];
		}
		countAllTests += countResultTests;
		
		return allTests;
	}

}
