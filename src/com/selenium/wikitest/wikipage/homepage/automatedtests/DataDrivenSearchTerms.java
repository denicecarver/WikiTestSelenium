package com.selenium.wikitest.wikipage.homepage.automatedtests;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenSearchTerms {

	private static HomePage homePage = new HomePage();
		
	@BeforeSuite
	public static void testSetup() {
		homePage.openPage();
		
	}
	
	@DataProvider(name = "test")
	public static Object[]  getSearchTerms() {
		Object[][] listStrings = null;
		try {
			listStrings = SQLiteJDBC.queryDataTestNG(
					HomePageText.getString("SearchStrings.TableName"),
					HomePageText.getString("SearchStrings.Column1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStrings;
	}

	@Test(dataProvider = "test")
	public void searchTerm(String[] searchItem) {
		try {
			String actualResult = homePage.searchFor(searchItem[1]);
			// Assert expected search result record, from list, matches actual result
			Assert.assertTrue(actualResult.contains(searchItem[1]),
					CommonMethods.formatAssertMessage(searchItem[1], actualResult));
		} catch (AssertionError e) {
			homePage.getUniqueScreenshot(this.toString());
			System.out.println("searchItem = " + searchItem);
			e.printStackTrace();
			throw(e);
		}

		// Return to home page for next test
		homePage.openHomePage();

	}

	@AfterMethod
	public void returnToWikipedia() {
		homePage.openHomePage();
	}

	@AfterSuite
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
