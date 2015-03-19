package com.selenium.wikitest.wikipage.homepage.automatedtests.testng;

import com.selenium.wikitest.data.HomePageLanguageLinkDataItem;
import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.homepage.HomePage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenGoToWikiInLanguage {

	private static HomePage homePage = new HomePage();
	
	@DataProvider(name = "test")
	public Iterator<Object[]>  getWikiInLanguageData() {
		HomePageLanguageLinkDataItem[] listStrings = null;
		try {
			listStrings = SQLiteJDBC.queryLanguageLinkObjects("ResultLanguageLinks", "LinkID", "XPath", "Link", "Title");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<HomePageLanguageLinkDataItem> ssList = Arrays.asList(listStrings);                   
		List<Object[]> data = new ArrayList<Object[]>();
		for (HomePageLanguageLinkDataItem line :ssList )            
		{                
			data.add(new Object[]{line});            
		}            
		return data.iterator();
	}

	@Test(dataProvider = "test")
	public void testSearchData(HomePageLanguageLinkDataItem languageLinkItem) {
		homePage.openHomePage();
		String actualResult = homePage.goToListLinkByLinkName(languageLinkItem.getLink());
		try {
			Assert.assertTrue(actualResult.contains(languageLinkItem.getTitle()),
					CommonMethods.formatAssertMessage(languageLinkItem.getTitle(),
							actualResult, Integer.toString(languageLinkItem.getLinkID())));
		} catch (Exception e) {
			homePage.getUniqueScreenshot(this.toString());
			System.out.println("Title = " + languageLinkItem.getTitle());
			e.printStackTrace();
			throw(e);
		}
	}

	@AfterSuite
	public static void commonTearDown() throws Exception {
		homePage.closeBrowser();
	}

}
