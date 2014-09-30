package com.selenium.wikitest.webpage.homepage.automatedTests;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLanguageLinks {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testEnglishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageEnglishText");
		String expectedResult = HomePageText.getString("HomePage.EnglishWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testPolishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePolishText");
		String expectedResult = HomePageText.getString("HomePage.PolishWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testFrenchLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageFrenchText");
		String expectedResult = HomePageText.getString("HomePage.FrenchWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testGermanLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageGermanText");
		String expectedResult = HomePageText.getString("HomePage.GermanWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testItalianLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageItalianText");
		String expectedResult = HomePageText.getString("HomePage.ItalianWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testJapaneseLink() {
		String actualResult = homePage.getJapanesePageTitle();
		String expectedResult = HomePageText.getString("HomePage.JapaneseWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testChineseLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageChineseText");
		String expectedResult = HomePageText.getString("HomePage.ChineseWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testRussianLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageRussianText");
		String expectedResult = HomePageText.getString("HomePage.RussianWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testPortugueseLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePortugueseText");
		String expectedResult = HomePageText.getString("HomePage.PortugueseWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test
	public void testSpanishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageSpanishText");
		String expectedResult = HomePageText.getString("HomePage.SpanishWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	// Data-driven test
	@Test
	public void testLanguageLinkList() {
		// Retrieve the link names
		// Retrieve the page titles
		// Loop through the links
		// Go to link
		// Compare actual home page with expected home page
		// Return to home page

		String[] linkList = homePage.searchStringList("HomePage.CSVLanguageLink");
		String[] expectedList = homePage.searchStringList("HomePage.CSVLanguageTitleStrings");
		int count = 0;
		for (String s : linkList) {

			String actualResult = homePage.goToListLink(s);
			String expectedResult = expectedList[count];
			SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
			// Assert expected search result s, from list, matches actual result
			//SeleneseTestBase.assertTrue(homePage.searchFor(s).contains(s));
			
			// increment counter
			count++;
			
			// Return to home page for next test
			homePage.openHomePage();
		}
		System.out.println(count + " Tests Completed");
	}

	@After
	public void returnToWikipedia() {
		homePage.goToHomePage();
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}