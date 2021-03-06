package com.selenium.wikitest.wikipage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

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
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void openHomePage() {
		openPage(WikiPageText.getString("AnyPage.WikiHomeURL"));
	}
	
	public String getTextAtXPath(String xpathToElement) {
		return waitForElement(By.xpath(xpathToElement)).getText();
	}
	
	public String getTextAtTitle(String titleOfElement) {
		return waitForElement(By.name(titleOfElement)).getText();
	}
	
	private String getNthStringAtClassname(String className, int indexToElement) {
		String returnString = "";
		List<WebElement> classesIn = findElementsByClassName("searchresults");
		WebElement element = classesIn.get(indexToElement);
		if (element != null) {
			returnString = element.getText();
		}
		return returnString;
	}
	
	public String getSearchResultDetails() {
		return getNthStringAtClassname("searchresult", 0);
	}
	
	public String searchForRedirect(String redirectString) {
		
		searchFor(redirectString);
		webDriver.findElement(By.linkText(redirectString)).click();
		return webDriver.getTitle();
	}

	protected String clickProjectLink(String linkName) {
		(webDriver.findElement(By.partialLinkText(linkName))).click();
		return webDriver.getTitle();
	}

	public String clickProjectLinkByXPath(String xPath) throws NullPointerException {
		String title = new String();
		try {
			(webDriver.findElement(By.xpath(xPath))).click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		title = webDriver.getTitle();
		return title;
	}

	public String clickProjectLinkByID(String id) throws NullPointerException {
		String title = new String();
		try {
			(webDriver.findElement(By.id(id))).click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		title = webDriver.getTitle();
		return title;
	}

	protected String getTooltipByLink(String link) {
	
		String title = new String();
		try {
			WebElement element = webDriver.findElement(By.partialLinkText(link));
			title = element.getAttribute("title");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return title;

	}

	protected String getTooltipByID(String id) {
		String title = new String();
		try {
			WebElement element = webDriver.findElement(By.id(id));
			title = element.getAttribute("title");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return title;
	}

	protected String getTooltipByXPath(String xPath) {
		String title = new String();
		try {
			WebElement element = webDriver.findElement(By.id(xPath));
			title = element.getAttribute("title");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return title;
	}

	protected String getTooltipByCSS(String css) {
		String title = new String();
		try {
			WebElement element = webDriver.findElement(By.cssSelector(css));
			title = element.getAttribute("title");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return title;
	}
	
	protected List<WebElement> findElementsByClassName(String elementClassName) {
		return webDriver.findElements(By.className(elementClassName));
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
				System.out.println(ei.getMessage());
				System.out.println(ei.getStackTrace());
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
	
	public void closeAnyBeggarOverlay() {

		WebElement beggarCloseButton = null;
		try {
			beggarCloseButton = webDriver.findElement(By.xpath("//*[@id=\"B14_120719_5C_tp_ct-close\"]"));
		} catch (NoSuchElementException ex) {
			// Swallow exception because this is the common, expected outcome
		}
		
		// If there is an overlay close button, click it
		if (beggarCloseButton != null && beggarCloseButton.isDisplayed()) {
			beggarCloseButton.click();
		}
	}

	public void getUniqueScreenshot(String filenameNoExtension) {
		getScreenshot(filenameNoExtension + CommonMethods.getUniqueStringFromCurrentMilliseconds());
	}

	public void getScreenshot(String filenameNoExtension) {
		WebDriver augmentedDriver = new Augmenter().augment(webDriver);
		File screenshot = ((TakesScreenshot)augmentedDriver).
				getScreenshotAs(OutputType.FILE);
		try {
			System.out.println(WikiPageText.getString("AnyPage.ErrorImagePath") + filenameNoExtension + ".png");
			FileUtils.copyFile(screenshot, new File(WikiPageText.getString("AnyPage.ErrorImagePath") + filenameNoExtension + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPageTitle() {
		return webDriver.getTitle();
	}

	public void closeBrowser() {
		webDriver.quit();
	}

}
