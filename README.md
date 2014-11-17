WikiTestSelenium
================
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


Next steps:
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
	1. Count all data-driven tests uniquely (complete)
	1. Running desired tests - one, selected, all (begun)
	2. Reporting/Recording test results
	3. Automated kick-off for continuous build cycles
	
Framework expectations:
	1. Includes:
		a. function libraries
		b. test data sources
		c. object details and various reusable modules
	2. Low maintenance - changes to test scripts do not require driver Script and startup script changes
	3. Reporting mechanism
	4. Execution mechanism
	5. Browser selection
