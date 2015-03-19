package com.selenium.wikitest.data;

public class HomePageSearchStringDataItem {

	Integer searchID = new Integer(-1);
	String searchTerm = null;
	
	public HomePageSearchStringDataItem() {
	}
	
	public HomePageSearchStringDataItem(Integer searchID, String searchTerm) {
		this.searchID = searchID;
		this.searchTerm = searchTerm;
	}
	
	public int getSearchID() {
		return searchID;
	}
	
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public void setSearchID(int searchID) {
		this.searchID = searchID;
	}
	
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
}
