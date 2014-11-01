package com.selenium.wikitest.webpage.homepage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.selenium.wikitest.webpage.WebPage;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.shared.CommonPagesText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public ArrayList<LanguageLink> getLinkTestDataFromCSV(String filename) {
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<LanguageLink> languageLinks = new ArrayList<LanguageLink>(100);
		 
		try {
			br = new BufferedReader(new FileReader(filename));
			
			while ((line = br.readLine()) != null) {
				String[] strings;
				strings = line.split(cvsSplitBy);
				LanguageLink linkData = new LanguageLink(strings);
				languageLinks.add(linkData);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return languageLinks;
		
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
		return getDisplayedLanguage("HomePage.LanguageXPath" + val.toString()).contains(getExpectedLanguage("HomePage.Language" + val.toString() + "Text"));
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
	
	public void addCSVRecordsToDB(String CSVFilename) {
		ArrayList<LanguageLink> xPathList = getLinkTestDataFromCSV(CSVFilename);
		SQLiteHomePage.insertLanguageLinks(xPathList);
	}
	
	
//	public void updateTitleForLinkInDB() {
//		ArrayList<LanguageLink> records = new ArrayList<>(200);
//		for (int i = 1; i<=127; i++) {
//			String link = HomePageText.getString("HomePage.XPathAddlLink" + i);
//			String title = goToListLinkByXPath(link);
//			LanguageLink record =  new LanguageLink(link, title);
//			records.add(record);
//			goToHomePage();
//		}
//	}

	public void buildLanguageLinkDB() {
		ArrayList<LanguageLink> records = new ArrayList<>(200);
		for (int i = 1; i<=127; i++) {
			String link = HomePageText.getString("HomePage.XPathAddlLink" + i);
			String title = goToListLinkByXPath(link);
			LanguageLink record =  new LanguageLink(link, title);
			records.add(record);
			goToHomePage();
		}

		SQLiteHomePage.insertLanguageLinks(records);
	}

}
