package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.reporting.Log;
import com.utils.SeleniumHelper;

/**
 * Home page which contains home page related WebElements and functionality.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class HomePage extends BasePage {


	//------------------------ WebElements -------------------------------//
	@FindBy(xpath = "//*[@id='sign-up-free-btn']") private WebElement btnSignUp;
	@FindBy(xpath = "//*[@class='com-el-button__text' and text()='Start a whiteboard']")
	private WebElement btnStartWhiteBoard;

	//------------------------ Functionss -------------------------------//
	/** Click operation on Sign up button. */
	public void clickSignUp() {
		SeleniumHelper.scrollToView(btnSignUp);
		SeleniumHelper.clickUsingJavaScript(btnSignUp);
		Log.pass("Clicked on Signup free button.", true);
	}

	/** Click operation on Start Whiteboard button. */
	public void clickStartWhiteboard() {
		SeleniumHelper.clickElement(btnStartWhiteBoard);
		Log.pass("Clicked on Start a Whiteboard button.", true);
	}

}
