package com.browser;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import com.reports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

/** 
 * Represents a Google Chrome Browser activities, such as
 * 1. Create the chrome driver
 * 2. Set the project related settings for Chrome driver
 * @author Nisha Vekariya
 * @version 1.0
*/
public class ChromeBrowser extends BrowserManager{
	
	/** The ChromeOption instance to set the options for Chrome Browser */
	private ChromeOptions options;
	
	/**
	 * This method helps to setup the Chrome driver for Testing.
	 * @return driver -> It returns the Chrome type WebDriver.
	 */
	@Override
	public WebDriver createDriver(){
		WebDriverManager.chromedriver().setup();
		browserSetting();
		driver = new ChromeDriver(options);
		return driver;
	}
	
	/** This method helps to setup the ChromeOption instance. */
	private void setChromeOption(){
		if(options == null){
			options = new ChromeOptions();
		}
	}
	
	/**
	 * This method helps to do the settings on Chrome browser.
	 * @return void -> It does not return anything
	 */
	private void browserSetting(){
		//set the chromeoption instance
		setChromeOption();
		//Disable automation info bar
		options.addArguments("disable-infobars");
		//Accept insecure certificate
		options.setAcceptInsecureCerts(true);
		//Handles unexpected alert window
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
	}
	
	

}
