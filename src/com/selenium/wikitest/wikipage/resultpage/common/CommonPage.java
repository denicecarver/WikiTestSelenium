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

}
