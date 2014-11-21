package com.selenium.wikitest.wikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.shared.CommonPagesText;

public class WikiPage {
	protected WebDriver webDriver;
	
	protected String getDisplayedLanguage(String actualLanguage) {
		return getTextAtXPath(actualLanguage);
	}
	
	public WikiPage() {
		webDriver = new FirefoxDriver();
	}
	
	public WebDriver getDriver() {
		return webDriver;
	}
	
	public void openPage(String url) {
		try {
			webDriver.get(url);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void openHomePage() {
		openPage(CommonPagesText.getString("AnyPage.WikiHomeURL"));
	}
	
	public String getTextAtXPath(String xpathToElement) {
		return CommonMethods.waitForElement(webDriver, By.xpath(xpathToElement)).getText();
	}
	
	public String searchFor(String searchString) {
		return CommonMethods.searchFor(webDriver, searchString);
	}
	
	public String searchForRedirect(String redirectString) {
		
		searchFor(redirectString);
		webDriver.findElement(By.linkText(redirectString)).click();
		return webDriver.getTitle();
	}

	public void closeBrowser() {
		webDriver.quit();
	}

}
