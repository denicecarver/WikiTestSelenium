package com.selenium.wikitest.webpage.homepage;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.selenium.wikitest.shared.CommonPagesText;

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
		
		// Assert expected matches actual
		SeleneseTestBase.assertEquals(seleniumExpected, seleniumActual);		
	}
	
	@Test
	public void testSearchRedirect() {

		// Get redirect text
		String expectedRedirectText = CommonPagesText.getString("AnyPage.RedirectText");
		
		// Go to redirected page
		homePage.searchFor(expectedRedirectText);
		
		// Get text from non-redirected page
		String actualRedirectText = homePage.searchForRedirect(expectedRedirectText);

		// Assert expected matches actual
		SeleneseTestBase.assertEquals(expectedRedirectText, actualRedirectText);		

	}
	
	// Data-driven test
	@Test
	public void testSearchRedirectList() {
		
		String[] mylist = homePage.searchStringList("AnyPage.CSVRedirectSearchFilename");
		int count = 0;
		for (String s : mylist) {
			
			// Go to redirected page
			homePage.searchFor(s);

			// Assert expected search result s, from list, matches actual result
			SeleneseTestBase.assertEquals(s, homePage.searchForRedirect(s));
			
			// increment counter
			count++;
			
			// Return to home page for next test
			homePage.openHomePage();
		}
		
		System.out.println("Number of search redirect data-driven tests:  " + count);

	}
	
	// Data-driven test
	@Test
	public void testSearchList() {
		
		String[] mylist = homePage.searchStringList("AnyPage.CSVSearchFilename");
		int count = 0;
		for (String s : mylist) {

			// Assert expected search result s, from list, matches actual result
			SeleneseTestBase.assertEquals(s, homePage.searchFor(s));
			
			// increment counter
			count++;
			
			// Return to home page for next test
			homePage.openHomePage();
		}
		
		System.out.println("Number of search data-driven tests:  " + count);

	}
	
	@Test
	public void testEmptySearch() throws Exception {

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.EmptyStringSearchTitle");
		
		// Run search and get result.
		String errorActual = homePage.searchFor(HomePageText.getString("HomePage.EmptyString"));

		// Assert expected == actual
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
	}

	
	@Test
	public void testFailSearch() throws Exception {

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.NotFoundTitle");

		// Run search and get result
		String errorActual = homePage.searchFor(HomePageText.getString("HomePage.OpenBraceSearch"));
		
		// Assert expected matches actual
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
		
	}
	
	@Test
	public void testSearchStringTooLong() throws Exception {

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.TooLongStringError");

		// Run search and get result
		String errorActual = homePage.searchFor(HomePageText.getString("ErrorPage.SearchTooLongString"));
		
		// Assert expected == actual (this assert fails)
		SeleneseTestBase.assertEquals(errorExpected, errorActual);

	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
