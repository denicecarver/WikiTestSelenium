package com.selenium.wikitest.shared;

public class CommonMethods {
	
	public static String formatAssertMessage(String expectedResult, String actualResult) {
		return "\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult;
	}

}
