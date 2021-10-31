package com.browser;

import org.openqa.selenium.WebDriver;
import com.reports.LogStatus;
import com.utils.PropertyFileHelper;

/** 
 * This class used for selecting browser type and open the URL activities.
 * @author Nisha Vekariya
 * @version 1.0
*/
public class Driver {

	public WebDriver driver = null;

	/**
	 * Initialize the driver and open the url operation.
	 * @param browser -> browser name using that can create the driver.
	 */
	private Driver(String browser) {
		getBrowserDriver(browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(PropertyFileHelper.get("Url"));
		LogStatus.pass("Browser is opened and maximize successfully.");
	}

	/**
	 * Select the driver based on selected browser.
	 * @param browser -> browser name using that can create the driver.
	 */
	private void getBrowserDriver(String browser) {
			if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeBrowser().createDriver();
			} else {
				driver = new ChromeBrowser().createDriver();
			}
			DriverManager.setWebDriver(driver);
			LogStatus.pass("Driver is initialized with browser : " + browser);
	}

	/**
	 * Initialize the driver based on selected browser and open the url operation.
	 * @param browser -> browser name using that can create the driver.
	 */
	public static void initialize(String browser) {
		if (DriverManager.getDriver() == null){
				new Driver(browser);
		}
		LogStatus.pass("Driver is initialized Successfully.");
	}

	/**
	 * Quit and close the driver and browser.
	 */
	public static void quit() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().close();
			DriverManager.getDriver().quit();
			DriverManager.setWebDriver(null);
		}
		LogStatus.pass("Browser is closed successfully.");
	}

}
