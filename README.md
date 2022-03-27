# UI/Web Application Testing - Selenium Automation Framework
![Selenium Datadriven Framework](https://github.com/NisVek-Automation/NisVek-Automation/blob/main/readmeResources/JavaSeleniumDataDriven.gif)
Don't forget to give this project a ⭐
<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

## 📝 Table of Contents

- [About](#about)
- [Features](#features)
- [QA Documents](#document)
- [Technologies](#technologies)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Getting Started](#getting_started)
- [Project Design](#project-design)
- [Framework Structure](#framework-structure)
- [Logs and Reporting](#logs-reporting)
- [Limitations](#limitations)
- [Contributing](#contributing)
- [Authors](#author)

---

## 🕹 About <a name = "about"></a>

<p align="left"> 
This is an UI test Automation framework to start the automation testing using open source tools.
</p>

---

## ✨ Features <a name = "features"></a>

Features Supported by Framework :
- Capable for UI testing.
- Use testing data from Excel file for data driven testing.
- Separate log file for investigation of issue.
- Extent reporting with detail error and screenshots attached.
- Supports cross browsers Testing.
- Custom configuration for framework.

---

## ✨ QA documents <a name = "document"></a>

- Testcases : All positive and negetive test scenarios examples are vailable in `documents/Miro_E2E_TestCases.xlsx` file, sheetname is `Singup-US0001`.
- Test matrix : Examples of coverage in `documents/Miro_E2E_TestCases.xlsx` file, sheetname is `Singup-US0001`.
- Test HTML report : HTML report will be available inside the `reports` folder after execution.
- Test log report : Detailed log will be available inside the `logs/testLog.log` after execution.
- Test Screenshots : All testcases screenshots inside the `screenShots` folder in respective testcase folder.
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


All set!!! 

---

## 🔁 Dependencies <a name = "dependencies"></a>

Automation framework dependancies are mentioned in the <b>POM.xml</b> file, and are not limited to.

---

## 👩‍💻 Getting Started <a name = "getting_started"></a>

How to use this framework?
1. Clone the repository to your workspace.

```sh
git clone https://github.com/NisVek-Automation/Selenium-Java-TestNg-ExtentReport.git
```

2. The `DataSheet.xlsx` under the `src/test/resources` folder is used for data driven testing. 
3. Mark the 'y' in `exection` column to exceute that data set for testing.
4. Right click on the `TestNG.xml` file and Run as `TestNG Suite`. You can even run as `mvn test` which will trigger the TestNG.xml file.
5. Find the detailed log report in the `log/TestLog.log` file.
6. Find the Extent report in `reports` folder.
7. Find Screenshots for investigation in `screenShots` folder.

---

## 🏗️ Project Design <a name = "project-design"></a>
 ![Selenium Datadriven Framework](https://github.com/NisVek-Automation/Miro-Selenium-Java/blob/main/documents/Automation_Diagram.png)

---

## 🏗️ Framework Structure <a name = "framework-structure"></a>
![Framework](https://github.com/NisVek-Automation/Selenium-Java-TestNg-ExtentReport/blob/main/documents/AutomationFramework.jpg)


 ### 📚 Reusable framework utilitites
 
 <h5>src/main/java/com/browser</h5>
  
| Files     | Description |
| ---         | ---       |
| BrowserManager.java | Parent abstract class for browsers.         |
| ChromeBrowser.java | Represents a Google Chrome Browser related activities.         |
| EdgeBrowser.java     | Represents an Edge Browser related activities.   |
| DriverManager.java    | Handles the thread local for the Webdriver type.    |
| Driver.java    | Used for selecting browser type, open the URL activities, etc.    |

<h5>src/main/java/com/constants</h5>
  
| Files     | Description |
| ---         | ---       |
| AppConstant.java |  Represents application specific property/constant values.        |
| FrameworkConstant.java |  Represents framework specific property/constant values.        |

<h5>src/main/java/com/utils</h5>
  
| Files     | Description |
| ---         | ---       |
| SeleniumFunctionHelper.java     | Common functionality for framework such as click, enter data in field, etc.    |
| PropertyFileHelper.java    | Represents the property file reader.  |
| ExceptionHelper.java | Exception helper to create the custom exception.        |
| ExcelSheetHelper.java     | Read the test data from excel file for testing.   |
| CommonFunctionHelper.java    | Common functionality for framework such as takescreenshot, etc.    |

<h5>src/main/java/com/pages</h5>
  
| Files     | Description |
| ---         | ---       |
| BasePage.java |  Represents POM parent class.         |
| HomePage.java     |  Represent POM for Home page.  |
| LoginPage.java  |  Represents Login page - Page Object model class  |
| SignupPage.java    | Represent Signup page. - Page Object model class    |
| SignUpWithSocialPage.java    | Represent POM for all social Signup activities.  |


<h5>src/main/java/com/listeners</h5>
  
| Files     | Description |
| ---         | ---       |
| AnnotationTransformer.java |  Represents annotation transformer which helps during rerun the test cases.        |
| ListenerClass.java |  Represents a ListenerClass derived from ITestListener.        |
| RetryFailedTestCases.java     | Represents how many time failure tests need to rerun |
  
  
<h5>src/main/java/com/reports</h5>
  
| Files     | Description |
| ---         | ---       |
| ExtentManager.java |  Handles the thread local for the ExtentTest type.         |
| LogStatus.java     |  Provides log in report and log file.  |
| ExtentReport.java    |  ExtentReport functionality.  |
  

### ⏳ Application under Testcases ⌛
  
  <h5>src/test/java/testcases</h5>
  
| Files     | Description |
| ---         | ---       |
| BaseTest.java |  Parent class of testcases.        |
| SignUpTest.java     |  Signup related testcases.  |
| SignupUsingSocialTest.java     |  Signup process with social related testcases.  |


### 📉Configuration and 📋Test Datasheet
  
  <h5>src/test/resources</h5>
  
| Files     | Description |
| ---         | ---       |
| TestData.xlsx |  Testcases use the data for testing from here.        |
| extentreport.xml   |  ExtentReport settings. |
| log4j2.properties |  log4j settings.        |
| TestRunDetails.properties     |  Framework related settings.  |

---

##  👀 Logs and Reporting <a name = "logs-reporting"></a>

 <h5>Where to find the log and Reporting?</h5>
  
| Folder/File     | Description |
| ---         | ---       |
| logs/TestLog.log |  Detailed execution log.        |
| reports/Extent-TestReport.html  |  Execution Extent report in HTML. |
| screenShots/TestCaseName/ |  Each testcases screenshots available in respective testcase name folder       |

Note: For understanding purpose, all above files avaialbe in this repository.

---
  
## ✨ Limitations <a name = "limitations"></a>

- Device testing such as Mobile/Tablet.
- Parallel testing.

---

## 💬 Contributing <a name = "contributing"></a>

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

---

## ✍️ Author <a name = "author"></a>

- [@NisVek-Automation](https://www.linkedin.com/in/nisha-vekariya/) - Nisha Vekariya
