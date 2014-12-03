package com.selenium.wikitest.wikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikiPage {
	protected WebDriver webDriver;
	
	protected String getDisplayedLanguage(String actualLanguage) {
		return getTextAtXPath(actualLanguage);
	}
	
	public WikiPage() {
		webDriver = new FirefoxDriver();
	}
	
	protected WebDriver getDriver() {
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
	
	public void closeAnyBeggarOverlay(String resultURL) {

		WebElement el = null;
		WebElement e2 = null;
		try {
			//			el = webDriver.findElement(By.xpath("/html/body/div[1]/div/table/tbody/tr/td[2]/span"));
			el = webDriver.findElement(By.id("frbanner-close"));
		} catch (NoSuchElementException ex) {
		}
		if (el != null && el.isDisplayed()) {
			el.click();
			//		} else if (e2 != null && e2.isDisplayed()) {
			//			e2.click();
			//		}
//			openPage(resultURL);
		}
			try {
//				openPage(resultURL);
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
////					e.printStackTrace();
//				}
				e2 = webDriver.findElement(By.id("B14_120217_5C_tp_tn2-close"));
//				e2 = waitForElement(By.id("B14_120217_5C_tp_tn2-close"));
			} catch (NoSuchElementException ex1) {
			}
			if (e2 != null && e2.isDisplayed()) {
//				openPage(resultURL);
//				el.click();
				e2.click();
			}
	}

	public void closeBrowser() {
		webDriver.quit();
	}

}
