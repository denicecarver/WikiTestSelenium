WikiTestSelenium
=============================================================
There are currently over 500 tests.

For details on how to setup this project,
see the HowToDeploy.txt file.

This is a simple set of Selenium tests. Testing a
small portion of the Wikipedia website.  The tests
are written in Java and use JUnit for reporting.
The IDE I used was Eclipse.

Some Useful Features:
Data-driven tests
Use of a SQLite database using the try-as-a-resource feature of Java 1.8
Tests are organized into suites using the JUnit 4.11 suite feature
Modeling with the Page Object model
Basic use of OOP concepts with examples of encapsulation, abstraction, inheritance, and polymorphism

To Install
=============================================================
Install these products in order, versions will likely be out of date but you should get the latest:
	Firefox 33.1.1
		Found at https://www.mozilla.org/en-US/firefox/new/
	Java SE 8u25
		Found at http://www.oracle.com/technetwork/articles/javase/index-jsp-138363.html
	JUnit 4.11
		Found at https://github.com/junit-team/junit/wiki/Download-and-Install
	Hamcrest 1.3
		Found at https://code.google.com/p/hamcrest/downloads/list
	Selenium 2.44.0 (update)
		Found at http://www.seleniumhq.org/download/
	SQLite 3.8.7.1
		Found at https://bitbucket.org/xerial/sqlite-jdbc/downloads
	Eclipse Version: Kepler Service Release 2, Build id: 20140224-0627
		Found at https://www.eclipse.org/downloads/
	Eclipse Add-Ins  In Eclipse menu under: Help | Eclipse Marketplace...
		Eclipse Java 8 Support (for Kepler SR2) JDT, PDE, 1.0.0
		Java 8 support for Eclipse Kepler SR2
		
Create a java project (File | New | Java Project)
Add a source directory (File | New | Source Folder)
Add the following packages (File | New | Package)
	com.selenium.wikitest.bugs
	com.selenium.wikitest.shared
	com.selenium.wikitest.webpage
	com.selenium.wikitest.webpage.homepage
	com.selenium.wikitest.webpage.homepage.automatedtests
	com.selenium.wikitest.webpage.homepage.data
Right-click on project, select Properties
Click on Java Build Path
Click on Libraries tab
Click on the Add External JARs... button
Add all jars downloaded above (JUnit, Hamcrest, Selenium, and SQLite)
Go to http://github.com/doncarver/WikiTestSelenium click the Download ZIP button
Drag and drop .java files from the zip into the appropriate packages in Eclipse

Open the file HomePageSuite.java
	From the package com.selenium.junit.wikitestrun
Run suites from the menu (Run | Run)
Or, for a quick run of a single test use TestLanguageDisplay.java
	From the package:  com.selenium.wikitest.webpage.homepage.automatedtests
Run individual tests from the menu (Run | Run As | JUnit Test)


Next development steps:
=============================================================
	1. Use Java's try-with-resources statement when handling close for database (complete)
	2. Write a how-to guide for setting up this system from scratch (begun)
		a. Where to get the tools (Latest Java, Selenium, JUnit, Eclipse, Hamcrest?)
		b. How to setup a "Java Build Path" in Eclipse
		c. How to use the JUnit framework
			i. How to manually run automation (a first test run)
			ii. How to review reports on a test run
			iii. How to auto-start a test run
	3. Design a tool for running tests in batches or individually
	4. Consider a UI/batch system for running tests
	5. Develop a Utility class for maintenance tasks such as: (begun)
		a. Building tables
		b. Rebuilding tables
		c. Restoring existing tables
	6. Cross-browser testing
		a. Firefox
		b. Chrome
		c. Internet Explorer
		d. Safari
	7. Explore options for mobile testing

Required JUnit Functionality:
=============================================================
	1. Count all data-driven tests uniquely (complete)
	1. Running desired tests - one, selected, all (begun)
	2. Reporting/Recording test results
	3. Automated kick-off for continuous build cycles
	
Overall Framework expectations:
=============================================================
	1. Includes:
		a. function libraries
		b. test data sources
		c. object details and various reusable modules
	2. Low maintenance - changes to test scripts do not require driver Script and startup script changes
	3. Reporting mechanism
	4. Execution mechanism
	5. Browser selection
