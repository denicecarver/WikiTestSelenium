package com.selenium.wikitest.webpage.homepage;

import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOtherProjectLinks {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWiktionaryLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WiktionaryProject");
		String expectedResult = (HomePageText.getString("HomePage.WiktionaryProject")).toLowerCase();
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikidataLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikidataProject");
		String expectedResult = HomePageText.getString("HomePage.WikidataProject");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikivoyageLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikivoyageProject");
		String expectedResult = (HomePageText.getString("HomePage.WikivoyageProject")).toLowerCase();
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	//@After
	public void returnToWikipedia() {
		homePage.goToHomeLink();
	}

	//sc
	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
