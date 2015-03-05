package com.selenium.wikitest.wikipage.homepage.automatedtests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

public class GoToOtherProjects {

	private static HomePage homePage = new HomePage();
	
	@BeforeSuite
	public void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testWiktionaryLink() {
		String expectedResult = (HomePageText.getString("HomePage.WiktionaryProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WiktionaryProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikidataLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikidataProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikidataProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikivoyageLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikivoyageProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikivoyageProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikinewsLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikinewsProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikinewsProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikispeciesLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikispeciesProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikispeciesProject");
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testCommonsLink() {
		String expectedResult = (HomePageText.getString("HomePage.CommonsProject"));
		String actualResult = homePage.goToProjectLink("HomePage.CommonsProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikiquoteLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikiquoteProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikiquoteProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikisourceLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikisourceProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikisourceProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void mediaWikiLink() {
		String expectedResult = (HomePageText.getString("HomePage.MediaWikiProject"));
		String actualResult = homePage.goToProjectLink("HomePage.MediaWikiProject");
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testWikibooksLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikibooksProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikibooksProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testWikiversityLink() {
		String expectedResult = (HomePageText.getString("HomePage.WikiversityProject"));
		String actualResult = homePage.goToProjectLink("HomePage.WikiversityProject");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void testMetaWikiLink() {
		String expectedResult = (HomePageText.getString("HomePage.MetaWikiProject"));
		String actualResult = homePage.goToProjectLink("HomePage.MetaWikiProject");
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	@AfterMethod
	public void returnToWikipedia() {
		homePage.openHomePage();
	}

	@AfterSuite
	public void testTeardown() {
		homePage.closeBrowser();
	}

}
