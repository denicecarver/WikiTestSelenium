package com.selenium.wikitest.webpage.homepage.automatedtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDataLanguageLinks.class,
				TestDataRedirectFromHomePage.class,
				TestDataSearchFromHomePage.class,
				TestLanguageDisplay.class, TestLanguageLinks.class,
				TestOtherProjectLinks.class,
				TestSearchFromHomePage.class })
public class AllHomePageTests {

}
