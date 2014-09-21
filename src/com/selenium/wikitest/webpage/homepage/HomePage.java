package com.selenium.wikitest.webpage.homepage;

import com.selenium.wikitest.webpage.WebPage;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.shared.CommonPagesText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	public void openPage() {
		super.openPage(CommonPagesText.getString("AnyPage.WikiHomeURL"));
	}
	
	public String[] searchStringList(String propertyFilename) {
		return CommonMethods.getDataFromCSV(propertyFilename);
	}
	
	private String getExpectedLanguage(String expectedLanguage) {
		return HomePageText.getString(expectedLanguage);
	}
	
	private String getDisplayedLanguage(String actualLanguage) {
		return getTextAtXPath(actualLanguage);
	}
	
	public String getTextAtXPath(String xpathToElement) {
		return CommonMethods.waitForElement(webDriver, By.xpath(HomePageText.getString(xpathToElement))).getText();
	}
	
	public boolean isLanguageFound(Language val) {
		return getDisplayedLanguage("HomePage.LanguageXPath" + val.toString()).contains(getExpectedLanguage("HomePage.Language" + val.toString() + "Text"));
	}
	
	public String goToProjectLink(String keyName) {
		return CommonMethods.clickProjectLink(webDriver, HomePageText.getString(keyName));
	}
	
	public boolean isProjectFound(String projectKey) {
		String project = goToProjectLink(projectKey);
		return false;
	}
	
	public String goToHomeLink() {
		return CommonMethods.clickHomeLink(webDriver, HomePageText.getString("HomePage.WikiTitle"));
	}
	
}
