package com.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.browser.DriverManager;
import com.constants.FrameworkConstant;
import com.enums.PropertyEnum;
import com.listeners.ListenerClass;
import com.reporting.ExtentManager;
import com.reporting.ExtentReport;

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
	
	/**
	 * Captures screenshot and returns the screenshot path.
	 * @return destination -> return the screenshot path.
	 */
	public static String takeScreenshotAndPullPath() {
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String targetPath = null;
		try {
			if (PropertyFileHelper.get(PropertyEnum.SCREENSHOTPATH).equals("")) {
				targetPath = FrameworkConstant.testCaseScreenShotPath(ListenerClass.getTestcaseName());
			} else {
				targetPath = FrameworkConstant.testCaseScreenShotPath(ListenerClass.getTestcaseName(), 
						PropertyFileHelper.get(PropertyEnum.SCREENSHOTPATH));
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
	public static String getBase64Image() {
		String base64 = null;
		try {
			byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(takeScreenshotAndPullPath()));
			base64 = ExtentManager.getExtTest().addBase64ScreenShot("data:image/png;base64,"+ 
					Base64.getEncoder().encodeToString(imageBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64;
	}

	/**
	 * This method gives the current date and time on specific format.
	 * @return It returns time in specific format.
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_hh_mm_ss");
		return formatter.format(new Date());
	}
	
	/**
	 * This method open the report automatically.
	 */
	public static void openReport() {
		if (PropertyFileHelper.get(PropertyEnum.OPENTESTRESULT).equalsIgnoreCase(FrameworkConstant.YES)) {
			File htmlFile = new File(ExtentReport.getReportPath());
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
