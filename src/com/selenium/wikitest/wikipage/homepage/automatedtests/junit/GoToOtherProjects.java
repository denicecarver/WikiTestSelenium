package com.selenium.wikitest.wikipage.homepage.automatedtests.junit;

import junit.framework.TestCase;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

public class GoToOtherProjects extends TestCase {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWiktionaryLink() {
		String expectedResult = (HomePageText.getString("HomePage.WiktionaryProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WiktionaryProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikidataLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikidataProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikidataProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikivoyageLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikivoyageProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikivoyageProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikinewsLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikinewsProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikinewsProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikispeciesLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikispeciesProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikispeciesProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testCommonsLink() {
		String expectedResult = (HomePageText.getString("HomePage.CommonsProject"));
		String actualResult = homePage.goToProjectLink("HomePage.CommonsProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikiquoteLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikiquoteProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikiquoteProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikisourceLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikisourceProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikisourceProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void mediaWikiLink() {
		String expectedResult = (HomePageText.getString("HomePage.MediaWikiProject"));
		String actualResult = homePage.goToProjectLink("HomePage.MediaWikiProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikibooksLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikibooksProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikibooksProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikiversityLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikiversityProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikiversityProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testMetaWikiLink() {
		String expectedResult = (HomePageText.getString("HomePage.MetaWikiProject"));
		String actualResult = homePage.goToProjectLink("HomePage.MetaWikiProject");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
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
