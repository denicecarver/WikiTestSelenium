package com.selenium.wikitest.wikipage.homepage.automatedtests;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

public class GoToOtherProjects {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWiktionaryLink() {
		String expectedResult = (HomePageText.getString("HomePage.WiktionaryProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WiktionaryProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikidataLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikidataProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikidataProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikivoyageLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikivoyageProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikivoyageProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikinewsLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikinewsProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikinewsProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikispeciesLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikispeciesProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikispeciesProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testCommonsLink() {
		String expectedResult = (HomePageText.getString("HomePage.CommonsProject"));
		String actualResult = homePage.goToProjectLink("HomePage.CommonsProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikiquoteLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikiquoteProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikiquoteProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikisourceLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikisourceProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikisourceProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void mediaWikiLink() {
		String expectedResult = (HomePageText.getString("HomePage.MediaWikiProject"));
		String actualResult = homePage.goToProjectLink("HomePage.MediaWikiProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikibooksLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikibooksProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikibooksProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikiversityLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikiversityProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikiversityProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void testMetaWikiLink() {
		String expectedResult = (HomePageText.getString("HomePage.MetaWikiProject"));
		String actualResult = homePage.goToProjectLink("HomePage.MetaWikiProject");
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
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
