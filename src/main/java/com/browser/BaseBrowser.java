package com.browser;

import org.openqa.selenium.WebDriver;

import com.reporting.Log;

/**
 * Browsers Parent abstract class.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public abstract class BaseBrowser {

	/** WebDriver instance */
	public WebDriver driver;

	/** Create the WebDriver type object based on the browser. */
	public abstract WebDriver createDriver();

	/** This method close and quite the Webdriver. */
	public void quit() {
		if (driver != null) {
			driver.close();
			driver.quit();
			Log.info("Browser is closed successfully.");
		}
	}

}
