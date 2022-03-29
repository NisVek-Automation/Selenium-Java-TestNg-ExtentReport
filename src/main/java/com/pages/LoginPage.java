package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.constants.AppConstant;
import com.reporting.Log;
import com.utils.SeleniumHelper;

public class LoginPage extends BasePage {
	
	//----------------------- Objects ------------------------
	@FindBy(xpath = "//span[text()='Sign up']") private WebElement btnSignUp;
		
	//----------------------- Methods ------------------------
	/** Click operation on Sign up button. */
	public void clickSignUp() {
		SeleniumHelper.clickUsingJavaScript(btnSignUp);
		Log.pass("Clicked on Signup free button.", true);
	}
	
	/** Verify the signup page is displayed.
	 * @return Return true if signup page displayed, else false.
	 */
	public boolean isSignupPage(){
		if (SeleniumHelper.isElementClickable(lblPageHeader) && 
			lblPageHeader.getText().equals(AppConstant.signInHeading) && 
			SeleniumHelper.isUrlContains("login")){
			Log.pass("Sign in page displayed successfully.", false);
			return true;
		}
		Log.pass("Signup in display problem.", true);
		return false;
	}

}
