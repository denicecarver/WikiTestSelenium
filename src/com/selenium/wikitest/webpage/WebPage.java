package com.selenium.wikitest.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.webpage.homepage.HomePageText;

public class WebPage {
	protected WebDriver webDriver;
	
	public WebPage(WebDriver driver) {
		webDriver = driver;
	}
	
	public void openPage(String url) {
		try {
			webDriver.get(url);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void closeWindow() {
		webDriver.quit();
	}

}
