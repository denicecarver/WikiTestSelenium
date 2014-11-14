package com.selenium.wikitest.webpage.homepage.automatedtests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

public class TestWikiMediaFoundationLinks {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
//	@Test
//	public void testWikiMediaFoundationLink() {
//		String actualResult = homePage.goToFoundationPage();
//		String expectedResult = "Wikimedia Foundation";//HomePageText.getString("HomePage.EnglishWiki");
//		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
//	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
