package com.pages;


import com.constants.AppConstant;
import com.reporting.Log;
import com.utils.SeleniumHelper;

/**
 * This class contains Email confirm page related WebElements and functionality.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class EmailConfirmPage extends BasePage{

	/** Verify the Email confirm page is displayed.
	 * @return Return true if email confirm page displayed, else false.
	 */
	public boolean isEmailConfirmPage(){
		if(SeleniumHelper.isElementClickable(lblPageHeader) &&
				lblPageHeader.getText().equals(AppConstant.emailConfirmPageHeading) &&
			 SeleniumHelper.isUrlContains("email-confirm")){
			Log.pass("Email Confirmation page is displayed successfully.", false);
			return true;
		}
		Log.pass("Email Confirmation page is not displayed.", true);
		return false;
	}
	
}
