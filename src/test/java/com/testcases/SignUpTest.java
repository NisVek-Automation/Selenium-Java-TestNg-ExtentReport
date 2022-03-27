package com.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.*;
import com.reports.LogStatus;
import com.utils.CommonFunctionHelper;
import com.utils.ExcelSheetHelper;
import com.utils.ExceptionHelper;

public final class SignUpTest extends BaseTest {
	
	HomePage homePage=null;
	SignupPage signupPage =null;
	EmailConfirmPage emailConfirmPage=null;
	LoginPage loginPage=null;
	
	/**Test the signup process using 'Sign up free' button from home page menu bar.*/
	@Test(dataProvider = "signupDataProvider")
	public void TC001_SignUpFreeFromMenu(String testCaseId, String name,
			String workEmail, String password, String status) {
	
		homePage = new HomePage();
		homePage.clickMenuSignUp();
		signUp(name, workEmail, password, status);
	}
	
	/**Test the singup process using 'Sign up free' button from home page at bottom.*/
	//@Test(dataProvider = "signupDataProvider")
	public void TC002_SignUpFreeBottom(String testCaseId, String name,
			String workEmail, String password, String status) {

		homePage = new HomePage();
		loginPage = new LoginPage();

		homePage.clickSignUp();
		signUp(name, workEmail, password,status);
		
	}
	
	private void signUp(String name, String workEmail, String password, String status){
		signupPage = new SignupPage();
		emailConfirmPage = new EmailConfirmPage();
		Assert.assertTrue(signupPage.isSignupPage(), "Signup page not displayed Successfully.");

		if(!workEmail.isEmpty()){
			workEmail= CommonFunctionHelper.generateRandomMail(8);
		}
		signupPage.enterName(name)
				.enterWorkEmail(workEmail)
				.enterPassword(password)
				.clickAgreeMiroTerms()
				.clickGetStartedNow();

		boolean errorFlag = signupPage.isError();
		if(status.equalsIgnoreCase("pass")){
			Assert.assertFalse(errorFlag, "Signup field validation error");
			Assert.assertTrue(emailConfirmPage.isEmailConfirmPage(), "Email Confirmation page not displayed Successfully.");
		}else if(status.equalsIgnoreCase("fail") && errorFlag != true){
			Assert.assertTrue(!errorFlag, "Signup field validation error");
		}
	}

	private SignUpTest(){
		//restrict to create the object of this class.
	}
}
