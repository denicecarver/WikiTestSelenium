package com.selenium.junit.wikitestrun;

import org.junit.runner.JUnitCore;

public class ResultPageSuite {

	public static void main(String[] args)
	{
		JUnitCore runner = new JUnitCore();
		runner.addListener(new RunSuiteListener());

		// For individual or group testing
		runner.run(TestClasses.getResultPageTests());
	}

}
