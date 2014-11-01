package com.selenium.wikitest.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.shared.CommonPagesText;

public class WebPage {
	protected WebDriver webDriver;
	
	public WebPage(WebDriver driver) {
		webDriver = driver;
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
