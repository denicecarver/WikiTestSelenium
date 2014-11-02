package com.selenium.wikitest.webpage.homepage.automatedTests;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.selenium.wikitest.webpage.homepage.Converter;
import com.selenium.wikitest.webpage.homepage.LanguageLink;
import com.selenium.wikitest.webpage.homepage.SQLiteHomePage;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestSuite;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class TestLanguageLinks {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	private static TestSuite suite = new TestSuite();
	
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
	
	// Data-driven test using SQLite
	@Test
	public void verifyLinksFromData() {
		ArrayList<LanguageLink> records = SQLiteHomePage.queryLanguageLinks();
		for (LanguageLink record : records) {
			String expectedResult = record.getTitle();
			String xPath = record.getXPath();
			String actualResult = homePage.goToListLinkByXPath(xPath);
			SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
			homePage.goToHomePage();
		}
	}
	
//	public void buildLanguageLinksDatabase() {
//		homePage.buildLanguageLinkDB();
//	}

	@After
	public void returnToWikipedia() {
		homePage.goToHomePage();
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		System.out.println(suite.countTestCases());
		homePage.closeBrowser();
	}

}
