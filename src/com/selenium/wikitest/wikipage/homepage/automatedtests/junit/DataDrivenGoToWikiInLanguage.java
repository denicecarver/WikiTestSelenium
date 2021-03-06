package com.selenium.wikitest.wikipage.homepage.automatedtests.junit;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DataDrivenGoToWikiInLanguage extends TestCase {

	private static HomePage homePage = new HomePage();
	
	private String link;
	private String title;
	
	public DataDrivenGoToWikiInLanguage (String link, String title) {
		this.link = link;
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
			listStrings = SQLiteJDBC.queryData(
					"ResultLanguageLinks", "Link", "Title");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStrings;
	}

	@Test
	public void testSearchData() {
		String actualResult = homePage.goToListLinkByLinkName(link);
		try {
			assertTrue(CommonMethods.formatAssertMessage(title, actualResult),
					actualResult.contains(title));
		} catch (AssertionError e) {
			System.out.println("link = " + link);
			System.out.println("title = " + title);
			e.printStackTrace();
			homePage.getUniqueScreenshot(this.toString());
			throw(e);
		}
		homePage.openHomePage();
	}

	@After
	public void returnToWikipedia() {
		homePage.openHomePage();
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
