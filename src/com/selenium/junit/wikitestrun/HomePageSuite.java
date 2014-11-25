package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

public class HomePageSuite {

	public static void main(String[] args)
	{
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		runner.run(TestClasses.getHomePageTests());
	}

}
