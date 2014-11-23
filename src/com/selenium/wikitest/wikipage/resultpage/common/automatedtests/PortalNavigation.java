package com.selenium.wikitest.wikipage.resultpage.common.automatedtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenium.wikitest.wikipage.resultpage.ResultPage;
import com.selenium.wikitest.wikipage.resultpage.common.CommonPage;
import com.thoughtworks.selenium.SeleneseTestBase;

public class PortalNavigation {

	private static CommonPage commonPage = new CommonPage();
	
	@BeforeClass
	public static void testSetup() {
		commonPage.openPage();
	}
	
	@Test
	public void goToMainPageUsingMainIcon() {

		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToMainPageUsingIcon();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToMainPageUsingLink() {

		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToMainPageUsingLink();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToContents() {

		String expectedResult = "Portal:Contents - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToContents();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToFeaturedContent() {

		String expectedResult = "Portal:Featured content - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToFeaturedContent();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToCurrentEvents() {

		String expectedResult = "Portal:Current events - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToCurrentEvents();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToRandomArticle() {

		String failedResult = "Selenium - Wikipedia, the free encyclopedia";
		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToRandomArticle();
		
		// Verify the page is not the original page
		SeleneseTestBase.assertFalse(actualResult.equals(failedResult));
		
		// Verify the page is a Wiki page
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));

	}
	
	@Test
	public void goToDonateToWikipedia() {

		String expectedResult = "Make your donation now - Donate";
		String actualResult = commonPage.goToDonateToWikipedia();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToWikimediaShop() {

		String expectedResult = "Wikimedia Shop";
		String actualResult = commonPage.goToWikimediaShop();
		SeleneseTestBase.assertTrue(actualResult.equals(expectedResult));

	}
		
	@After
	public void returnToWikipedia() {
		commonPage.openPage();
	}

	@AfterClass
	public static void testTeardown() {
		commonPage.closeBrowser();
	}

}
