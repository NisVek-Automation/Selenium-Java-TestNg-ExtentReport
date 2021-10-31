package com.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.constants.FrameworkConstant;
import com.utils.PropertyFileHelper;

/**
 * Represents custom modification in the extent report.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ExtentReport {

	public static ExtentReports report = null;
	public static String extentreportpath = "";

	// To avoid external initialization
	/**
	 * Basic configuration in extent report.
	 */
	private ExtentReport() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		if (PropertyFileHelper.get("OverrideResults").equalsIgnoreCase("yes")) {
			extentreportpath = FrameworkConstant.editExtentreportPath;
		} else {
			extentreportpath = FrameworkConstant.newExtentReportPath(currentDate);
		}
		report = new ExtentReports(extentreportpath);
		report.loadConfig(new File(FrameworkConstant.extentConfigPath));
		report.addSystemInfo("Testing", "UI Testing Demo");
		report.addSystemInfo("Author", "Nisha Vekariya");
		report.addSystemInfo("User Name","Nisha");
	}

	/**
	 * Initialize the extent report.
	 */
	public static void initialize() {
		ExtentReport report = new ExtentReport();
		LogStatus.pass("Extent Report is initialized.");
	}

}
