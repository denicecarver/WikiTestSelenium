package com.selenium.wikitest.wikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.wikitest.shared.CommonMethods;

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
		openPage(WikiPageText.getString("AnyPage.WikiHomeURL"));
	}
	
	public String getTextAtXPath(String xpathToElement) {
		return waitForElement(By.xpath(xpathToElement)).getText();
	}
	
	public String searchForRedirect(String redirectString) {
		
		searchFor(redirectString);
		webDriver.findElement(By.linkText(redirectString)).click();
		return webDriver.getTitle();
	}

	public String clickProjectLink(String linkName) {
		(webDriver.findElement(By.partialLinkText(linkName))).click();
		return webDriver.getTitle();
	}

	public String clickProjectLinkByXPath(String xPath) throws NullPointerException {
		String title = new String();
		try {
			(webDriver.findElement(By.xpath(xPath))).click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		title = webDriver.getTitle();
		return title;
	}
	
	protected WebElement waitForElement(By by)
    {
		int tenthSecond;
		int sleepTime = 100;
        for (tenthSecond = 1; tenthSecond <= 20/*200*/; tenthSecond++) {
        	try {
        		return webDriver.findElement(by);
        	} catch (NoSuchElementException e) {
        		// swallow - expect to not find within wait period
        		System.out.println("Tenth seconds waited:  " + tenthSecond);
        	}
        	try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException ei) {
				ei.printStackTrace();
			}
        }
        System.out.println("Failed at Tenth Second: " + tenthSecond);
        throw new NoSuchElementException("Looking for element by: " + by.toString());
    }
	
	public String searchFor(By elementHandle, String searchString) {

		// Enter expected text in search text box
		waitForElement(By.id(WikiPageText.getString("AnyPage.SearchID"))).sendKeys(searchString);
		
		// search is dependent on starting page
		waitForElement(elementHandle).click();

		return webDriver.getTitle();
	}
	
	public String searchFor(String searchString) {
		return searchFor(By.name(WikiPageText.getString("AnyPage.GoSearchName")),
				searchString);
	}

	public void closeBrowser() {
		webDriver.quit();
	}

}
