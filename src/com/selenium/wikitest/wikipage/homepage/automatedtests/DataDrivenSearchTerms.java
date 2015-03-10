package com.selenium.wikitest.wikipage.homepage.automatedtests;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenSearchTerms {

	private static HomePage homePage = new HomePage();
		
	@BeforeSuite
	public void testSetup() {
		homePage.openPage();
		
	}
	
	@DataProvider(name = "test")
	public static Object[][]  getSearchTerms() {
		Object[][] listStrings = null;
		try {
			listStrings = SQLiteJDBC.queryTestNgData("SearchStrings", "SearchID", "SearchItem");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStrings;
	}
	
//	@DataProvider(name = "test")
//	public static ArrayList<Object>[]  getSearchTerms2() {
//		Object[][] listStrings = null;
//		try {
//			listStrings = SQLiteJDBC.queryTestNgData("SearchStrings", "SearchID", "SearchItem");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listStrings;
//	}

	@Test(dataProvider = "test")
	public void searchTerm(String searchID, String searchItem) {
//		try {
//			String actualResult = homePage.searchFor(searchItem[1]);
//			// Assert expected search result record, from list, matches actual result
//			Assert.assertTrue(actualResult.contains(searchItem[1]),
//					CommonMethods.formatAssertMessage(searchItem[1], actualResult));
//		} catch (AssertionError e) {
//			homePage.getUniqueScreenshot(this.toString());
//			System.out.println("searchItem = " + searchItem);
//			e.printStackTrace();
//			throw(e);
//		}
		System.out.println("Search ID: " + searchID + ", SearchItem: " + searchItem);
		try {
			String actualResult = homePage.searchFor(searchItem);
			Assert.assertTrue(actualResult.contains(searchItem),
					CommonMethods.formatAssertMessage(searchItem, actualResult));
		} catch (Exception e) {
			homePage.getUniqueScreenshot(this.toString());
			System.out.println("searchItem = " + searchItem);
			e.printStackTrace();
			throw(e);
		}
	}

	@AfterMethod
	public void returnToWikipedia() {
		System.out.println("AfterMethod reached");
		homePage.openHomePage();
	}

	@AfterSuite
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
