package com.selenium.wikitest.regression;

import junit.framework.TestCase;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;

public class SearchError extends TestCase {
	
	private static HomePage homePage = new HomePage();
	
	@Before
	public void setupTest() {
		homePage.openPage();
	}
	
	@Test
	public void testFailSearch() throws Exception {

		// Set search text
		String expectedResult = HomePageText.getString("HomePage.OpenBraceSearch");
		
		// Run search and get result
		homePage.searchFor(expectedResult);
		
		// Verify the bracket character is found
		String actualResult = homePage.getPageTitle();
		try {
			assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
					actualResult.contains(expectedResult));
		} catch (AssertionError ae) {
			homePage.getScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}
	}
	
	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
