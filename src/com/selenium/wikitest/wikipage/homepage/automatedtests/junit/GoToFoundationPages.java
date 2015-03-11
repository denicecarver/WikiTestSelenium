package com.selenium.wikitest.wikipage.homepage.automatedtests.junit;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

public class GoToFoundationPages extends TestCase {

	private static HomePage homePage = new HomePage();
	
	@Before
	public void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWikiMediaFoundationLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.WikiMediaFoundationXPath"));
		String expectedResult = HomePageText.getString("HomePage.WikiMediaFoundationTitle");
		try {
			assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
					actualResult.contains(expectedResult));
		} catch (AssertionError ae) {
			ae.printStackTrace();
			homePage.getUniqueScreenshot(this.toString());
			throw(ae);
		}
	}
	
	@Test
	public void testTermsOfUseLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.TermsOfUseXPath"));
		String expectedResult = HomePageText.getString("HomePage.TermsOfUseTitle");
		try {
			assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
					actualResult.contains(expectedResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}
	}
	
	// This test fails.  Title should be "Privacy Policy" to match link and other titles
	// but is "Privacy policy"
	@Test
	public void testPrivacyPolicyLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.PrivacyPolicyXPath"));
		String expectedResult = HomePageText.getString("HomePage.PrivacyPolicyTitle");
		try {
			assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
					actualResult.contains(expectedResult));
		} catch (AssertionError ae) {
			homePage.getUniqueScreenshot(this.toString());
			ae.printStackTrace();
			throw(ae);
		}
	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
