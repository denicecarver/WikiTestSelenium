package com.selenium.wikitest.wikipage.homepage.automatedtests.testng;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.data.SearchStringDataItem;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;

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
	public static Iterator<Object[]>  getSearchTerms() {
		ArrayList<Object[]> listStrings = null;
		try {
			listStrings = SQLiteJDBC.queryTestNgData2("SearchStrings", "SearchID", "SearchItem");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		Iterator<Object>[] returnValue = (Iterator<Object>[]) listStrings;
		return listStrings.iterator();
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
	public void searchTerm(SearchStringDataItem[] dataItems) {
		for (int i = 0; i < dataItems.length; i++) {
			System.out.println("Search ID: " + dataItems[i].getSearchID() + ", SearchItem: " + dataItems[i].getSearchTerm());
			try {
				String actualResult = homePage.searchFor(dataItems[i].getSearchTerm());
				Assert.assertTrue(actualResult.contains(dataItems[i].getSearchTerm()),
						CommonMethods.formatAssertMessage(dataItems[i].getSearchTerm(), actualResult));
			} catch (Exception e) {
				homePage.getUniqueScreenshot(this.toString());
				System.out.println("searchItem = " + dataItems[i].getSearchTerm());
				e.printStackTrace();
				throw(e);
			}
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
