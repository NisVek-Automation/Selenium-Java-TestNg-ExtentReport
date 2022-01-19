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
	public static final String projectPath = System.getProperty("user.dir");
	public static final String resourcePath = projectPath + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator;

	// Property file
	public static final String propertyFilePath = resourcePath + "TestRunDetails.properties";

	// ExcelSheet file path - Data Handling
	public static final String DataSheetFileName = resourcePath + "TestData.xlsx";

	// Wait timing
	public static final Duration waitTime = Duration.ofMillis(13000);
	
	// Screenshot paths
	public static final String screenShotPath = projectPath + File.separator + "screenShots" + File.separator;
	public static final String testCaseScreenShotPath(String testCaseName) {
		return screenShotPath + testCaseName + File.separator + System.currentTimeMillis() + new Random().nextInt(20) + ".png";
	}
	public static final String testCaseScreenShotPath(String testCaseName, String selectedPath) {
		return selectedPath + File.separator + "screenShots" + File.separator + testCaseName + File.separator
				+ System.currentTimeMillis() + new Random().nextInt(20) + ".png";
	}

	// Extent reporting
	public static final String extentreportPath = projectPath + File.separator + "report" + File.separator;
	public static final String editExtentreportPath = extentreportPath + "Extent-TestReport.html";
	public static final String extentConfigPath = resourcePath + "extentreport.xml";
	public static final String newExtentReportPath(String currentDate) {
		return extentreportPath + "Extent-TestReport-" + currentDate + ".html";
	}
	

}
