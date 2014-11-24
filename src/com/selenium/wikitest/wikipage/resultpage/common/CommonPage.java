package com.selenium.wikitest.wikipage.resultpage.common;

import com.selenium.wikitest.wikipage.resultpage.ResultPage;

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

}
