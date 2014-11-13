package com.selenium.wikitest.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
	
	public static WebElement waitForElement(WebDriver driver, By by)
    {
		int tenthSecond;
		int sleepTime = 100;
        for (tenthSecond = 1; tenthSecond <= 20/*200*/; tenthSecond++) {
        	try {
        		return driver.findElement(by);
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
	
	
	public static String searchFor(WebDriver driver, By elementHandle, String searchString) {

		// Enter expected text in search text box
		waitForElement(driver,
				By.id(CommonPagesText.getString("AnyPage.SearchID"))).sendKeys(searchString);
		
		// search is dependent on starting page
		waitForElement(driver, elementHandle).click();

		return driver.getTitle();
	}
	
	public static String searchFor(WebDriver driver, String searchString) {
		return searchFor(driver,
				By.name(CommonPagesText.getString("AnyPage.GoSearchName")),
				searchString);
	}

	public static String clickProjectLink(WebDriver driver, String linkName) {
		(driver.findElement(By.partialLinkText(linkName))).click();
		return driver.getTitle();
	}

	public static String clickProjectLinkByXPath(WebDriver driver, String xPath) throws NullPointerException {
		String title = new String();
		try {
			(driver.findElement(By.xpath(xPath))).click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		title = driver.getTitle();
		return title;
	}
	

}
