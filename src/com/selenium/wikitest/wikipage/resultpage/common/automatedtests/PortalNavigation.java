package com.selenium.wikitest.wikipage.resultpage.common.automatedtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenium.wikitest.shared.CommonMethods;
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
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewMainPageIconTooltip() {

		String expectedResult = "Visit the main page";
		String actualResult = commonPage.getMainPageIconTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToMainPageUsingLink() {

		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToMainPageUsingLink();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewMainPageLinkTooltip() {

		String expectedResult = "Visit the main page [Alt+Shift+z]";
		String actualResult = commonPage.getMainPageLinkTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToContents() {

		String expectedResult = "Portal:Contents - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToContents();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewContentsTooltip() {

		String expectedResult = "Guides to browsing Wikipedia";
		String actualResult = commonPage.getContentsTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToFeaturedContent() {

		String expectedResult = "Portal:Featured content - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToFeaturedContent();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewFeaturedContentTooltip() {

		String expectedResult = "Featured content – the best of Wikipedia";
		String actualResult = commonPage.getFeaturedContentTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToCurrentEvents() {

		String expectedResult = "Portal:Current events - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToCurrentEvents();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewCurrentEventsTooltip() {

		String expectedResult = "Find background information on current events";
		String actualResult = commonPage.getCurrentEventsTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToRandomArticle() {

		String failedResult = "Selenium - Wikipedia, the free encyclopedia";
		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToRandomArticle();
		
		// Verify the page is not the original page
		SeleneseTestBase.assertFalse(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(failedResult));
		
		// Verify the page is a Wiki page
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));

	}
	
	@Test
	public void reviewRandomArticleTooltip() {

		String expectedResult = "Load a random article [Alt+Shift+x]";
		String actualResult = commonPage.getRandomArticleTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToDonateToWikipedia() {

		String expectedResult = "Make your donation now - Donate";
		String actualResult = commonPage.goToDonateToWikipedia();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewDonateToWikipediaTooltip() {

		String expectedResult = "Support us";
		String actualResult = commonPage.getDonateToWikipediaTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToWikimediaShop() {

		String expectedResult = "Wikimedia Shop";
		String actualResult = commonPage.goToWikimediaShop();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewWikimediaShopTooltip() {

		String expectedResult = "Visit the Wikimedia Shop";
		String actualResult = commonPage.getWikimediaShopTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

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
