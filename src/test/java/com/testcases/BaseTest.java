package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.browser.Driver;
import com.reports.ExtentReport;
import com.reports.LogStatus;
import com.utils.CommonFunctionHelper;
import com.utils.PropertyFileHelper;

public class BaseTest {

	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome")String browserName) {
			Driver.initialize(browserName);
	}

	@AfterMethod
	public void wrapUp() {
		Driver.quit();
	}
		
	@BeforeSuite
	public void beforeSuite() throws Exception {
		ExtentReport.initialize();
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		ExtentReport.report.flush();
		CommonFunctionHelper.openReport();
	}

}
