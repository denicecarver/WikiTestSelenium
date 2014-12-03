package com.selenium.wikitest.wikipage.resultpage.common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.selenium.wikitest.wikipage.resultpage.ResultPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CommonPage extends ResultPage {

	public String goToMainPageUsingIcon() {
		return clickProjectLinkByID("p-logo");
	}

	public String getMainPageIconTooltip() {
		return getTooltipByCSS("#p-logo > a");
	}

	public String goToMainPageUsingLink() {
		return clickProjectLink("Main page");
	}

	public String getMainPageLinkTooltip() {
		return getTooltipByLink("Main page");
	}

	public String goToContents() {
		return clickProjectLink("Contents");
	}

	public String getContentsTooltip() {
		return getTooltipByLink("Contents");
	}

	public String goToFeaturedContent() {
		return clickProjectLink("Featured content");
	}

	public String getFeaturedContentTooltip() {
		return getTooltipByLink("Featured content");
	}

	public String goToCurrentEvents() {
		return clickProjectLink("Current events");
	}

	public String getCurrentEventsTooltip() {
		return getTooltipByLink("Current events");
	}

	public String goToRandomArticle() {
		return clickProjectLink("Random article");
	}

	public String getRandomArticleTooltip() {
		return getTooltipByLink("Random article");
	}

	public String goToDonateToWikipedia() {
		return clickProjectLink("Donate to Wikipedia");
	}

	public String getDonateToWikipediaTooltip() {
		return getTooltipByLink("Donate to Wikipedia");
	}

	public String goToWikimediaShop() {
		return clickProjectLink("Wikimedia Shop");
	}

	public String getWikimediaShopTooltip() {
		return getTooltipByLink("Wikimedia Shop");
	}

	public String goToHelp() {
		return clickProjectLink("Help");
	}

	public String goToAboutWikipedia() {
		return clickProjectLink("About Wikipedia");
	}

	public String goToCommunityPortal() {
		return clickProjectLink("Community portal");
	}

	public String goToRecentChanges() {
		return clickProjectLink("Recent changes");
	}

	public String goToContactPage() {
		return clickProjectLink("Contact page");
	}

	public String reviewHelpTooltip() {
		return getTooltipByLink("Help");
	}

	public String reviewAboutWikipediaTooltip() {
		return getTooltipByLink("About Wikipedia");
	}

	public String reviewCommunityPortalTooltip() {
		return getTooltipByLink("Community portal");
	}

	public String reviewRecentChangesTooltip() {
		return getTooltipByLink("Recent changes");
	}

	public String reviewContactPageTooltip() {
		return getTooltipByLink("Contact page");
	}

	public String goToWhatLinksHere() {
		return clickProjectLink("What links here");
	}

	public String goToRelatedChanges() {
		return clickProjectLink("Related changes");
	}

	public String goToUploadFile() {
		return clickProjectLink("Upload file");
	}

	public String goToSpecialPages() {
		return clickProjectLink("Special pages");
	}

	public String goToPermanentLink() {
		return clickProjectLink("Permanent link");
	}

	public String goToPageInformation() {
		return clickProjectLink("Page information");
	}

	public String goToWikidataItem() {
		return clickProjectLink("Wikidata item");
	}

	public String goToCiteThisPage() {
		return clickProjectLink("Cite this page");
	}

	public String reviewWhatLinksHereTooltip() {
		return getTooltipByLink("What links here");
	}

	public String reviewRelatedChangesTooltip() {
		return getTooltipByLink("Related changes");
	}

	public String reviewUploadFileTooltip() {
		return getTooltipByLink("Upload file");
	}

	public String reviewSpecialPagesTooltip() {
		return getTooltipByLink("Special pages");
	}

	public String reviewPermanentLinkTooltip() {
		return getTooltipByLink("Permanent link");
	}

	public String reviewPageInformationTooltip() {
		return getTooltipByLink("Page information");
	}

	public String reviewWikidataItemTooltip() {
		return getTooltipByLink("Wikidata item");
	}

	public String reviewCiteThisPageTooltip() {
		return getTooltipByLink("Cite this page");
	}

	public void removeSeleniumBeggarPage() {
		closeAnyBeggarOverlay("http://en.wikipedia.org/wiki/Selenium");
	}

	public void getScreenshot() {
		WebDriver augmentedDriver = new Augmenter().augment(webDriver);
        File screenshot = ((TakesScreenshot)augmentedDriver).
                            getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(screenshot, new File("c:\\tmp\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
