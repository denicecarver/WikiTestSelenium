package com.selenium.wikitest.webpage.homepage;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.SeleneseTestBase;

public class TestSearchFromHomePage {
	private static HomePage homePage = new HomePage(new FirefoxDriver());

	@BeforeClass
	public void setupClass() {
		System.out.println("Class Setup");
	}
	@Before
	public void setupTest() {
		System.out.println("Test Setup");
		homePage.openPage();
	}
	
	@Test
	public void testSuccessfulSearch() throws Exception {
		System.out.println("TestSearchFromHomePage.testSuccessfulSearch");
		
		// Get text to search
		String seleniumExpected = HomePageText.getString("SeleniumPage.SeleniumTitle");

		// Run search from home page and get result
		String seleniumActual = homePage.searchFor(seleniumExpected);
		
		// Assert expected == actual
		SeleneseTestBase.assertEquals(seleniumExpected, seleniumActual);		
	}
	
	@Test
	public void testSearchList() {
		System.out.println("TestSearchFromHomePage.testSearchList()");
		
		String[] mylist = homePage.stringList();
		for (String s : mylist) {
			System.out.println(s);
			String actual = homePage.searchFor(s);
			homePage.openHomePage();
			SeleneseTestBase.assertEquals(s, actual);
		}
		System.out.println("The number of items in the list is: " + mylist.length);
	}
	
	@Test
	public void testEmptySearch() throws Exception {
		System.out.println("TestSearchFromHomePage.testEmptySearch()");
		
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
		System.out.println("TestSearchFromHomePage.testFailSearch()");

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.NotFoundTitle");

		// Set search text
		String searchText = HomePageText.getString("HomePage.OpenBraceSearch");
		
		// Run search and get result
		String errorActual = homePage.searchFor(searchText);
		
		// Assert expected == actual
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
		
	}
	
	@Test
	public void testSearchStringTooLong() throws Exception {
		System.out.println("TestSearchFromHomePage.testSearchStringTooLong()");

		// Set expected outcome
		String errorExpected = HomePageText.getString("ErrorPage.TooLongStringError");

		// Set search text
		String searchText = HomePageText.getString("ErrorPage.SearchTooLongString");

		// Run search and get result
		String errorActual = homePage.searchFor(searchText);
		
		// Assert expected == actual (this assert fails)
		SeleneseTestBase.assertEquals(errorExpected, errorActual);
	}
	
	@After
	public static void testTearDown() throws Exception {
		System.out.println("Test TearDown");
	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		System.out.println("Class TearDown");

		homePage.closeBrowser();
	}

}
