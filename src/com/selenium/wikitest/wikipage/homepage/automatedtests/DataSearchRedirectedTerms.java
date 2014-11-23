package com.selenium.wikitest.wikipage.homepage.automatedtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.wikipage.homepage.HomePage;
import com.selenium.wikitest.wikipage.homepage.HomePageText;
import com.thoughtworks.selenium.SeleneseTestBase;

import java.util.ArrayList;

@RunWith(Parameterized.class)
public class DataSearchRedirectedTerms {

	private static HomePage homePage = new HomePage();
	
	private String searchItem;
	
	public DataSearchRedirectedTerms(String searchItem1, String searchItem2) {
		this.searchItem = searchItem1;
		// searchItem2 is a duplicate of searchItem1
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
					HomePageText.getString("RedirectStrings.TableName"),
					HomePageText.getString("RedirectStrings.Column1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStrings;
	}

	@Test
	public void testRedirectData() {

		try {
			// Assert expected search result record, from list, matches actual result
			SeleneseTestBase.assertTrue(homePage.searchForRedirect(searchItem).contains(searchItem));
		} catch (Exception e) {
			System.out.println(searchItem);
			e.printStackTrace();
		}

		// Return to home page for next test
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
