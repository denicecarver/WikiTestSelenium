WikiTestSelenium
================
This is a simple set of Selenium tests. They
test Wikipedia and use JUnit for reporting.
There are some SQLite, data-driven tests included.

Next steps:
	1. Use Java's try-with-resources statement when handling close for database
	2. Write a how-to guide for setting up this system from scratch
		a. Where to get the tools (Latest Java, Selenium, JUnit, Eclipse, Hamcrest?)
		b. How to setup a "Java Build Path" in Eclipse
		c. How to use the JUnit framework
			i. How to manually run automation (a first test run)
			ii. How to review reports on a test run
			iii. How to auto-start a test run
	3. Design a tool for running tests in batches or individually
	4. Consider a browser-based UI
	5. Develop a Utility class for maintenance tasks such as:
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
	1. Running desired tests - one, selected, all
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
