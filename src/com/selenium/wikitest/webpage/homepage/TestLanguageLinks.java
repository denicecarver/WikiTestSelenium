package com.selenium.wikitest.webpage.homepage;

import com.thoughtworks.selenium.SeleneseTestBase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLanguageLinks {

	private static HomePage homePage = new HomePage(new FirefoxDriver());
	
	@BeforeClass
	public static void testSetup() {
		homePage.openPage();
	}
	
	@Test
	public void testEnglishLink() {
		String actualResult = homePage.goToProjectLink("HomePage.WiktionaryProject");
		String expectedResult = (HomePageText.getString("HomePage.WiktionaryProject")).toLowerCase();
		SeleneseTestBase.assertTrue(actualResult.contains(expectedResult));
	}

}
