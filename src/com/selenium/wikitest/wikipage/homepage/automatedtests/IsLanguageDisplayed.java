package com.selenium.wikitest.wikipage.homepage.automatedtests;

import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class IsLanguageDisplayed {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void setup() {
		homePage.openPage();
	}
	
	@Test
	public void isEnglishDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.English));
	}
	
	@Test
	public void isSpanishDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Spanish));
	}
	
	@Test
	public void isJapanesDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Japanese));
	}
	
	@Test
	public void isRussianDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Russian));
	}
	
	@Test
	public void isFrenchDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.French));
	}
	
	@Test
	public void isGermanDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.German));
	}
	
	@Test
	public void isItalianDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Italian));
	}
	
	@Test
	public void isChineseDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Chinese));
	}
	
	@Test
	public void isPolishDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Polish));
	}
	
	@Test
	public void isPortugueseDisplayed() {
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Portuguese));
	}

	@AfterClass
	public static void teardown() {
		homePage.closeBrowser();
	}
	
}
