	package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.reporting.ExtentManager;
import com.reporting.ExtentReport;
import com.reporting.Log;
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
public class ListenerClass implements ITestListener, ISuiteListener {

	private static String TestcaseName;
	
	/**
	 * This function will call once Suite starts and helps for following activities.
	 * <br>
	 * 1. Initialize the Extent report.
	 */
	public void onStart(ISuite suite) {
		Log.logInfo("****************** Suite : " + suite.getName() + " is started." + " ******************");
		ExtentReport.initialize();
	}
	
	/**
	 * This function will call once Suite execution finished and helps for following
	 * activities. <br>
	 * 1. Open the execution report automatically if wanted.<br>
	 * 2. Flush out the report.
	 */
	public void onFinish(ISuite suite) {
		ExtentReport.report.flush();
		CommonFunctionHelper.openReport();
		Log.logInfo("****************** Suite : " + suite.getName() + " is finished." + " ******************");
	}
	
	// This will execute before the main test start (@Test)
	public void onTestStart(ITestResult result) {
		TestcaseName = result.getName();
		ExtentManager.setExtentTest(ExtentReport.report.startTest(TestcaseName));
		Log.pass("********** " + TestcaseName + " is started successfully. **********", true);
	}

	// This will execute only when the test is pass
	public void onTestSuccess(ITestResult result) {
		Log.pass("TestCase is passed : " + TestcaseName, false);
		ExtentReport.report.endTest(ExtentManager.getExtTest());
		Log.pass("********** " + TestcaseName + " is successful. **********", true);
	}

	// This will execute only on the event of fail test
	public void onTestFailure(ITestResult result) {
		Log.fail("TestCase is failed : " + TestcaseName, false);
		Log.fail(result.getThrowable().getMessage());
		ExtentReport.report.endTest(ExtentManager.getExtTest());
		Log.fail("********** " + TestcaseName + " is not successful. **********", true);

	}

	// This will execute only if any of the test(@Test) get skipped
	public void onTestSkipped(ITestResult result) {
		Log.skip("TestCase is skipped : " + TestcaseName);
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
