package com.selenium.wikitest.wikipage.homepage.automatedtests.testng;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.data.HomePageSearchStringDataItem;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenSearchRedirectedTerms {

	private static HomePage homePage = new HomePage();
		
	@BeforeSuite
	public void testSetup() {
		homePage.openPage();
		
	}
	
	@DataProvider(name = "test")
	public Iterator<Object[]>  getSearchTerms() {
		HomePageSearchStringDataItem[] listStrings = null;
		try {
			listStrings = SQLiteJDBC.querySearchStringObjects("RedirectStrings", "RedirectID", "RedirectItem");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<HomePageSearchStringDataItem> ssList = Arrays.asList(listStrings);                   
		List<Object[]> data = new ArrayList<Object[]>();
		for (HomePageSearchStringDataItem line :ssList )            
		{                
			data.add(new Object[]{line});            
		}            
		return data.iterator();
	}
	
	@Test(dataProvider = "test")
	public void searchTerm(HomePageSearchStringDataItem redirectDataItem) {
		System.out.println("Redirect ID: " + redirectDataItem.getSearchID() + ", RedirectItem: " + redirectDataItem.getSearchTerm());
		String actualResult = homePage.searchForRedirect(redirectDataItem.getSearchTerm());
		try {
			Assert.assertTrue(actualResult.contains(redirectDataItem.getSearchTerm()),
					CommonMethods.formatAssertMessage(redirectDataItem.getSearchTerm(), actualResult, Integer.toString(redirectDataItem.getSearchID())));
		} catch (Exception e) {
			homePage.getUniqueScreenshot(this.toString());
			System.out.println("RedirectItem = " + redirectDataItem.getSearchTerm());
			e.printStackTrace();
			throw(e);
		}
		homePage.openHomePage();
	}

	@AfterSuite
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
