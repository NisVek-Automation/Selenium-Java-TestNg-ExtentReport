package com.browser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Represents a Edge Browser related activities, such as
 * 1. Create the Edge driver
 * 2. Set the project related settings for edge driver
 * @author Nisha Vekariya
 * @version 1.0
*/
public class EdgeBrowser extends BrowserManager{
	
	/** This is FirefoxOption instance to set the options for Firefox Browser */
	private FirefoxOptions options;
	
	/**
	 * This method helps to setup the Edge driver for Testing.
	 * @return driver -> It returns the Edge type WebDriver.
	 */
	@Override
	public WebDriver createDriver(){
		//Setup the WebDriverManager 
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}

}