	package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.reports.LogStatus;
import com.utils.CommonFunctionHelper;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGMethod;

/**
 * Represents a ListenerClass derived from ITestListener.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ListenerClass implements ITestListener {

	private static String TestcaseName;
	
	// This will execute before the main test start (@Test)
	public void onTestStart(ITestResult result) {
		TestcaseName = result.getMethod().getDescription();
		ExtentManager.setExtentTest(ExtentReport.report.startTest(TestcaseName));
		LogStatus.pass("********** " + TestcaseName + " is started successfully. **********", true);

	}

	// This will execute only when the test is pass
	public void onTestSuccess(ITestResult result) {
		LogStatus.pass(result.getMethod().getDescription() + " test case is passed.", false);
		ExtentReport.report.endTest(ExtentManager.getExtTest());
		LogStatus.pass("********** " + TestcaseName + " is successful. **********", true);
	}

	// This will execute only on the event of fail test
	public void onTestFailure(ITestResult result) {
		LogStatus.fail(result.getMethod().getDescription() + " is failed.", false);
		LogStatus.fail(result.getThrowable().getMessage());
		ExtentReport.report.endTest(ExtentManager.getExtTest());
		LogStatus.fail("********** " + TestcaseName + " is not successful. **********", false);

	}

	// This will execute only if any of the test(@Test) get skipped
	public void onTestSkipped(ITestResult result) {
		LogStatus.skip(result.getMethod().getDescription() + " is skipped");
		ExtentReport.report.endTest(ExtentManager.getExtTest());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentReport.report.endTest(ExtentManager.getExtTest());
	}

	// This will execute, once the Test set/batch is finished
	public void onFinish(ITestContext context) {
		ExtentReport.report.endTest(ExtentManager.getExtTest());

	}

	// This will execute before starting of Test set/batch
	public void onStart(ITestContext arg0) {
		// LogStatus.info("Test started : " + arg0.getName());
	}
	
	public static String getTestcaseName() {
		return TestcaseName;
	}

}
