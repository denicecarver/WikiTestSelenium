WikiTestSelenium
================
This is a simple set of Selenium tests. They
test Wikipedia and use JUnit for reporting.
There are some SQLite, data-driven tests included.

Next steps:
	1. Write a how-to guide for setting up this system from scratch
		a. Where to get the tools (Latest Java, Selenium, JUnit, Eclipse, Hamcrest?)
		b. How to setup a "Java Build Path" in Eclipse
		c. How to use the JUnit framework
			i. How to manually run automation (a first test run)
			ii. How to review reports on a test run
			iii. How to auto-start a test run
	2. Design a tool for running tests in batchs or individually
	3. Consider a browser-based UI
	4. Develop a Utility class for maintenance tasks such as:
		a. Building tables
		b. Rebuilding tables
		c. Restoring existing tables

Required JUnit Functionality
	1. Running desired tests - one, selected, all
	2. Reporting/Recording test results
	3. Automated kick-off for continuous build cycles