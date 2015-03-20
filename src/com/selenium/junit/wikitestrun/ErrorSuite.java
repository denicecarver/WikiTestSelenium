package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

import com.selenium.testng.wikitestrun.TestNGTestClasses;

public class ErrorSuite {

	public static void main(String[] args)
	{
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(JUnitTestClasses.getErrorTests());
	}

}
