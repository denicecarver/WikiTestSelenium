package com.selenium.wikitest.webpage.homepage.automatedTests;

import com.selenium.wikitest.webpage.homepage.HomePage;
import com.selenium.wikitest.webpage.homepage.HomePageText;
import com.selenium.wikitest.webpage.homepage.SQLiteHomePage;
import com.thoughtworks.selenium.SeleneseTestBase;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestDataLanguageLinks {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
	private String xPath;
	private String title;
	
	public TestDataLanguageLinks (String xPath, String title) {
		this.xPath = xPath;
		this.title = title;
	}
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Parameters
	public static ArrayList<String[]> getSearchData() {
		ArrayList<String[]> listStrings = null;
		try {
			listStrings = SQLiteHomePage.queryData(
					HomePageText.getString("LanguageLinks.TableName"),
					HomePageText.getString("LanguageLinks.Column1"),
					HomePageText.getString("LanguageLinks.Column2"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStrings;
	}

	@Test
	public void testSearchData() {
		String actualResult = homePage.goToListLinkByXPath(xPath);
		SeleneseTestBase.assertTrue(actualResult.contains(title));
		homePage.goToHomePage();
	}

	@After
	public void returnToWikipedia() {
		homePage.goToHomePage();
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
