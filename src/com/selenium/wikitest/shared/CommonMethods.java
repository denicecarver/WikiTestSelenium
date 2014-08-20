package com.selenium.wikitest.shared;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.*;

//import com.selenium.wikitest.webpage.homepage.*;

public class CommonMethods {
	
	public static WebElement waitForElement(WebDriver driver, By by)
    {
		int tenthSecond;
		int sleepTime = 100;
        for (tenthSecond = 1; tenthSecond <= 10/*200*/; tenthSecond++) {
        	try {
        		return driver.findElement(by);
        	} catch (NoSuchElementException e) {
        		// swallow
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
	
	public static String[] getDataFromCSV() {
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> search = new ArrayList<String>(100);
		 
		try {
			br = new BufferedReader(new FileReader(CommonPagesText.getString("AnyPage.CSVFilename")));
			
			while ((line = br.readLine()) != null) {
				search.add(line.split(cvsSplitBy)[0]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return search.toArray(new String[search.size()]);
		
	}
	
	public static String searchFor(WebDriver driver, By elementHandle, String searchString) {

		// Enter expected text in search text box
		waitForElement(driver, By.id(CommonPagesText.getString("AnyPage.SearchID"))).sendKeys(searchString);
		
		// search is dependent on starting page
		waitForElement(driver, elementHandle).click();

		return waitForElement(driver, By.id(CommonPagesText.getString("AnyPage.TitleID"))).getText();
	}
	
	public static String searchFor(WebDriver driver, String searchString) {
		return searchFor(driver, By.name(CommonPagesText.getString("AnyPage.GoSearchName")), searchString);
	}

}
