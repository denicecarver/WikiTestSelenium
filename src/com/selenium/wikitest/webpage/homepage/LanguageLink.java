package com.selenium.wikitest.webpage.homepage;

public class LanguageLink {
	
	private String linkXPath = null;
	private String expectedResultTitle = null;
	
	public LanguageLink(String xPath, String expectedResult) {
		linkXPath = xPath;
		expectedResultTitle = expectedResult;
	}
	
	public LanguageLink(String[] link) {
		linkXPath = link[0];
		expectedResultTitle = link[1];
		System.out.println(expectedResultTitle);
		//char bs = '\\';
		//String testSlash = "a\tb\nc\\d";
		//System.out.println(testSlash);
		//expectedResultTitle = expectedResultTitle.replace("\\\\", "\\");
		System.out.println(expectedResultTitle);
	}
	
	public String getXPath() {
		return linkXPath;
	}
	
	public String getTitle() {
		return expectedResultTitle;
	}
	
	public String toString() {
		return linkXPath + ", " + expectedResultTitle;
	}

}
