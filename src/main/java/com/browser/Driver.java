package com.browser;

import org.openqa.selenium.WebDriver;

import com.enums.BrowserName;
import com.enums.PropertyEnum;
import com.reporting.Log;
import com.utils.PropertyFileHelper;

/** 
 * This class used for selecting browser type and open the URL activities.
 * @author Nisha Vekariya
 * @version 1.0
*/
public class Driver {
	
	/**
	 * Initialize the driver based on selected browser and open the url operation.
	 * @param browserName -> browser name using that can create the driver.
	 */
	public static void initialize(String browserName) {
		if (DriverManager.getDriver() == null){
				new Driver(browserName);
		}
		Log.pass("Driver is initialized Successfully.");
	}
	
	/**
	 * Initialize the driver and open the url operation.
	 * @param browserName -> browser name using that can create the driver.
	 */
	private Driver(String browserName) {
		selectDriverType(browserName);
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(PropertyFileHelper.get(PropertyEnum.URL));
		Log.pass("Browser is opened and maximize successfully.");
	}

	/**
	 * Select the driver based on selected browser.
	 * @param browser -> browser name using that can create the driver.
	 */
	private void selectDriverType(String browser) {
		WebDriver driver=null;
			if (browser.equalsIgnoreCase(BrowserName.edge.toString())) {
				driver = new EdgeBrowser().createDriver();
			} else {
				driver = new ChromeBrowser().createDriver();
			}
			DriverManager.setWebDriver(driver);
			Log.pass("Driver is initialized with browser : " + browser);
	}

	/**
	 * Quit and close the driver and browser.
	 */
	public static void quit() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().close();
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		Log.pass("Browser is closed successfully.");
	}

}
