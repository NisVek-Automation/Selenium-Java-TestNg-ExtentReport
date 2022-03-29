package com.pages;

import com.reporting.Log;
import com.utils.SeleniumHelper;

public class SignUpWithSocialPage extends BasePage{
	
	/** Verify the google signin page is displayed .
	 * @return Return true if signin page displayed, else false.
	 */
	public boolean isGoogleSignupPage(){
		if (
			SeleniumHelper.isUrlContains("google.com")){
			Log.pass("Google Signin page displayed successfully.", false);
			return true;
		}
		Log.pass("Google Signin page display problem.", true);
		return false;
	}

}
