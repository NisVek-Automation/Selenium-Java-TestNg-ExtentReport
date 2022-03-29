package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.browser.Driver;
import com.reporting.ExtentReport;
import com.reporting.Log;
import com.utils.CommonFunctionHelper;
import com.utils.ExcelSheetHelper;
import com.utils.PropertyFileHelper;

/**
 * Represents super class of testcases.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class BaseTest {

	/**
	 * Set up process such us browser initialization and open.
	 * @param browserName -> browser name from xml file
	 */
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome")String browserName) {
			Driver.initialize(browserName);
	}

	/** Wrapup process such as closing and quieting the browser. */
	@AfterMethod
	public void wrapUp() {
		Driver.quit();
	}
	
	/**
	 * The dataprovider method collects data from ExcelSheet.
	 * @return testRecords -> It returns 2D string object which contains data
	 *         from ExcelSheet.
	 */
	@DataProvider(name = "signupDataProvider")
	public String[][] signupDataProvider() {
		ExcelSheetHelper helper = new ExcelSheetHelper();
		String[][] testRecords = helper.getDataFromSheet("SignUpTest");
		return testRecords;
	}

}
