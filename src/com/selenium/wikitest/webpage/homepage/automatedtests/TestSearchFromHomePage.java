package com.selenium.wikitest.webpage.homepage.automatedtests;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;

import com.thoughtworks.selenium.SeleneseTestBase;
import com.selenium.wikitest.shared.CommonPagesText;
import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;

public class TestSearchFromHomePage {
	private static HomePage homePage = new HomePage();

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
	
//	Run these scripts before building table.
//	CREATE TABLE SearchStrings(
//	SearchID INTEGER PRIMARY KEY,
//	SearchItem TEXT);
//	CREATE TABLE RedirectStrings(
//	RedirectID INTEGER PRIMARY KEY,
//	RedirectItem TEXT);
//	TODO Move this method to a Utilities class
//	@Ignore @Test
//	public void buildSearchTables() {
//		homePage.buildSearchTable(HomePageText.getString("SearchStrings.TableName"),
//				HomePageText.getString("SearchStrings.Column1"),
//				Integer.parseInt(HomePageText.getString("SearchStrings.Count")));
//		homePage.buildSearchTable(HomePageText.getString("RedirectStrings.TableName"),
//				HomePageText.getString("RedirectStrings.Column1"),
//				Integer.parseInt(HomePageText.getString("RedirectStrings.Count")));
//	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
