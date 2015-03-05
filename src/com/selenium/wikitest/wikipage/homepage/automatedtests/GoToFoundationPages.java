package com.selenium.wikitest.wikipage.homepage.automatedtests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

public class GoToFoundationPages {

	private static HomePage homePage = new HomePage();
	
	@BeforeMethod
	public void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWikiMediaFoundationLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.WikiMediaFoundationXPath"));
		String expectedResult = HomePageText.getString("HomePage.WikiMediaFoundationTitle");
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testTermsOfUseLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.TermsOfUseXPath"));
		String expectedResult = HomePageText.getString("HomePage.TermsOfUseTitle");
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	// This test fails.  Title should be "Privacy Policy" to match link and other titles
	// but is "Privacy policy"
	@Test
	public void testPrivacyPolicyLink() {
		String actualResult = homePage.goToListLinkByXPath(HomePageText.getString("HomePage.PrivacyPolicyXPath"));
		String expectedResult = HomePageText.getString("HomePage.PrivacyPolicyTitle");
		Assert.assertTrue(actualResult.contains(expectedResult));
	}

	@AfterSuite
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
