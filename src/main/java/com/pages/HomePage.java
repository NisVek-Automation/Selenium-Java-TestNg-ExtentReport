package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.reports.LogStatus;

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

	//------------------------ WebElements -------------------------------//
	/** Click operation on Sign up button. */
	public void clickSignUp() {
		seleniumHelper.highlightElement(btnSignUp);
		seleniumHelper.clickUsingJavaScript(btnSignUp);
		LogStatus.pass("Clicked on Signup free button.", true);
	}

	/** Click operation on Start Whiteboard button. */
	public void clickStartWhiteboard() {
		seleniumHelper.clickElement(btnStartWhiteBoard);
		LogStatus.pass("Clicked on Start a Whiteboard button.", true);
	}

}
