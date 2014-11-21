package com.selenium.wikitest.wikipage.resultpage;

import com.selenium.wikitest.wikipage.WikiPage;

public class ResultPage extends WikiPage {
	
	public void openPage() {
		super.openPage("http://en.wikipedia.org/wiki/Selenium");
	}

}
