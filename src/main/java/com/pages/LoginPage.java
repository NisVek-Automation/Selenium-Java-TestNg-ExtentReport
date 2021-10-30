package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.constants.AppConstant;
import com.reports.LogStatus;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//span[text()='Sign up']") private WebElement btnSignUp;
	
	/** Click operation on Sign up button. */
	public void clickSignUp() {
		seleniumHelper.clickUsingJavaScript(btnSignUp);
		LogStatus.pass("Clicked on Signup free button.", true);
	}
	
	/** Verify the signup page is displayed.
	 * @return Return true if signup page displayed, else false.
	 */
	public boolean isSignupPage(){
		if (seleniumHelper.isElementVisibility(lblPageHeader) && 
			lblPageHeader.getText().equals(AppConstant.signInHeading) && 
			seleniumHelper.isUrlContains("login")){
			LogStatus.pass("Sign in page displayed successfully.", false);
			return true;
		}
		LogStatus.pass("Signup in display problem.", true);
		return false;
	}

}
