package com.selenium.wikitest.webpage.homepage;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.thoughtworks.selenium.SeleneseTestBase;

public class TestSearchFromHomePage {
	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
	@Before
	public void setupTest() {
		homePage.openPage();
	}
	
	@Test
	public void testSuccessfulSearch() throws Exception {
		// Get text to search
		String seleniumExpected = HomePageText.getString("SeleniumPage.SeleniumTitle");

		// Run search from home page and get result
		String seleniumActual = homePage.searchFor(seleniumExpected);
		
		// Assert expected == actual
		SeleneseTestBase.assertEquals(seleniumExpected, seleniumActual);		
	}
	
	@Test
	public void testEmptySearch() throws Exception {
		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.EmptyStringSearchTitle");
		
		// Run search and get result.
		// Note: homePage.searchFor has a unique ID for the
		// go button and must be called for searches from homePage
		String errorActual = homePage.searchFor(HomePageText.getString("HomePage.EmptyString"));

		// Assert expected == actual
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
	}

	
	@Test
	public void testFailSearch() throws Exception {
		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.NotFoundTitle");

		// Set search text
		String searchText = HomePageText.getString("HomePage.OpenBraceSearch");
		
		// Run search and get result
		String errorActual = homePage.searchFor(searchText);
		
		// Assert expected == actual
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
		
		// Verify a meaningless error is not displayed (this assert fails)
		// Make a separate bug test
		String searchFail = homePage.getTextAtXPath("ErrorPage.ErrorXPath");
		SeleneseTestBase.assertFalse(searchFail.contains(HomePageText.getString("ErrorPage.SearchErrored")));
	}
	
	@Test
	public void testSearchStringTooLong() throws Exception {
		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.TooLongStringError");

		// Set search text
		String searchText = HomePageText.getString("ErrorPage.SearchTooLongString");

		// Run search and get result
		String errorActual = homePage.searchFor(searchText);
		
		// Assert expected == actual (this assert fails)
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeWindow();
	}

}
