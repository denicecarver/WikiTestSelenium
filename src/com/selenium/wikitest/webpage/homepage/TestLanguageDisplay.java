package com.selenium.wikitest.webpage.homepage;

import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLanguageDisplay {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testEnglish() {
		// Verify English is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.English));
	}
	
	@Test
	public void testSpanish() {
		// Verify Spanish is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Spanish));
	}
	
	@Test
	public void testJapanese() {
		// Verify Japanese is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Japanese));
	}
	
	@Test
	public void testRussian() {
		// Verify Russian is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Russian));
	}
	
	@Test
	public void testFrench() {
		// Verify French is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.French));
	}
	
	@Test
	public void testGerman() {
		// Verify German is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.German));
	}
	
	@Test
	public void testItalian() {
		// Verify Italian is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Italian));
	}
	
	@Test
	public void testChinese() {
		// Verify Chinese is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Chinese));
	}
	
	@Test
	public void testPolish() {
		// Verify Polish is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Polish));
	}
	
	@Test
	public void testPortuguese() {
		// Verify Portuguese is displayed
		SeleneseTestBase.assertTrue(homePage.isLanguageFound(HomePage.Language.Portuguese));
	}

	//sc
	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}
	
}
