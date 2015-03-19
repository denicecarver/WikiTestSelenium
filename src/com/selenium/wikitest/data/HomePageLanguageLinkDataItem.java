package com.selenium.wikitest.data;

public class HomePageLanguageLinkDataItem {

	Integer linkID = 0;
	String xPath = null;
	String link = null;
	String title = null;

	public HomePageLanguageLinkDataItem() {
	}

	public HomePageLanguageLinkDataItem(Integer linkID, String xPath, String link, String title) {
		this.linkID = linkID;
		this.xPath = xPath;
		this.link = link;
		this.title = title;
	}
	
	public Integer getLinkID() {
		return linkID;
	}
	
	public String getXPath() {
		return xPath;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getTitle() {
		return title;
	}

	public void setLinkID(Integer linkID) {
		this.linkID = linkID;
	}
	
	public void setXPath(String xPath) {
		this.xPath = xPath;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

}
