package com.selenium.wikitest.wikipage.homepage;

import java.sql.SQLException;
import java.util.ArrayList;

import com.thoughtworks.selenium.SeleneseTestBase;

public class HomePageUtilities {
	
//	Run this script before building table.
//	CREATE TABLE LanguageLinks(
//			LinkID INTEGER PRIMARY KEY,
//			Link TEXT,
//			Title TEXT);

	//	@TODO move to utilities class
	public void insertIntoLanguageLinksTable(HomePage homePage) {
		ArrayList<String[]> records = new ArrayList<>(300);
		int recordCount = 266;
		for (int i = 1; i <= recordCount; i++) {
			String[] record = new String[2];
			record[0] = HomePageText.getString("HomePage.XPathAddlLink" + i);
			record[1] = homePage.goToListLinkByXPath(record[0]);
			records.add(record);
			homePage.openHomePage();
		}

		try {
			SQLiteHomePage.insertLanguageLinks(records);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	Run these scripts before building table.
//	CREATE TABLE SearchStrings(
//	SearchID INTEGER PRIMARY KEY,
//	SearchItem TEXT);
//	CREATE TABLE RedirectStrings(
//	RedirectID INTEGER PRIMARY KEY,
//	RedirectItem TEXT);
//	TODO Move this method to a Utilities class
//	@Ignore @Test
//	public void buildSearchTables() {
//		homePage.buildSearchTable(HomePageText.getString("SearchStrings.TableName"),
//				HomePageText.getString("SearchStrings.Column1"),
//				Integer.parseInt(HomePageText.getString("SearchStrings.Count")));
//		homePage.buildSearchTable(HomePageText.getString("RedirectStrings.TableName"),
//				HomePageText.getString("RedirectStrings.Column1"),
//				Integer.parseInt(HomePageText.getString("RedirectStrings.Count")));
//	}

	public void buildSearchTable(String tableName, String columnName, int recordCount) {
		ArrayList<String> records = new ArrayList<>(100);
		for (int i = 1; i <= recordCount; i++) {
			String record = HomePageText.getString(tableName + ".Record" + i);
			records.add(record);
		}

		try {
			SQLiteHomePage.insertIntoTable(tableName, columnName, records);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	// For testing LanguageLink table data errors
	// @TODO Cleanup once need is better defined.
	public void tempTest(HomePage homePage) {
//		ଉଇକିପିଡ଼ିଆ
//		LanguageLink link = new LanguageLink("/html/body/div[8]/a[69]", "ଉଇକିପିଡ଼ିଆ");
//		links.add(link);
//		try {
//			SQLiteHomePage.updateLanguageLinkTitles(links);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		ArrayList<String[]> links = new ArrayList<>(10);
		try {
			links = SQLiteHomePage.queryData("LanguageLinks", "Link", "Title");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int count = 0;
		for (String[] link: links) {
			if (count == 195) {
				System.out.println(link[0] + "' " + link[1]);
				SeleneseTestBase.assertEquals("ଉଇକିପିଡ଼ିଆ", link[1]);
			}
			count++;
		}
		String retval = homePage.goToListLinkByXPath("/html/body/div[8]/a[69]");
		retval = retval + "xxx";
	}

}
