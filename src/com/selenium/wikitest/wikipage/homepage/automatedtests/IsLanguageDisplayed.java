package com.selenium.wikitest.wikipage.homepage.automatedtests;

import com.selenium.wikitest.wikipage.homepage.HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IsLanguageDisplayed {

	private static HomePage homePage = new HomePage();
	
	@BeforeSuite
	public static void setup() {
		homePage.openPage();
	}
	
	@Test
	public void isEnglishDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.English));
	}
	
	@Test
	public void isSpanishDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Spanish));
	}
	
	@Test
	public void isJapanesDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Japanese));
	}
	
	@Test
	public void isRussianDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Russian));
	}
	
	@Test
	public void isFrenchDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.French));
	}
	
	@Test
	public void isGermanDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.German));
	}
	
	@Test
	public void isItalianDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Italian));
	}
	
	@Test
	public void isChineseDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Chinese));
	}
	
	@Test
	public void isPolishDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Polish));
	}
	
	@Test
	public void isPortugueseDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Portuguese));
	}

	@AfterSuite
	public static void teardown() {
		homePage.closeBrowser();
	}
	
}
