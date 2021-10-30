package com.browser;

import org.openqa.selenium.WebDriver;
import com.reports.LogStatus;

/**
 * Browsers Parent abstract class.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public abstract class BrowserManager {

	/** WebDriver instance */
	public WebDriver driver;

	/** Create the WebDriver type object based on the browser. */
	public abstract WebDriver createDriver();

	/** This method close and quite the Webdriver. */
	public void quit() {
		if (driver != null) {
			driver.close();
			driver.quit();
			LogStatus.info("Browser is closed successfully.");
		}
	}

}
