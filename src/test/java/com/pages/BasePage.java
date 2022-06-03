package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.browser.DriverManager;
import com.reporting.Log;
import com.utils.SeleniumHelper;

/** 
 * Represents a super class, which contains common elements and functionality in the application.
 * @author Nisha Vekariya
 * @version 1.0
*/
public class BasePage {
	
	//------------------------ WebElements -------------------------------//
	@FindBy(css=".signup__title-form") public WebElement lblPageHeader;
	@FindAll({@FindBy(xpath = "//*[@id='Sign-up-free']"), 
			  @FindBy(xpath = "//*[@aria-label='Header']//div[text()='Sign Up']")}) 
			public WebElement btnMenuSignUp;
	
	
	//------------------------ Functions -------------------------------//
	protected BasePage(){
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	/** Click operation on Sign up button on menu bar. */
	public void clickMenuSignUp() {
		SeleniumHelper.clickUsingJavaScript(btnMenuSignUp);
		Log.pass("Clicked on Signup free button on menu bar", true);
	}

}
