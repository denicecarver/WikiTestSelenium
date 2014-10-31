package com.selenium.wikitest.webpage.homepage.automatedTests;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.selenium.wikitest.webpage.homepage.Converter;
import com.selenium.wikitest.webpage.homepage.LanguageLink;
import com.selenium.wikitest.webpage.homepage.SQLiteJDBCHomePage;

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
	
	@Ignore @Test
	public void testEnglishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageEnglishText");
		String expectedResult = HomePageText.getString("HomePage.EnglishWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testPolishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePolishText");
		String expectedResult = HomePageText.getString("HomePage.PolishWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testFrenchLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageFrenchText");
		String expectedResult = HomePageText.getString("HomePage.FrenchWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testGermanLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageGermanText");
		String expectedResult = HomePageText.getString("HomePage.GermanWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testItalianLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageItalianText");
		String expectedResult = HomePageText.getString("HomePage.ItalianWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testJapaneseLink() {
		String actualResult = homePage.getJapanesePageTitle();
		String expectedResult = HomePageText.getString("HomePage.JapaneseWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testChineseLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageChineseText");
		String expectedResult = HomePageText.getString("HomePage.ChineseWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testRussianLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageRussianText");
		String expectedResult = HomePageText.getString("HomePage.RussianWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testPortugueseLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguagePortugueseText");
		String expectedResult = HomePageText.getString("HomePage.PortugueseWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Ignore @Test
	public void testSpanishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.LanguageSpanishText");
		String expectedResult = HomePageText.getString("HomePage.SpanishWiki");
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}
	
	// This is a maintenance method and should be moved to a shared method
	@Ignore @Test
	public void buildLinkDatabase() {
		String CSVFilename = HomePageText.getString("HomePage.CSVLanguageLinkData");
		homePage.addCSVRecordsToDB(CSVFilename);
	}
	
	@Ignore @Test
	public void temp() {
		String test = "Trying This.";
		test = SQLiteJDBCHomePage.convertStringToUnicode(test);
		test = SQLiteJDBCHomePage.convertUnicodeEncodedToString(test);
		System.out.println(test);
	}
	
	@Test
	public void setTitleForLink() {
		ArrayList<LanguageLink> records = new ArrayList<>(200);
		for (int i = 1; i<=127; i++) {
			String link = HomePageText.getString("HomePage.XPathAddlLink" + i);
			String title = homePage.goToListLinkByXPath(link);
			LanguageLink record =  new LanguageLink(link, title);
			records.add(record);
			homePage.goToHomePage();
		}

		SQLiteJDBCHomePage.updateLanguageLinkTitles(records);
	}
	
// Data-driven test using HomePage.db, LanguageLinks table
	// Preliminary work
		// Put CSV list into table
			// Add under homepage supplying CSV filename (languagelinkdata.csv) and table (LanguageLinks)
	// Data-driven test is testLanguageLinkList()
		// Get array of links and titles from table using SQLiteJDBCHomePage.queryLanguageLinks()
			// Query uses LanguageLinks table
		// Loop through array to get each record from array
		// Test record: Click link and verify title
	@Ignore @Test
	public void testLanguageLinkList() throws SQLException, Exception {
		
		ArrayList<LanguageLink> linksList = SQLiteJDBCHomePage.queryLanguageLinks();

		Iterator<LanguageLink> DataListIterator = linksList.iterator();
		while (DataListIterator.hasNext()) {
			LanguageLink curr = DataListIterator.next();
			
//			String expectedResult = curr.getExpectedResultTitle();
			String actualResult = new String(homePage.goToListLink(homePage.getTextAtXPath(curr.getLinkXPath())));
//			SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
		}
		System.out.println("All tests complete");

//		Temp code for breakpoint at variable value
//		if (count >= 7) {
//			System.out.println("Testing link at: " + count);
//			String c = Converter.Uni2JavaLiteral(linkData.getExpectedResultTitle());
//			System.out.println(linkData.getExpectedResultTitle());
//			System.out.println(c);
//		}
//		End temp code
//	SQLiteJDBC db = new SQLiteJDBC();
//	String title = new String("\u044D\u043D\u0446\u0438\u043A\u043B\u043E\u043F\u0435\u0434\u0438\u044F");
//	
//	String link = HomePageText.getString("HomePage.Link26");
//	
//	String connString = HomePageText.getString("HomePage.ConnectionDetails");
//	connString = connString.replace('/', '\\');
//
//	SQLiteJDBCHomePage.queryLanguageLinks();
//	ArrayList<ArrayList<String>> dbRows = db.QueryAllLanguageLinks();
//	ArrayList<String> columns = null;
//	for (int i = 0; i < dbRows.size(); i++) {
//		columns = dbRows.get(i);
//		String xPathLink = columns.get(0);
//		String expectedResult = columns.get(1);
//		String actualResult = homePage.goToListLink(homePage.getTextAtXPath(xPathLink));
//		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
//	}
		
	// Return to home page for next test
	homePage.openHomePage();
	//System.out.println(count + " Tests Completed");
}

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
