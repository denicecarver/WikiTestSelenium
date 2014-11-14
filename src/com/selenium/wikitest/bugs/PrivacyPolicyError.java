package com.selenium.wikitest.bugs;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

public class PrivacyPolicyError {

	private static HomePage homePage = new HomePage();

	@Before
	public void testSetup() {
		homePage.openPage();
	}

	// Verifies title contains "Privacy Policy"
	// This assert fails.
	@Test
	public void testPrivacyPolicyLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.PrivacyPolicyXPath"));
		String expectedResult = HomePageText.getString("HomePage.PrivacyPolicyTitle");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
