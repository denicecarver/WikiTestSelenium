package com.selenium.wikitest.wikipage.homepage.automatedtests;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class GoToWikiInLanguage {

	private static HomePage homePage = new HomePage();
	
	@BeforeSuite
	public void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void goToEnglishWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageEnglishText");
		String expectedResult = HomePageText.getString("HomePage.EnglishWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToPolishWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePolishText");
		String expectedResult = HomePageText.getString("HomePage.PolishWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToFrenchWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageFrenchText");
		String expectedResult = HomePageText.getString("HomePage.FrenchWiki");
		Assert.assertTrue(actualResult.contains(expectedResult), CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToGermanWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageGermanText");
		String expectedResult = HomePageText.getString("HomePage.GermanWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToItalianWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageItalianText");
		String expectedResult = HomePageText.getString("HomePage.ItalianWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToJapaneseWiki() {
		String actualResult = homePage.getJapanesePageTitle();
		String expectedResult = HomePageText.getString("HomePage.JapaneseWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToChineseWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageChineseText");
		String expectedResult = HomePageText.getString("HomePage.ChineseWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToRussianWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageRussianText");
		String expectedResult = HomePageText.getString("HomePage.RussianWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToPortugueseWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePortugueseText");
		String expectedResult = HomePageText.getString("HomePage.PortugueseWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}
	
	@Test
	public void goToSpanishWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageSpanishText");
		String expectedResult = HomePageText.getString("HomePage.SpanishWiki");
		Assert.assertTrue(actualResult.contains(expectedResult),
				CommonMethods.formatAssertMessage(expectedResult, actualResult));
	}

	@AfterTest
	public void resetForNextTest() {
		homePage.openHomePage();
	}

	@AfterSuite
	public void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
