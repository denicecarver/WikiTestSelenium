package com.selenium.wikitest.wikipage.homepage;

import com.selenium.wikitest.wikipage.WikiPageText;
import com.selenium.wikitest.wikipage.WikiPage;
import com.selenium.wikitest.shared.CommonMethods;

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
	
	private String getExpectedLanguage(String expectedLanguage) {
		return HomePageText.getString(expectedLanguage);
	}
	
	public void openPage() {
		super.openPage(WikiPageText.getString("AnyPage.WikiHomeURL"));
	}
	
	public boolean isLanguageFound(Language val) {
		return getDisplayedLanguage(HomePageText.getString("HomePage.LanguageXPath" + val.toString())).contains(getExpectedLanguage("HomePage.Language" + val.toString() + "Text"));
	}
	
	public String goToProjectLink(String keyName) {
		return clickProjectLink(HomePageText.getString(keyName));
	}
	
	public String goToListLinkByXPath(String xPath) {
		return clickProjectLinkByXPath(xPath);
	}
	
	public String getJapanesePageTitle() {
		WebElement we = waitForElement(By.linkText(HomePageText.getString("HomePage.LanguageJapaneseText")));
		return we.getText();
	}

}
