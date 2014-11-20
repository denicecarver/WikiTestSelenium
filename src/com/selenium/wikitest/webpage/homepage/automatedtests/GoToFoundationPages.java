package com.selenium.wikitest.webpage.homepage.automatedtests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
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
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testTermsOfUseLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.TermsOfUseXPath"));
		String expectedResult = HomePageText.getString("HomePage.TermsOfUseTitle");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	// This test fails.  Title should be "Privacy Policy" to match link and other titles
	// but is "Privacy policy"
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
