package com.selenium.wikitest.webpage.homepage.automatedTests;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLanguageLinks {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
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
	
	// Data-driven test
	@Test
	public void testLanguageLinkList() {

		String[] xPathList = homePage.searchStringList("HomePage.CSVLanguageLink");
		int count = 0;
		
		// Walk through the list of XPaths to the links
		for (String s : xPathList) {

			/* Temp code for breakpoint at variable value
			if (count >= 125) {
				System.out.println("Testing link at: " + s);
			}
			// End temp code
			*/

			String actualResult = homePage.goToListLink(homePage.getTextAtXPath(s));
			String expectedResult = HomePageText.getString("HomePage.Link" + count);
			SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
			
			// increment counter
			count++;
			
			// Return to home page for next test
			homePage.openHomePage();
		}
		System.out.println(count + " Tests Completed");
	}
	
	/*
	@Test
	public void testExcelLanguageLinkList()  throws BiffException, IOException {       
	    Sheet s;
	    WebDriver driver = new FirefoxDriver();
	    FileInputStream fi = new FileInputStream("E:\\myExcelWorkBook.xls");
	    Workbook W = Workbook.getWorkbook(fi);

	    s = W.getSheet(0);

	    for(int row = 0;row <= s.getRows();row++)
	    {
	        String Username = s.getCell(0,row).getContents();
	        System.out.println("Username" +Username);
	        driver.get("AppURL");
	        driver.findElement(By.id("txtUserName")).sendKeys(Username);

	        String password= s.getCell(1, row).getContents();
	        System.out.println("Password "+password);

	        driver.findElement(By.id("txtPassword")).sendKeys(password);

	        driver.findElement(By.id("btnLogin")).click();
	    }
	}
	*/

	@After
	public void returnToWikipedia() {
		homePage.goToHomePage();
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
