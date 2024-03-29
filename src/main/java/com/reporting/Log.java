package com.reporting;

import java.lang.invoke.MethodHandles;

import com.browser.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import com.utils.CommonFunctionHelper;

/**
 * Provides type of log such as pass, fail, error, etc. in the
 * Extent report, log file and reporter log.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class Log {

	//Initialize Log4j instance
    private static final Logger log =  LogManager.getLogger(MethodHandles.lookup().lookupClass());
    
	private Log() {
		//private to avoid initialization
	}
	
	/**
	 * Report status as pass with message in log file and reporter only.
	 * @param message --> Message which wanted to pass.
	 */
	public static void pass(String message){
		log.info(message);
		Reporter.log(message);
	}

	/**
	 * Report status as pass with message and screenshot in extent report,
	 * log file and reporter.
	 * @param message --> Message which wanted to pass.
	 * @param isScreenShotRequired --> Attach the screenshot if true, otherwise no screenshot attachment.
	 */
	public static void pass(String message, boolean isScreenShotRequired) {
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.PASS, message);
		if(isScreenShotRequired && DriverManager.getDriver() != null) {
			ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.PASS, message,
					CommonFunctionHelper.getBase64Image());
		}
		log.info(message);
		Reporter.log(message);
	}
	
	/**
	 * Report status as fail with message and screenshot in extent report,
	 * log file and reporter.
	 * @param message --> Message which wanted to fail.
	 * @param isScreenShotRequired --> Attach the screenshot if true, otherwise no screenshot attachment.
	 */
	public static void fail(String message, boolean isScreenShotRequired){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.FAIL, message);
		if(isScreenShotRequired) {
			ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.FAIL, 
					message,CommonFunctionHelper.getBase64Image());
		}
		log.error(message);
		Reporter.log(message);
	}
	
	/**
	 * Report status as fail with message in log file and reporter only.
	 * @param message --> Message which wanted to fail.
	 */
	public static void fail(String message){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.FAIL, message);
		log.fatal(message);
		//log.error(message);
		Reporter.log(message);
	}

	/**
	 * Report status as info message in extent report,log file and reporter.
	 * @param message --> Message which wanted to mark as info.
	 */
	public static void info(String message){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.INFO, message);
		log.info(message);
		Reporter.log(message);
	}

	/**
	 * Report status as error with message in extent report,log file and reporter.
	 * @param message --> Message which wanted to mark as error.
	 */
	public static void error(String message){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.ERROR, message);
		log.error(message);
		Reporter.log(message);
	}

	/**
	 * Report status as fatal with message in extent report,log file and reporter.
	 * @param message --> Message which wanted to mark as fatal.
	 */
	public static void fatal(String message){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.FATAL, message);
		log.fatal(message);
		Reporter.log(message);
	}

	/**
	 * Report status as skip with message in extent report.
	 * @param message --> Message which wanted to mark as skip.
	 */
	public static void skip(String message){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.SKIP, message);
	}
	
	/**
	 * Report status as warning with message in extent report,log file and reporter.
	 * @param message --> Message which wanted to mark as warning.
	 */
	public static void warning(String message){
		ExtentManager.getExtTest().log(com.relevantcodes.extentreports.LogStatus.WARNING, message);
		log.warn(message);
		Reporter.log(message);
	}
	
	/**
	 * Report information message in log file only.
	 * @param Message which need to log.
	 */
	public static void logInfo(String message) {
		log.info(message);
	}
	
}
