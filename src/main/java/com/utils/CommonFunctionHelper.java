package com.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import java.util.*;
import javax.activation.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.browser.DriverManager;
import com.constants.FrameworkConstant;
import com.enums.PropertyConfig;
import com.listeners.ListenerClass;
//import com.listener.ListenerClass;
import com.reports.ExtentReport;
import com.reports.LogStatus;

/**
 * Represents common functionality which used for framework, such as 
 * 1. Take the screenshot 
 * 2. Get BASE64 image to link in extent report 
 * 3. Get current date time format
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public final class CommonFunctionHelper {

	private CommonFunctionHelper(){
		//Avoid creating the object of this class.
	}
	
	/** Takes screenshot  */
	public static void takeScreenshot() {
		takeScreenshotAndGetTargetPath();
	}
	
	/**
	 * Captures screenshot and returns the screenshot path.
	 * @return destination -> return the screenshot path.
	 */
	public static String takeScreenshotAndPullPath() {
		return takeScreenshotAndGetTargetPath();
	}
	
	/**
	 * Captures screenshot and returns the screenshot path.
	 * @return destination -> return the screenshot path.
	 */
	private static String takeScreenshotAndGetTargetPath() {
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String targetPath = null;
		try {
			if (PropertyFileHelper.get(PropertyConfig.SCREENSHOTPATH.toString()).equals("")) {
				targetPath = FrameworkConstant.testCaseScreenShotPath(ListenerClass.getTestcaseName());
			} else {
				targetPath = FrameworkConstant.testCaseScreenShotPath(ListenerClass.getTestcaseName(), 
								PropertyFileHelper.get(PropertyConfig.SCREENSHOTPATH.toString()));
			}
			FileUtils.copyFile(scrFile,new File(targetPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return targetPath;
	}

	/**
	 * Gives a base64 image which is used to append the screenshots in the
	 * extent report. Converting to base64 format avoids screenshots broken
	 * image.
	 * @param screenshotpath --> path of screenshot.
	 * @return base64 -> return the encoded image string.
	 */
	public static String getBase64Image(String screenshotpath) {
		String base64 = null;
		try {
			InputStream is = new FileInputStream(screenshotpath);
			byte[] imageBytes = IOUtils.toByteArray(is);
			base64 = Base64.getEncoder().encodeToString(imageBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64;
	}

	/**
	 * This method gives the current date and time on specific format.
	 * @return time -> It returns time in specific format.
	 */
	public static String getCurrentDateTimeFormate() {
		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		Calendar calendar = Calendar.getInstance();
		String time = "" + dateFormat.format(calendar.getTime());
		return time;
	}

	/**
	 * This method gives the current date and time.
	 * @return It returns current date time.
	 */
	public static String getCurrentDate() {
		return getCurrentDateTimeFormate().substring(0, 11);
	}

	/**
	 * This method open the report automatically.
	 */
	public static void openReport() {
		if (PropertyFileHelper.get(PropertyConfig.OPENTESTRESULT.toString()).equalsIgnoreCase("yes")) {
			File htmlFile = new File(ExtentReport.extentreportpath);
			try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method generates the random emailid.
	 * @return return the generated random mail.
	 */
	public static String generateRandomMail(int numberOfDigits){
		String randomestring=RandomStringUtils.randomAlphabetic(numberOfDigits);
		return randomestring+"@gmail.com";
	}

}
