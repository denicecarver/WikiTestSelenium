package com.selenium.wikitest.wikipage.resultpage.common.automatedtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenium.wikitest.wikipage.resultpage.common.CommonPage;
import com.thoughtworks.selenium.SeleneseTestBase;

public class InteractionNavigation {

	private static CommonPage commonPage = new CommonPage();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		commonPage.openPage();
	}
	
	@Test
	public void goToHelp() {

		String expectedResult = "Help:Contents - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToHelp();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToAboutWikipedia() {

		String expectedResult = "Wikipedia:About - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToAboutWikipedia();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToCommunityPortal() {

		String expectedResult = "Wikipedia:Community portal - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToCommunityPortal();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToRecentChanges() {

		String expectedResult = "Recent changes - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToRecentChanges();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToContactPage() {

		String expectedResult = "Wikipedia:Contact us - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToContactPage();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewHelpTooltip() {

		String expectedResult = "Guidance on how to use and edit Wikipedia";
		String actualResult = commonPage.reviewHelpTooltip();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewAboutWikipediaTooltip() {

		String expectedResult = "Find out about Wikipedia";
		String actualResult = commonPage.reviewAboutWikipediaTooltip();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewCommunityPortalTooltip() {

		String expectedResult = "About the project, what you can do, where to find things";
		String actualResult = commonPage.reviewCommunityPortalTooltip();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewRecentChangesTooltip() {

		String expectedResult = "A list of recent changes in the wiki [Alt+Shift+r]";
		String actualResult = commonPage.reviewRecentChangesTooltip();
		SeleneseTestBase.assertTrue(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewContactPageTooltip() {

		String expectedResult = " ";
		String actualResult = commonPage.reviewContactPageTooltip();
		
		// There is no tooltip for the "Contact page" link
		// This is a dummy test in case a tooltip is added.
		// If one is added, this will likely fail
		SeleneseTestBase.assertFalse(
				"\n\tExpected Value: " + expectedResult +
				"\n\tActual Value:  " + actualResult,
				actualResult.contains(expectedResult));

	}

	@After
	public void tearDown() throws Exception {
		commonPage.openPage();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		commonPage.closeBrowser();
	}

}
