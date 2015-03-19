package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

public class AllSuites {

	public static void main(String[] args)
	{
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());
		
		// For individual or group testing
		runner.run(TestNGTestClasses.getAllTests());
	}

}
