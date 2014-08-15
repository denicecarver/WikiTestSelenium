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
	
	private static final String expectedEnglishDisplay = "HomePage.LanguageEnglishText";
	private static final String actualEnglishDisplay = "HomePage.LanguageXPathEnglish";
	private static final String expectedSpanishDisplay = "HomePage.LanguageSpanishText";
	private static final String actualSpanishDisplay = "HomePage.LanguageXPathSpanish";
	private static final String expectedJapaneseDisplay = "HomePage.LanguageJapaneseText";
	private static final String actualJapaneseDisplay = "HomePage.LanguageXPathJapanese";
	private static final String expectedRussianDisplay = "HomePage.LanguageRussianText";
	private static final String actualRussianDisplay = "HomePage.LanguageXPathRussian";
	private static final String expectedFrenchDisplay = "HomePage.LanguageFrenchText";
	private static final String actualFrenchDisplay = "HomePage.LanguageXPathFrench";
	private static final String expectedGermanDisplay = "HomePage.LanguageGermanText";
	private static final String actualGermanDisplay = "HomePage.LanguageXPathGerman";
	private static final String expectedItalianDisplay = "HomePage.LanguageItalianText";
	private static final String actualItalianDisplay = "HomePage.LanguageXPathItalian";
	private static final String expectedChineseDisplay = "HomePage.LanguageChineseText";
	private static final String actualChineseDisplay = "HomePage.LanguageXPathChinese";
	private static final String expectedPolishDisplay = "HomePage.LanguagePolishText";
	private static final String actualPolishDisplay = "HomePage.LanguageXPathPolish";
	private static final String expectedPortugueseDisplay = "HomePage.LanguagePortugueseText";
	private static final String actualPortugueseDisplay = "HomePage.LanguageXPathPortuguese";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openPage() {
		super.openPage(CommonPagesText.getString("AnyPage.WikiHomeURL"));
	}
	
	public String[] stringList() {
		return CommonMethods.getDataFromCSV();
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
		
		String propertyExpected = null;
		String propertyActual = null;
		
		switch (val) {
			case English:
				propertyExpected = expectedEnglishDisplay;
				propertyActual = actualEnglishDisplay;
				break;
				
			case Spanish:
				propertyExpected = expectedSpanishDisplay;
				propertyActual = actualSpanishDisplay;
				break;
				
			case Japanese:
				propertyExpected = expectedJapaneseDisplay;
				propertyActual = actualJapaneseDisplay;
				break;
				
			case Russian:
				propertyExpected = expectedRussianDisplay;
				propertyActual = actualRussianDisplay;
				break;
				
			case French:
				propertyExpected = expectedFrenchDisplay;
				propertyActual = actualFrenchDisplay;
				break;
				
			case German:
				propertyExpected = expectedGermanDisplay;
				propertyActual = actualGermanDisplay;
				break;
				
			case Italian:
				propertyExpected = expectedItalianDisplay;
				propertyActual = actualItalianDisplay;
				break;
				
			case Chinese:
				propertyExpected = expectedChineseDisplay;
				propertyActual = actualChineseDisplay;
				break;
				
			case Polish:
				propertyExpected = expectedPolishDisplay;
				propertyActual = actualPolishDisplay;
				break;
				
			case Portuguese:
				propertyExpected = expectedPortugueseDisplay;
				propertyActual = actualPortugueseDisplay;
				break;
			
			default:
				break;
			
		}
		
		String expected = getExpectedLanguage(propertyExpected);
		String actual = getDisplayedLanguage(propertyActual);
		
		return actual.contains(expected);
	}
	
}
