package com.selenium.wikitest.webpage.homepage;

import java.sql.SQLException;
import java.util.ArrayList;

import com.selenium.wikitest.webpage.WebPage;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.shared.CommonPagesText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage{
	
	public static enum Language {
		English,
		Spanish,
		Japanese,
		Russian,
		French,
		German,
		Italian,
		Chinese,
		Polish,
		Portuguese
	}
	
	public void openPage() {
		super.openPage(CommonPagesText.getString("AnyPage.WikiHomeURL"));
	}
	
	public String[] searchStringList(String propertyFilename) {
		return CommonMethods.getSearchDataFromCSV(HomePageText.getString(propertyFilename));
	}
	
	private String getExpectedLanguage(String expectedLanguage) {
		return HomePageText.getString(expectedLanguage);
	}
	
	private String getDisplayedLanguage(String actualLanguage) {
		return getTextAtXPath(actualLanguage);
	}
	
	public String getTextAtXPath(String xpathToElement) {
		return CommonMethods.waitForElement(webDriver, By.xpath(xpathToElement)).getText();
	}
	
	public boolean isLanguageFound(Language val) {
		return getDisplayedLanguage(HomePageText.getString("HomePage.LanguageXPath" + val.toString())).contains(getExpectedLanguage("HomePage.Language" + val.toString() + "Text"));
	}
	
	public String goToProjectLink(String keyName) {
		return CommonMethods.clickProjectLink(webDriver, HomePageText.getString(keyName));
	}
	
	public String goToListLink(String linkName) {
		return CommonMethods.clickProjectLink(webDriver, linkName);
	}
	
	public String goToListLinkByXPath(String xPath) {
		return CommonMethods.clickProjectLinkByXPath(webDriver, xPath);
	}
	
	public String goToHomePage() {
		webDriver.get(CommonPagesText.getString("AnyPage.WikiHomeURL"));
		return webDriver.getTitle();
	}
	
	public boolean isHomePage() {
		return webDriver.getTitle().contains("WikiHome");
	}
	
	public String getJapanesePageTitle() {
		WebElement we = CommonMethods.waitForElement(webDriver, By.linkText(HomePageText.getString("HomePage.LanguageJapaneseText")));
		return we.getText();
	}
	
	public void insertIntoLanguageLinksTable() {
		ArrayList<LanguageLink> records = new ArrayList<>(300);
		for (int i = 1; i<=266; i++) {
			String link = HomePageText.getString("HomePage.XPathAddlLink" + i);
			String title = goToListLinkByXPath(link);
			LanguageLink record =  new LanguageLink(link, title);
			records.add(record);
			goToHomePage();
		}

		try {
			SQLiteHomePage.insertLanguageLinks(records);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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

}
