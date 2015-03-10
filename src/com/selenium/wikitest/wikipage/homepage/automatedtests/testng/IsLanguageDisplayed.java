package com.selenium.wikitest.wikipage.homepage.automatedtests.testng;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;

public class IsLanguageDisplayed {

	private static HomePage homePage = new HomePage();
	
	@BeforeSuite
	public void setup() {
		homePage.openPage();
	}
	
	@Test
	public void isEnglishDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.English),
				CommonMethods.formatAssertMessage(HomePage.Language.English.toString(), HomePage.Language.English.toString()));
	}
	
	@Test
	public void isSpanishDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Spanish),
				CommonMethods.formatAssertMessage(HomePage.Language.Spanish.toString(), HomePage.Language.Spanish.toString()));
	}
	
	@Test
	public void isJapanesDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Japanese),
				CommonMethods.formatAssertMessage(HomePage.Language.Japanese.toString(), HomePage.Language.Japanese.toString()));
	}
	
	@Test
	public void isRussianDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Russian),
				CommonMethods.formatAssertMessage(HomePage.Language.Russian.toString(), HomePage.Language.Russian.toString()));
	}
	
	@Test
	public void isFrenchDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.French),
				CommonMethods.formatAssertMessage(HomePage.Language.French.toString(), HomePage.Language.French.toString()));
	}
	
	@Test
	public void isGermanDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.German),
				CommonMethods.formatAssertMessage(HomePage.Language.German.toString(), HomePage.Language.German.toString()));
	}
	
	@Test
	public void isItalianDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Italian),
				CommonMethods.formatAssertMessage(HomePage.Language.Italian.toString(), HomePage.Language.Italian.toString()));
	}
	
	@Test
	public void isChineseDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Chinese),
				CommonMethods.formatAssertMessage(HomePage.Language.Chinese.toString(), HomePage.Language.Chinese.toString()));
	}
	
	@Test
	public void isPolishDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Polish),
				CommonMethods.formatAssertMessage(HomePage.Language.Polish.toString(), HomePage.Language.Polish.toString()));
	}
	
	@Test
	public void isPortugueseDisplayed() {
		Assert.assertTrue(homePage.isLanguageFound(HomePage.Language.Portuguese),
				CommonMethods.formatAssertMessage(HomePage.Language.Portuguese.toString(), HomePage.Language.Portuguese.toString()));
	}

	@AfterSuite
	public void teardown() {
		homePage.closeBrowser();
	}
	
}
