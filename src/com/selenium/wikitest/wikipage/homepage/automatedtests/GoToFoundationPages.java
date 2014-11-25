package com.selenium.wikitest.wikipage.homepage.automatedtests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

public class GoToFoundationPages {

	private static HomePage homePage = new HomePage();
	
	@Before
	public void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWikiMediaFoundationLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.WikiMediaFoundationXPath"));
		String expectedResult = HomePageText.getString("HomePage.WikiMediaFoundationTitle");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testTermsOfUseLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.TermsOfUseXPath"));
		String expectedResult = HomePageText.getString("HomePage.TermsOfUseTitle");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	// This test fails.  Title should be "Privacy Policy" to match link and other titles
	// but is "Privacy policy"
	@Test
	public void testPrivacyPolicyLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.PrivacyPolicyXPath"));
		String expectedResult = HomePageText.getString("HomePage.PrivacyPolicyTitle");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
