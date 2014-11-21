package com.selenium.wikitest.wikipage.homepage;

import com.selenium.wikitest.wikipage.WikiPage;
import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.shared.CommonPagesText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends WikiPage{
	
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
	
	private String getExpectedLanguage(String expectedLanguage) {
		return HomePageText.getString(expectedLanguage);
	}
	
	public boolean isLanguageFound(Language val) {
		return getDisplayedLanguage(HomePageText.getString("HomePage.LanguageXPath" + val.toString())).contains(getExpectedLanguage("HomePage.Language" + val.toString() + "Text"));
	}
	
	public String goToProjectLink(String keyName) {
		return CommonMethods.clickProjectLink(webDriver, HomePageText.getString(keyName));
	}
	
	public String goToListLinkByXPath(String xPath) {
		return CommonMethods.clickProjectLinkByXPath(webDriver, xPath);
	}
	
	public String getJapanesePageTitle() {
		WebElement we = CommonMethods.waitForElement(webDriver, By.linkText(HomePageText.getString("HomePage.LanguageJapaneseText")));
		return we.getText();
	}

}
