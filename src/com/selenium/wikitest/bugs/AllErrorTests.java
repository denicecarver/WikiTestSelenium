package com.selenium.wikitest.bugs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PrivacyPolicyError.class, SearchError.class })
public class AllErrorTests {

}
