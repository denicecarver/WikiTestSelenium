package com.selenium.wikitest.webpage.homepage.automatedTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.wikitest.shared.CommonPagesText;
import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
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
		SeleneseTestBase.assertTrue(seleniumActual.contains(seleniumExpected));		
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
		SeleneseTestBase.assertTrue(actualRedirectText.contains(expectedRedirectText));		

	}
	
	// Data-driven test
	@Test
	public void testSearchRedirectList() {
		
		String[] mylist = homePage.searchStringList("HomePage.CSVRedirectSearchFilename");
		int count = 0;
		for (String s : mylist) {
			
			// Go to redirected page
			homePage.searchFor(s);

			// Assert expected search result s, from list, matches actual result
			SeleneseTestBase.assertTrue(homePage.searchForRedirect(s).contains(s));
			
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
		
		String[] mylist = homePage.searchStringList("HomePage.CSVSearchFilename");
		int count = 0;
		for (String s : mylist) {

			// Assert expected search result s, from list, matches actual result
			SeleneseTestBase.assertTrue(homePage.searchFor(s).contains(s));
			
			// increment counter
			count++;
			
			// Return to home page for next test
			homePage.openHomePage();
		}
		
		System.out.println("Number of search data-driven tests:  " + count);

	}
	
	/*
	@Test
	public void testLanguageLinkList() {
		String[] mylist = homePage.searchStringList("HomePage.CSVSearchFilename");
		//int count = 0;
		for (String s : mylist) {

			// Assert expected search result s, from list, matches actual result
			SeleneseTestBase.assertTrue(homePage.searchFor(s).contains(s));
			
			// increment counter
			count++;
			
			// Return to home page for next test
			homePage.openHomePage();
		}
		
	}
	*/
	
	@Test
	public void testEmptySearch() throws Exception {

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.EmptyStringSearchTitle");
		
		// Run search and get result.
		String errorActual = homePage.searchFor(HomePageText.getString("HomePage.EmptyString"));

		// Assert expected == actual
		SeleneseTestBase.assertTrue(errorActual.contains(errorExpected));
	}

	
	@Test
	public void testFailSearch() throws Exception {

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.NotFoundTitle");

		// Run search and get result
		String errorActual = homePage.searchFor(HomePageText.getString("HomePage.OpenBraceSearch"));
		
		// Assert expected matches actual
		SeleneseTestBase.assertTrue(errorActual.contains(errorExpected));
		
	}
	
	@Test
	public void testSearchStringTooLong() throws Exception {

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.TooLongStringError");

		// Run search and get result
		String errorActual = homePage.searchFor(HomePageText.getString("ErrorPage.SearchTooLongString"));
		
		// Assert expected == actual (this assert fails)
		SeleneseTestBase.assertTrue(errorActual.contains(errorExpected));

	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
