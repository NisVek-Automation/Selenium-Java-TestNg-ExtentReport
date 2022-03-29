package com.constants;

import java.io.File;
import java.time.Duration;
import java.util.Random;

/**
 * Represents framework specific property/constant values.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public final class FrameworkConstant {

	// Project root directory
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String RESOURCE_PATH = PROJECT_PATH + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator;

	// Property file
	public static final String PROPERTYFILE_PATH = RESOURCE_PATH + "TestRunDetails.properties";

	// ExcelSheet file path - Data Handling
	public static final String DATASHEETFILE_PATH = RESOURCE_PATH + "TestData.xlsx";

	// Wait timing
	public static final Duration WAIT_TIME = Duration.ofMillis(13000);
	public static final int EXPLICIT_MAXWAIT = 10;
	public static final int EXPLICIT_MINWAIT = 2;
	
	// Screenshot paths
	public static final String SCREENSHOT_PATH = PROJECT_PATH + File.separator + "screenShots" + File.separator;
	public static final String testCaseScreenShotPath(String testCaseName) {
		return SCREENSHOT_PATH + testCaseName + File.separator + System.currentTimeMillis() + new Random().nextInt(20) + ".png";
	}
	public static final String testCaseScreenShotPath(String testCaseName, String selectedPath) {
		return selectedPath + File.separator + "screenShots" + File.separator + testCaseName + File.separator
				+ System.currentTimeMillis() + new Random().nextInt(20) + ".png";
	}

	// Extent reporting
	public static final String EXTENTREPORT_PATH = PROJECT_PATH + File.separator + "report" + File.separator;
	public static final String EDIT_EXTENTREPORT_PATH = EXTENTREPORT_PATH + "Extent-TestReport.html";
	public static final String EXTENT_CONFIG_PATH = RESOURCE_PATH + "extentreport.xml";
	public static final String newExtentReportPath(String currentDate) {
		return EXTENTREPORT_PATH + "Extent-TestReport-" + currentDate + ".html";
	}
	public static final String REPORT_TITLE = "Test Report";
	public static final String AUTHOR = "Nisha Vekariya";
	public static final String ENVIRONMENT = "QA";
	
	public static final String YES = "yes";
	
	//Wait timing
	
}
