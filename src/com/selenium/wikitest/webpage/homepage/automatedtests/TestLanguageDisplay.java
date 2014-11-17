package com.selenium.wikitest.webpage.homepage.automatedtests;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class TestLanguageDisplay {

	private static HomePage homePage = new HomePage();
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testEnglishDisplay() {
		// Verify English is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.English));
	}
	
	@Test
	public void testSpanishDisplay() {
		// Verify Spanish is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Spanish));
	}
	
	@Test
	public void testJapanesDisplay() {
		// Verify Japanese is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Japanese));
	}
	
	@Test
	public void testRussianDisplay() {
		// Verify Russian is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Russian));
	}
	
	@Test
	public void testFrenchDisplay() {
		// Verify French is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.French));
	}
	
	@Test
	public void testGermanDisplay() {
		// Verify German is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.German));
	}
	
	@Test
	public void testItalianDisplay() {
		// Verify Italian is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Italian));
	}
	
	@Test
	public void testChineseDisplay() {
		// Verify Chinese is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Chinese));
	}
	
	@Test
	public void testPolishDisplay() {
		// Verify Polish is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Polish));
	}
	
	@Test
	public void testPortugueseDisplay() {
		// Verify Portuguese is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Portuguese));
	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}
	
}
