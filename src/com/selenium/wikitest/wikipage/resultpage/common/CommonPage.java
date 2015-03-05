package com.selenium.wikitest.wikipage.resultpage.common;

import com.selenium.wikitest.wikipage.resultpage.ResultPage;

public class CommonPage extends ResultPage {
	
	public static final String mainPageIconID = Messages.getString("CommonPage.WikiIconID");
	public static final String mainPageIconCSS = Messages.getString("CommonPage.WikiIconCSS");
	public static final String mainPageLink = Messages.getString("CommonPage.LinkToMainPage");
	public static final String contentsLink = Messages.getString("CommonPage.ContentsLink");
	public static final String featuredContentLink = Messages.getString("CommonPage.FeaturedContentLink");
	public static final String currentEventsLink = Messages.getString("CommonPage.CurrentEventsLink");
	public static final String randomLink = Messages.getString("CommonPage.RandomLink");
	public static final String donateLink = Messages.getString("CommonPage.DonateLink");
	public static final String wikiMediaShopLink = Messages.getString("CommonPage.WikiMediaShopLink");
	public static final String helpLink = Messages.getString("CommonPage.HelpLink");
	public static final String aboutLink = Messages.getString("CommonPage.AboutLink");
	public static final String communityPortalLink = Messages.getString("CommonPage.CommunityPortalLink");
	public static final String recentChangesLink = Messages.getString("CommonPage.RecentChangesLink");
	public static final String contactLink = Messages.getString("CommonPage.ContactLink");
	public static final String linksToHereLink = Messages.getString("CommonPage.LinksToHereLink");
	public static final String relatedChangesLink = Messages.getString("CommonPage.RelatedChangesLink");
	public static final String uploadFileLink = Messages.getString("CommonPage.UploadFileLink");
	public static final String specialPagesLink = Messages.getString("CommonPage.SpecialPagesLink");
	public static final String pageInfoLink = Messages.getString("CommonPage.PageInfoLink");
	public static final String permanentLink = Messages.getString("CommonPage.PermanentLink");
	public static final String wikidataItemLink = Messages.getString("CommonPage.WikidataItemLink");
	public static final String citeThisPageLink = Messages.getString("CommonPage.CiteThisPageLink");
	public static final String seleniumContentURL = Messages.getString("CommonPage.SeleniumContentURL");

	public String goToMainPageUsingIcon() {
		return clickProjectLinkByID(mainPageIconID);
	}

	public String getMainPageIconTooltip() {
		return getTooltipByCSS(mainPageIconCSS);
	}

	public String goToMainPageUsingLink() {
		return clickProjectLink(mainPageLink);
	}

	public String getMainPageLinkTooltip() {
		return getTooltipByLink(mainPageLink);
	}

	public String goToContents() {
		return clickProjectLink(contentsLink);
	}

	public String getContentsTooltip() {
		return getTooltipByLink(contentsLink);
	}

	public String goToFeaturedContent() {
		return clickProjectLink(featuredContentLink);
	}

	public String getFeaturedContentTooltip() {
		return getTooltipByLink(featuredContentLink);
	}

	public String goToCurrentEvents() {
		return clickProjectLink(currentEventsLink);
	}

	public String getCurrentEventsTooltip() {
		return getTooltipByLink(currentEventsLink);
	}

	public String goToRandomArticle() {
		return clickProjectLink(randomLink);
	}

	public String getRandomArticleTooltip() {
		return getTooltipByLink(randomLink);
	}

	public String goToDonateToWikipedia() {
		return clickProjectLink(donateLink);
	}

	public String getDonateToWikipediaTooltip() {
		return getTooltipByLink(donateLink);
	}

	public String goToWikimediaShop() {
		return clickProjectLink(wikiMediaShopLink);
	}

	public String getWikimediaShopTooltip() {
		return getTooltipByLink(wikiMediaShopLink);
	}

	public String goToHelp() {
		return clickProjectLink(helpLink);
	}

	public String goToAboutWikipedia() {
		return clickProjectLink(aboutLink);
	}

	public String goToCommunityPortal() {
		return clickProjectLink(communityPortalLink);
	}

	public String goToRecentChanges() {
		return clickProjectLink(recentChangesLink);
	}

	public String goToContactPage() {
		return clickProjectLink(contactLink);
	}

	public String reviewHelpTooltip() {
		return getTooltipByLink(helpLink);
	}

	public String reviewAboutWikipediaTooltip() {
		return getTooltipByLink(aboutLink);
	}

	public String reviewCommunityPortalTooltip() {
		return getTooltipByLink(communityPortalLink);
	}

	public String reviewRecentChangesTooltip() {
		return getTooltipByLink(recentChangesLink);
	}

	public String reviewContactPageTooltip() {
		return getTooltipByLink(contactLink);
	}

	public String goToWhatLinksHere() {
		return clickProjectLink(linksToHereLink);
	}

	public String goToRelatedChanges() {
		return clickProjectLink(relatedChangesLink);
	}

	public String goToUploadFile() {
		return clickProjectLink(uploadFileLink);
	}

	public String goToSpecialPages() {
		return clickProjectLink(specialPagesLink);
	}

	public String goToPermanentLink() {
		return clickProjectLink(permanentLink);
	}

	public String goToPageInformation() {
		return clickProjectLink(pageInfoLink);
	}

	public String goToWikidataItem() {
		return clickProjectLink(wikidataItemLink);
	}

	public String goToCiteThisPage() {
		return clickProjectLink(citeThisPageLink);
	}

	public String reviewWhatLinksHereTooltip() {
		return getTooltipByLink(linksToHereLink);
	}

	public String reviewRelatedChangesTooltip() {
		return getTooltipByLink(relatedChangesLink);
	}

	public String reviewUploadFileTooltip() {
		return getTooltipByLink(uploadFileLink);
	}

	public String reviewSpecialPagesTooltip() {
		return getTooltipByLink(specialPagesLink);
	}

	public String reviewPermanentLinkTooltip() {
		return getTooltipByLink(permanentLink);
	}

	public String reviewPageInformationTooltip() {
		return getTooltipByLink(pageInfoLink);
	}

	public String reviewWikidataItemTooltip() {
		return getTooltipByLink(wikidataItemLink);
	}

	public String reviewCiteThisPageTooltip() {
		return getTooltipByLink(citeThisPageLink);
	}

}
