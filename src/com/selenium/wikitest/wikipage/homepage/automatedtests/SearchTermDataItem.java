package com.selenium.wikitest.wikipage.homepage.automatedtests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.WikiPageText;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

public class SearchTermDataItem {
	private static HomePage homePage = new HomePage();

	@BeforeMethod
	public void setupTest() {
		homePage.openPage();
	}
	
	@Test
	public void searchForExistingTerm() throws Exception {

		// Get text to search
		String expectedResult = HomePageText.getString("SeleniumPage.SeleniumTitle");

		// Run search from home page and get result
		String actualResult = homePage.searchFor(expectedResult);
		
		// Assert expected matches actual
		try {
			Assert.assertTrue(actualResult.contains(expectedResult),
					CommonMethods.formatAssertMessage(expectedResult, actualResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}		
	}
	
	@Test
	public void searchForRedirectTerm() {

		// Get redirect text
		String expectedResult = WikiPageText.getString("AnyPage.RedirectText");
		
		// Go to redirected page
		homePage.searchFor(expectedResult);
		
		// Get text from non-redirected page
		String actualResult = homePage.searchForRedirect(expectedResult);

		// Assert expected matches actual
		try {
			Assert.assertTrue(actualResult.contains(expectedResult),
					CommonMethods.formatAssertMessage(expectedResult, actualResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}		

	}
		
	@Test
	public void searchForBlankTerm() throws Exception {

		// Set expected outcome
		String expectedResult = HomePageText.getString("ErrorPage.EmptyStringSearchTitle");
		
		// Run search and get result.
		String actualResult = homePage.searchFor(HomePageText.getString("HomePage.EmptyString"));

		// Assert expected == actual
		try {
			Assert.assertTrue(actualResult.contains(expectedResult),
					CommonMethods.formatAssertMessage(expectedResult, actualResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}
	}
	
	@Test
	public void searchForNonexistentTerm() throws Exception {

		// Set expected outcome
		String expectedResult = HomePageText.getString("ErrorPage.NotFoundTitle");

		// Run search and get result
		String actualResult = homePage.searchFor(HomePageText.getString("HomePage.OpenBraceSearch"));
		
		// Assert expected matches actual
		try {
			Assert.assertTrue(actualResult.contains(expectedResult),
					CommonMethods.formatAssertMessage(expectedResult, actualResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}
		
	}
	
	@Test
	public void searchForTooLongTerm() throws Exception {

		// Set expected outcome
		String expectedResult = HomePageText.getString("ErrorPage.SearchErrored");

		// Run search and get result
		String actualResult = homePage.searchFor(HomePageText.getString("ErrorPage.SearchTooLongString"));
		
		// Assert expected == actual (this assert fails)
		try {
			Assert.assertTrue(actualResult.contains(expectedResult),
					CommonMethods.formatAssertMessage(expectedResult, actualResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}

	}
	
	@AfterSuite
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
