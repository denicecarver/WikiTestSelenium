package com.selenium.wikitest.wikipage.resultpage.common.automatedtests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenium.wikitest.shared.CommonMethods;
import com.selenium.wikitest.wikipage.resultpage.common.CommonPage;
import com.thoughtworks.selenium.SeleneseTestBase;

public class ToolsNavigation {

	private static CommonPage commonPage = new CommonPage();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		commonPage.openPage();
	}
	
	@Test
	public void goToWhatLinksHere() {

		String expectedResult = "Pages that link to \"Selenium\" - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToWhatLinksHere();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));

	}
	
	@Test
	public void goToRelatedChanges() {

		String expectedResult = "Changes related to \"Selenium\" - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToRelatedChanges();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));

	}
	
	@Test
	public void goToUploadFile() {

		String expectedResult = "Wikipedia:File Upload Wizard - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToUploadFile();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToSpecialPages() {

		String expectedResult = "Special pages - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToSpecialPages();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToPermanentLink() {

		String expectedResult = "Selenium - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToPermanentLink();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToPageInformation() {

		String expectedResult = "Information for \"Selenium\" - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToPageInformation();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToWikidataItem() {

		String expectedResult = "selenium - Wikidata";
		String actualResult = commonPage.goToWikidataItem();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void goToCiteThisPage() {

		String expectedResult = "Cite This Page - Wikipedia, the free encyclopedia";
		String actualResult = commonPage.goToCiteThisPage();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}

	@Test
	public void reviewWhatLinksHereTooltip() {

		String expectedResult = "List of all English Wikipedia pages containing links to this page [Alt+Shift+j]";
		String actualResult = commonPage.reviewWhatLinksHereTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));

	}
	
	@Test
	public void reviewRelatedChangesTooltip() {

		String expectedResult = "Recent changes in pages linked from this page [Alt+Shift+k]";
		String actualResult = commonPage.reviewRelatedChangesTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.contains(expectedResult));

	}
	
	@Test
	public void reviewUploadFileTooltip() {

		String expectedResult = "Upload files [Alt+Shift+u]";
		String actualResult = commonPage.reviewUploadFileTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewSpecialPagesTooltip() {

		String expectedResult = "A list of all special pages [Alt+Shift+q]";
		String actualResult = commonPage.reviewSpecialPagesTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewPermanentLinkTooltip() {

		String expectedResult = "Permanent link to this revision of the page";
		String actualResult = commonPage.reviewPermanentLinkTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewPageInformationTooltip() {

		String expectedResult = "More information about this page";
		String actualResult = commonPage.reviewPageInformationTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewWikidataItemTooltip() {

		String expectedResult = "Link to connected data repository item [Alt+Shift+g]";
		String actualResult = commonPage.reviewWikidataItemTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

	}
	
	@Test
	public void reviewCiteThisPageTooltip() {

		String expectedResult = "Information on how to cite this page";
		String actualResult = commonPage.reviewCiteThisPageTooltip();
		SeleneseTestBase.assertTrue(
				CommonMethods.formatAssertMessage(expectedResult, actualResult),
				actualResult.equals(expectedResult));

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
