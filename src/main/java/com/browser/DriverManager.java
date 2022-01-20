package com.browser;

import org.openqa.selenium.WebDriver;

/** 
 * This class handles the thread local for the Webdriver type.
 * @author Nisha Vekariya
 * @version 1.0
*/
public final class DriverManager {
	
	public static ThreadLocal<WebDriver> webdriverThread = new ThreadLocal<>();
	
	/* This method returns the value in the current thread’s copy of this thread-local variable.*/
	public static WebDriver getDriver() {
		return webdriverThread.get();
	}

	/* This method sets the current thread’s copy of this thread-local variable to the specified value. */
	public static void setWebDriver(WebDriver driver) {
		webdriverThread.set(driver);
	}

	/* This method remove the current thread’s copy of this thread-local variable to the specified value. */
	public static void unload() {
		webdriverThread.remove();
	}
	
	private DriverManager(){
		//Avoid to create the object of this class.
	}
}
