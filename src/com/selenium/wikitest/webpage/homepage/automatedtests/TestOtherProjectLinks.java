package com.selenium.wikitest.webpage.homepage.automatedtests;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

public class TestOtherProjectLinks {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWiktionaryLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WiktionaryProject");
		String expectedResult = (HomePageText.getString("HomePage.WiktionaryProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikidataLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikidataProject");
		String expectedResult = (HomePageText.getString("HomePage.WikidataProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikivoyageLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikivoyageProject");
		String expectedResult = (HomePageText.getString("HomePage.WikivoyageProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikinewsLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikinewsProject");
		String expectedResult = (HomePageText.getString("HomePage.WikinewsProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikispeciesLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikispeciesProject");
		String expectedResult = (HomePageText.getString("HomePage.WikispeciesProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testCommonsLink() {
		String actualResult = homePage.goToProjectLink("HomePage.CommonsProject");
		String expectedResult = (HomePageText.getString("HomePage.CommonsProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikiquoteLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikiquoteProject");
		String expectedResult = (HomePageText.getString("HomePage.WikiquoteProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikisourceLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikisourceProject");
		String expectedResult = (HomePageText.getString("HomePage.WikisourceProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void mediaWikiLink() {
		String actualResult = homePage.goToProjectLink("HomePage.MediaWikiProject");
		String expectedResult = (HomePageText.getString("HomePage.MediaWikiProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikibooksLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikibooksProject");
		String expectedResult = (HomePageText.getString("HomePage.WikibooksProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikiversityLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WikiversityProject");
		String expectedResult = (HomePageText.getString("HomePage.WikiversityProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testMetaWikiLink() {
		String actualResult = homePage.goToProjectLink("HomePage.MetaWikiProject");
		String expectedResult = (HomePageText.getString("HomePage.MetaWikiProject"));
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@After
	public void returnToWikipedia() {
		homePage.openHomePage();
	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}

}
