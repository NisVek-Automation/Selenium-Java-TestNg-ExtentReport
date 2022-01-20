package com.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.constants.FrameworkConstant;
import com.enums.PropertyConfig;
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
		report.loadConfig(new File(FrameworkConstant.extentConfigPath));
		report.addSystemInfo("Testing", FrameworkConstant.reportTitle);
		report.addSystemInfo("Author", FrameworkConstant.author);
		report.addSystemInfo("Environment",FrameworkConstant.environment);
	}

	/** Initialize the extent report. */
	public static void initialize() {
		ExtentReport report = new ExtentReport();
		LogStatus.pass("Extent Report is initialized.");
	}
	
	/**
	 * Get the report location.
	 * @return Path of the report.
	 */
	public static String getReportPath() {
		if (reportFilePath.isEmpty()) {
			if (PropertyFileHelper.get(PropertyConfig.OVERRIDETESTREPORT).equalsIgnoreCase(FrameworkConstant.yes)) {
				reportFilePath = FrameworkConstant.editExtentreportPath;
			} else {
				reportFilePath = FrameworkConstant.newExtentReportPath(CommonFunctionHelper.getCurrentDateTime());
			}
		}
		return reportFilePath;
	}

}
