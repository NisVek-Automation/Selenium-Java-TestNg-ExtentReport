package com.reporting;

import java.io.File;

//import com.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.constants.FrameworkConstant;
import com.enums.PropertyEnum;
import com.utils.CommonFunctionHelper;
import com.utils.PropertyFileHelper;

/**
 * Represents custom modification in the extent report.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ExtentReport {

	public static ExtentReports report = null;
	public static String reportFilePath = "";

	/**
	 * Basic configuration in extent report.
	 * Private access to avoid external initialization.
	 */
	private ExtentReport() {
		report = new ExtentReports(getReportPath());
		report.loadConfig(new File(FrameworkConstant.EXTENT_CONFIG_PATH));
		report.addSystemInfo("Testing", FrameworkConstant.REPORT_TITLE);
		report.addSystemInfo("Author", FrameworkConstant.AUTHOR);
		report.addSystemInfo("Environment",FrameworkConstant.ENVIRONMENT);
	}

	/** Initialize the extent report. */
	public static void initialize() {
		ExtentReport report = new ExtentReport();
		Log.pass("Extent Report is initialized.");
	}
	
	/**
	 * Get the report location.
	 * @return Path of the report.
	 */
	public static String getReportPath() {
		if (reportFilePath.isEmpty()) {
			if (PropertyFileHelper.get(PropertyEnum.OVERRIDETESTREPORT).equalsIgnoreCase(FrameworkConstant.YES)) {
				reportFilePath = FrameworkConstant.EDIT_EXTENTREPORT_PATH;
			} else {
				reportFilePath = FrameworkConstant.newExtentReportPath(CommonFunctionHelper.getCurrentDateTime());
			}
		}
		return reportFilePath;
	}

}
