package com.selenium.wikitest.wikipage.resultpage.common.automatedtests;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.resultpage.common.CommonPage;

public class PortalNavigation extends TestCase {

	private static CommonPage commonPage = new CommonPage();
	
	@BeforeClass
	public static void testSetup() {
		commonPage.openPage();
	}
	
	@Test
	public void goToMainPageUsingMainIcon() {

		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToMainPageUsingIcon();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewMainPageIconTooltip() {

		String expectedResult = "Visit the main page";
		String actualResult = commonPage.getMainPageIconTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToMainPageUsingLink() {

		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToMainPageUsingLink();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewMainPageLinkTooltip() {

		String expectedResult = "Visit the main page [Alt+Shift+z]";
		String actualResult = commonPage.getMainPageLinkTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToContents() {

		String expectedResult = "Portal:Contents - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToContents();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewContentsTooltip() {

		String expectedResult = "Guides to browsing Wikipedia";
		String actualResult = commonPage.getContentsTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToFeaturedContent() {

		String expectedResult = "Portal:Featured content - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToFeaturedContent();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewFeaturedContentTooltip() {

		String expectedResult = "Featured content – the best of Wikipedia";
		String actualResult = commonPage.getFeaturedContentTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToCurrentEvents() {

		String expectedResult = "Portal:Current events - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToCurrentEvents();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewCurrentEventsTooltip() {

		String expectedResult = "Find background information on current events";
		String actualResult = commonPage.getCurrentEventsTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToRandomArticle() {

		String failedResult = "Selenium - Wikipedia, the free encyclopedia";
		String expectedResult = "Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToRandomArticle();
		
		// Verify the page is not the original page
		assertFalse(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(failedResult));
		
		// Verify the page is a Wiki page
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));

	}
	
	@Test
	public void reviewRandomArticleTooltip() {

		String expectedResult = "Load a random article [Alt+Shift+x]";
		String actualResult = commonPage.getRandomArticleTooltip();
		assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToDonateToWikipedia() {

		String expectedResult = "Make your donation now - Donate";
		String actualResult = commonPage.goToDonateToWikipedia();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewDonateToWikipediaTooltip() {

		String expectedResult = "Support us";
		String actualResult = commonPage.getDonateToWikipediaTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToWikimediaShop() {

		String expectedResult = "Wikimedia Shop";
		String actualResult = commonPage.goToWikimediaShop();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewWikimediaShopTooltip() {

		String expectedResult = "Visit the Wikimedia Shop";
		String actualResult = commonPage.getWikimediaShopTooltip();
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
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
