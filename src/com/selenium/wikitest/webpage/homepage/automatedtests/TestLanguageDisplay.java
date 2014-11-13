package com.selenium.wikitest.webpage.homepage.automatedtests;

import java.sql.SQLException;
import java.util.ArrayList;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.SQLiteHomePage;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.AfterClass;

public class TestLanguageDisplay {

	private static HomePage homePage = new HomePage();
	
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
	
	// For testing LanguageLink table data errors
	@Ignore @Test
	public void tempTest() {
//		ଉଇକିପିଡ଼ିଆ
//		LanguageLink link = new LanguageLink("/html/body/div[8]/a[69]", "ଉଇକିପିଡ଼ିଆ");
//		links.add(link);
//		try {
//			SQLiteHomePage.updateLanguageLinkTitles(links);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		ArrayList<String[]> links = new ArrayList<>(10);
		try {
			links = SQLiteHomePage.queryData("LanguageLinks", "Link", "Title");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int count = 0;
		for (String[] link: links) {
			if (count == 195) {
				System.out.println(link[0] + "' " + link[1]);
				SeleneseTestBase.assertEquals("ଉଇକିପିଡ଼ିଆ", link[1]);
			}
			count++;
		}
		String retval = homePage.goToListLinkByXPath("/html/body/div[8]/a[69]");
		retval = retval + "xxx";
	}

	@AfterClass
	public static void testTeardown() {
		homePage.closeBrowser();
	}
	
}
