package com.pages;

import com.constants.AppConstant;
import com.reports.LogStatus;

public class SignUpWithSocialPage extends BasePage{
	
	/** Verify the google signin page is displayed .
	 * @return Return true if signin page displayed, else false.
	 */
	public boolean isGoogleSignupPage(){
		if (
			seleniumHelper.isUrlContains("google.com")){
			LogStatus.pass("Google Signin page displayed successfully.", false);
			return true;
		}
		LogStatus.pass("Google Signin page display problem.", true);
		return false;
	}

}
