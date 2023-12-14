# Mobile Automation with Sauce Lab 

This repository contains code and instructions for performing mobile automation testing on saucelabs.apk.  Sauce Labs provides a cloud-based platform for automated testing of web and mobile applications.

## Table of Contents

1. [Getting Started](#getting-started)
2. [Installation](#installation)
3. [Project Structure](#project-structure)
4. [Test Scenarios](#test-scenarios)
   - [Login Test](#login-test)
   - [Product Browsing Test](#product-browsing-test)
   - [Shopping Cart Test](#shopping-cart-test)
   - [Overview Test](#overview-test)
   - [Confirmation Test](#confirmation-test)
5. [Running Tests](#running-tests)
6. [Reporting](#reporting)
7. [Contributing](#contributing)
8. [License](#license)

## Overview

This repository contains automated tests for the SauceLab mobile app. The tests cover login, product browsing, shopping cart management, and order confirmation. The test framework is built using Selenium and TestNG, and reports are generated using Allure.

## Getting Started

Follow these steps to set up and run mobile automation tests using Sauce Labs with Java.

### Prerequisites

- [Sauce Labs Account](https://saucelabs.com/)
- [Sauce Lab Mobile Application](https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk)
- [Appium](http://appium.io/) for mobile automation
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [TestNG](https://testng.org/doc/) for testing in Java
- Dependencies as per your chosen build tool (e.g., Maven or Gradle). Maven is used in this project.


### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/saucelabs-mobile-automation-java.git
   cd saucelabs-mobile-automation-java-
   ```
2. Install Allure Reports
   - Follow [office docs](https://allurereport.org/docs/gettingstarted-installation/) for installing Allure.
## Project Structure
   This project was created following the PAGE OBJECT MODEL(POM) design.
   
**src/main/java**

**pages**: Contains page classes representing different pages/screens of the SauceLab mobile app.</br>
**LoginPage.java**: Page class for the login page.
**HomePage.java**: Page class for the home page.
**CartPage.java**: Page class for the shopping cart page.
**OverviewPage.java**: Page class for the order overview page.
**ConfirmationPage.java**: Page class for the order confirmation page.
**tests: Test classes corresponding to different test scenarios.
LoginTest.java: Test class for the login functionality.
ProductBrowsingTest.java: Test class for product browsing and adding to the cart.
ShoppingCartTest.java: Test class for shopping cart management.
OverviewTest.java: Test class for the order overview page.
ConfirmationTest.java: Test class for the order confirmation page.
utilities: Utility classes, helper methods, and common functionalities.
DriverFactory.java: Class for initializing and managing the WebDriver instance.
ConfigReader.java: Class for reading configuration properties.
src/test/resources

testdata: Test data files or configuration files used in the tests.
users.json: JSON file containing login credentials.
src/test/java

listeners: TestNG listeners for capturing test results.
TestListener.java: Custom listener for capturing screenshots on test failure.
base: Base test class for setting up and tearing down test execution.
BaseTest.java: Base test class with common setup and teardown methods.
target

Compiled classes and generated reports.
testng.xml

TestNG configuration file specifying test suites and parameters.
pom.xml

Maven Project Object Model file with dependencies and plugins.

  
