package com.selenium.wikitest.shared;

import java.util.Calendar;
import java.util.TimeZone;

public class CommonMethods {
	
	public static String formatAssertMessage(String expectedResult, String actualResult) {
		return "\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult;
	}
	
	public static String formatAssertMessage(String expectedResult, String actualResult, String id) {
		return "\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult +
				"\n\tID of dataItem:  " + id;
	}
	
	public static String getUniqueStringFromCurrentMilliseconds() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		return Long.toString(cal.getTimeInMillis());
	}

}
