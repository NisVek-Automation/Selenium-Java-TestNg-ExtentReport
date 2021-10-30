package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.SignUpWithSocialPage;
import com.pages.SignupPage;

public class SignupUsingSocialTest extends BaseTest{

	HomePage homePage=null;
	SignupPage signupPage =null;
	

	@Test(description = "TC01_SignupUsingExternal_Google")
	public void TC01_SignupUsingExternal_Google() {

		homePage = new HomePage();
		homePage.clickStartWhiteboard();
		
		signupPage = new SignupPage();
		Assert.assertTrue(signupPage.isSignupPage(), "Signup page not displayed Successfully.");
		
		signupPage.clickSignUpGoogle();
		signupPage.clickThirdPartyAgreeMiroTerms();
		signupPage.clickContinueToSignUp();
		
		SignUpWithSocialPage signUpWithSocialPage = new SignUpWithSocialPage();
		Assert.assertTrue(signUpWithSocialPage.isGoogleSignupPage(), "Signup page not displayed Successfully.");
	}
}
