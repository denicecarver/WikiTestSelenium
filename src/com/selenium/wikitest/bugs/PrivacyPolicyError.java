package com.selenium.wikitest.bugs;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

public class PrivacyPolicyError extends TestCase {

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
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
