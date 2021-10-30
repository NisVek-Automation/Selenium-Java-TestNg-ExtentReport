# Selenium Datadriven Framework - UI Testing
![Selenium Datadriven Framework](https://github.com/NisVek-Automation/NisVek-Automation/blob/main/JavaSeleniumDataDriven4.gif)

Don't forget to give this project a ⭐
<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

## 📝 Table of Contents

- [About](#about)
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Getting Started](#getting_started)
- [Framework Structure](#framework-structure)
- [Logs and Reporting](#logs-reporting)
- [Contributing](#contributing)
- [Authors](#author)

---

## 🕹 About <a name = "about"></a>

<p align="left"> 
This is a UI test Automation framework to start the automation testing using open source tools.
</p>

---

## ✨ Features <a name = "features"></a>

Features Supported by Framework :
1. Capable for UI testing.
2. Use testing data from Excel file for data driven testing.
3. Separate log file for investigation of issue
4. Extent reporting with detail error and screenshots attached.
5. Sending mail after test suite run.
6. Custom configuration for framework.

---
  
## 🖥️ Technologies <a name = "technologies"></a>

- [Selenium](https://www.selenium.dev/)
- [Java](https://www.java.com/en/)
- [TestNG](https://testng.org/doc/)
- [Maven](https://maven.apache.org/)
- [log4j](https://logging.apache.org/log4j/2.x/)
- [Extent Reports](https://www.extentreports.com/)
- Page Object Model

---

## ⚙️ Installation <a name = "installation"></a>

#### 🎯 Prerequisite:

- [Java](https://www.java.com/en/download/help/index_installing.html) - Programming language
- [Eclipse](https://www.eclipse.org/downloads/) - Editor
- [Maven](https://maven.apache.org/index.html) - Software project Management tool

#### 🔌 Plugins:

- [TestNG for Eclipse Plugin](https://testng.org/doc/eclipse.html)
- [Maven Integration for Eclipse](https://marketplace.eclipse.org/content/maven-integration-eclipse-luna-and-newer)


All set!!! Just download the Project folder...

---

## 🔁 Dependencies <a name = "dependencies"></a>

Automation framework dependancies are mentioned in the <b>POM.xml</b> file, and are not limited to.

---

## 👩‍💻 Getting Started <a name = "getting_started"></a>

How to use this framework?
1. Clone the repository to your workspace.

```sh
git clone https://github.com/NisVek-Automation/Selenium-Java-TestNG-POM-DataDrivenFramework.git
```

2. The DataSheet.xlsx under the src/test/resources folder contains data driven testing
3. Run the TestNG.xml file. You can even run as mvn test which will trigger the TestNG.xml

---

## 🏗️ Framework Structure <a name = "framework-structure"></a>
 
 ### 📚 Reusable framework utilitites
 
 <h5>./src/main/java/com/browsers</h5>
  
| Files     | Description |
| ---         | ---       |
| BrowserFactory | Represents Factory design pattern for the Browsers         |
| BrowserManager | Represents a Browsers Parent abstract class         |
| ChromeBrowser     | Represents the Chrome browsers functionality   |
| FirefoxBrowser    | Represents the Firefox browsers functionality    |
| DriverManager    | Represents Driver setting and getting    |


<h5>src/main/java/com/listener</h5>
  
| Files     | Description |
| ---         | ---       |
| AnnotationTransformer |  Represents test annotation transformer listener        |
| ListenerClass |  Represents a Listner derived from ITestListener        |
| RetryFailedTestCases     | Represents how many time failure tests need to rerun |
| WebEventListener    |  Represents log the webdriver related UI activities   |
  
<h5>./src/main/java/com/pages/</h5>
  
| Files     | Description |
| ---         | ---       |
| BasePageObject |  Represents a PageObject model Parent class         |
| HomePage     |  Represents Home page - Page Object model class  |
| LoginPage    |  Represents Login page - Page Object model class  |
| ProductPage    | Represents Product page - Page Object model class    |
  
<h5>./src/main/java/com/reports/</h5>
  
| Files     | Description |
| ---         | ---       |
| ExtentManager |  Represents ExtentManager setting and getting         |
| ExtentReport     |  Represents ExtentReport related activities  |
| LogStatus    |  Represents Logging activities for Extent, log4j and TestNG report  |
  
<h5>./src/main/java/com/utils/</h5>
  
| Files     | Description |
| ---         | ---       |
| CommonFunctionHelper     | Represents basic framework activities such as sending mail, take screenshots, etc.    |
| ConstantHelper    | Represents framework specific property/constant values  |
| ExcelSheetHelper | Represents a Excelsheet helper to read the Testing data for datadriven        |
| ExceptionHelper     | Represents custom exception helper   |
| ReadPropertyFileHelper    | Represents the property file reader to read the framework settings   |
| SelniumFunctionHelper    | Represents the selenium functionalities    |
  

### ⏳ Application under Testcases ⌛
  
  <h5>./src/test/java/TestCases/</h5>
  
| Files     | Description |
| ---         | ---       |
| BaseTest |  Represent TestCases Parent class        |
| LoginProcess     |  Represent TestCases for Login process.  |


### 📉Configuration and 📋Test Datasheet
  
  <h5>./src/test/resources/</h5>
  
| Files     | Description |
| ---         | ---       |
| DataSheet.xlsx |  To store the Datadriven testing data        |
| extentreport.xml   |  ExtentReport configuration file for extent reporting|
| log4j2.properties |  log4j configuration file for logging perpose        |
| TestRunDetails.properties     |  Setting to run the framework use friendly  |

---

##  👀 Logs and Reporting <a name = "logs-reporting"></a>

 <h5>Where to find the log and Reporting?</h5>
  
| Folder/File     | Description |
| ---         | ---       |
| ./logs/TestLog.log |  Detailed log is available in logs folder        |
| ./reports/Extent-TestReport.html   |  Detailed html report is available in reports folder |
| ./screenShots/<TestCaseName>/ |  Each testcases screenshots available in respective testcase name folder       |

Note: For understanding purpose, all above files avaialbe in this repository.

---

## 💬 Contributing <a name = "contributing"></a>

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

---

## ✍️ Author <a name = "author"></a>

- [@NisVek-Automation](https://www.linkedin.com/in/nisha-vekariya/) - Nisha Vekariya
