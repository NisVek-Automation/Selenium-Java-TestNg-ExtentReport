package com.browser;

import org.openqa.selenium.WebDriver;

/** 
 * This class handles the thread local for the Webdriver type.
 * @author Nisha Vekariya
 * @version 1.0
*/
public class DriverManager {
	
public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	/* This method returns the value in the current thread’s copy of this thread-local variable.*/
	public static WebDriver getDriver() {
		return dr.get();
	}

	/* This method sets the current thread’s copy of this thread-local variable to the specified value. */
	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
	}

}
