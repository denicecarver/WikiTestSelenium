package com.selenium.testng.wikitestrun;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class HomePageTestNGSuite {

	public static void main(String[] args)
	{
//		JUnitCore runner = new JUnitCore();
//		runner.addListener(new RunSuiteListener());
//		
//		runner.run(TestNGTestClasses.getHomePageTestNGTests());
		
		TestNG testng = new TestNG();
		testng.setTestClasses(TestNGTestClasses.getHomePageTestNGTests());
		testng.addListener(new TestListenerAdapter());
		testng.run();
	}

}
