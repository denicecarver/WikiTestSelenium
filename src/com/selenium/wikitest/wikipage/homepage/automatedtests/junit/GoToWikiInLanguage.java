package com.selenium.wikitest.wikipage.homepage.automatedtests.junit;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;

@SuppressWarnings("unused")
public class GoToWikiInLanguage extends TestCase {

	private static HomePage homePage = new HomePage();
	private static TestSuite suite = new TestSuite();
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void goToEnglishWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageEnglishText");
		String expectedResult = HomePageText.getString("HomePage.EnglishWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToPolishWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePolishText");
		String expectedResult = HomePageText.getString("HomePage.PolishWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToFrenchWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageFrenchText");
		String expectedResult = HomePageText.getString("HomePage.FrenchWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToGermanWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageGermanText");
		String expectedResult = HomePageText.getString("HomePage.GermanWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToItalianWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageItalianText");
		String expectedResult = HomePageText.getString("HomePage.ItalianWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToJapaneseWiki() {
		String actualResult = homePage.getJapanesePageTitle();
		String expectedResult = HomePageText.getString("HomePage.JapaneseWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToChineseWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageChineseText");
		String expectedResult = HomePageText.getString("HomePage.ChineseWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToRussianWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageRussianText");
		String expectedResult = HomePageText.getString("HomePage.RussianWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToPortugueseWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePortugueseText");
		String expectedResult = HomePageText.getString("HomePage.PortugueseWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}
	
	@Test
	public void goToSpanishWiki() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageSpanishText");
		String expectedResult = HomePageText.getString("HomePage.SpanishWiki");
		assertTrue(CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));
	}

	@After
	public void resetForNextTest() {
		homePage.openHomePage();
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		System.out.println(suite.countTestCases());
		homePage.closeBrowser();
	}

}
