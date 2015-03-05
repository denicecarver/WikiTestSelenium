package com.selenium.wikitest.wikipage.homepage.automatedtests;

import junit.framework.TestCase;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class IsLanguageDisplayed extends TestCase {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void setup() {
		homePage.openPage();
	}
	
	@Test
	public void isEnglishDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.English));
	}
	
	@Test
	public void isSpanishDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Spanish));
	}
	
	@Test
	public void isJapanesDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Japanese));
	}
	
	@Test
	public void isRussianDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Russian));
	}
	
	@Test
	public void isFrenchDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.French));
	}
	
	@Test
	public void isGermanDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.German));
	}
	
	@Test
	public void isItalianDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Italian));
	}
	
	@Test
	public void isChineseDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Chinese));
	}
	
	@Test
	public void isPolishDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Polish));
	}
	
	@Test
	public void isPortugueseDisplayed() {
		assertTrue(homePage.isLanguageFound(HomePage.Language.Portuguese));
	}

	@AfterClass
	public static void teardown() {
		homePage.closeBrowser();
	}
	
}
