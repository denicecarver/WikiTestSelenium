package com.selenium.wikitest.wikipage.resultpage.common.automatedtests;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.selenium.wikitest.data.SQLiteJDBC;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.resultpage.common.CommonPage;

@RunWith(Parameterized.class)
public class DataResultLanguages extends TestCase {

	private static CommonPage commonPage = new CommonPage();
	
	private String xPath;
	private String link;
	private String title;
	
	public DataResultLanguages (String xPath, String link, String title) {
		this.xPath = xPath;
		this.link = link;
		this.title = title;
	}
	
	@Before
	public void removeBeggarOverlay() {
		commonPage.openHomePage();
		commonPage.searchFor("selenium");
	}
	
	@Parameters
	public static ArrayList<String[]> getSearchData() {
		ArrayList<String[]> listStrings = null;
		try {
			listStrings = SQLiteJDBC.queryData(
					"ResultLanguageLinks",
					"XPath",
					"Link",
					"Title");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStrings;
	}

	@Test
	public void testSearchData() {
		String actualResult;
		actualResult = commonPage.clickProjectLinkByXPath(xPath);
		try {
			assertTrue(CommonMethods.formatAssertMessage(title, actualResult) + "\n\txPath: " + xPath,
					actualResult.equals(title));
		} catch (Exception e) {
	        commonPage.getUniqueScreenshot(this.toString());
			System.out.println("xPath = " + xPath);
			System.out.println("link = " + link);
			System.out.println("title = " + title);
			e.printStackTrace();
			throw(e);
		}
	}

	@AfterClass
	public static void commonTearDown() throws Exception {
		commonPage.closeBrowser();
	}

}
