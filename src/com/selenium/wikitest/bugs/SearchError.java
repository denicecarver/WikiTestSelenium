package com.selenium.wikitest.bugs;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;

import com.thoughtworks.selenium.SeleneseTestBase;

public class SearchError {
	
	private static HomePage homePage = new HomePage();
	
	@Before
	public void setupTest() {
		homePage.openPage();
	}
	
	@Test
	public void testFailSearch() throws Exception {

		// Set search text
		String searchText = HomePageText.getString("HomePage.OpenBraceSearch");
		
		// Run search and get result
		homePage.searchFor(searchText);
		
		// Verify a meaningless error is not displayed (this assert fails)
		String searchFail = homePage.getTextAtXPath("ErrorPage.ErrorXPath");
		String expectedResult = HomePageText.getString("ErrorPage.SearchErrored");
		SeleneseTestBase.assertFalse(
				CommonMethods.formatAssertMessage(expectedResult, searchFail),
				searchFail.contains(expectedResult));
	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
