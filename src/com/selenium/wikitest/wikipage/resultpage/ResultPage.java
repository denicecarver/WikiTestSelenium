package com.selenium.wikitest.wikipage.resultpage;

import com.selenium.wikitest.wikipage.WikiPage;

public class ResultPage extends WikiPage {
	
	public void openPage() {
		super.openPage("https://www.wikipedia.org/");
		searchFor("selenium");
	}

}
