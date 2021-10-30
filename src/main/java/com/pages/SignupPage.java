package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.constants.AppConstant;
import com.reports.LogStatus;

/**
 * This class contains signup page related WebElements and functionality.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class SignupPage extends BasePage {

	//Signup page required fields
	@FindBy(css = "[id='onetrust-accept-btn-handler']")
	private WebElement btnAcceptCookies;
	@FindBy(css = "input#name")
	private WebElement txtName;
	@FindBy(css = "input#email")
	private WebElement txtWorkEmail;
	@FindBy(css = "input#password")
	private WebElement txtPassword;
	@FindBy(css = "button.signup__submit")
	private WebElement btnGetStartedNow;
	@FindBy(xpath = "//span[contains(text(),'I agree to Miro')]//..//*[@class='mr-checkbox-1__check ']")
	private WebElement chkAgreeMiro;
	
	//Third Party signup process fields
	@FindBy(xpath = "//input[@id='tos-signup-terms']//..//label[@for='tos-signup-terms']")
	private WebElement chkThirdPartyTermsAgree;
	@FindBy(xpath = "//button[@class='socialtos__btn js__socialtos-signup']")
	private WebElement btnContinueToSignUp;
	
	
	//Screen fields errors
	@FindBy(css = "label#nameError")
	private WebElement lblNameError;
	@FindBy(css = "label#emailError")
	private WebElement lblEmailError;
	@FindBy(css = "[class*='js-empty-password']")
	private WebElement lblPswError;
	@FindBy(css = "label#termsError")
	private WebElement lblTermsError;
	
	
	@FindBy(css = ".signup__btn-inner")
	private WebElement btnSignUpGoogle;

	/** Verify the signup page is displayed.
	 * @return Return true if signup page displayed, else false.
	 */
	public boolean isSignupPage(){
		if (seleniumHelper.isElementVisibility(lblPageHeader) && 
			lblPageHeader.getText().equals(AppConstant.signupHeading) && 
			seleniumHelper.isUrlContains("signup")){
			LogStatus.pass("Signup page displayed successfully.", false);
			return true;
		}
		LogStatus.pass("Signup page display problem.", true);
		return false;
	}

	/** Enter the value in Name field.
	 * @param name -> Value to be enter in Name field.
	 * @return this -> Return same class object.
	 */
	public SignupPage enterName(String name) {
			seleniumHelper.clearText(txtName);
			seleniumHelper.enterText(txtName, name);
			LogStatus.pass("Entered the Name Successfully : " + name, false);
			return this;
	}

	/** Enter the value in Work Email field.
	 * @param name -> Value to be enter in Work Email field.
	 * @return this -> Return same class object.
	 */
	public SignupPage enterWorkEmail(String workEmail){
		seleniumHelper.clearText(txtWorkEmail);
		seleniumHelper.enterText(txtWorkEmail, workEmail);
		LogStatus.pass("Entered the Work Email Successfully : " + workEmail, false);
		return this;
	}

	/** Enter the value in Password field.
	 * @param name -> Value to be enter in Password field.
	 * @return this -> Return same class object.
	 */
	public SignupPage enterPassword(String password){
			seleniumHelper.clearText(txtPassword);
			seleniumHelper.enterText(txtPassword, password);
			LogStatus.pass("Entered the password Successfully : " + password, false);
			return this;
	}
	
	/** Click operation on Terms and Miro Condition checkbox.
	 * @return this -> Return same class object.
	 */
	public SignupPage clickAgreeMiroTerms(){
			seleniumHelper.clickUsingJavaScript(chkAgreeMiro);
			LogStatus.pass("Clicked successfully on Terms and condition.", false);
			return this;
	}
	
	/** Click operation on Terms and Miro Condition checkbox.
	 * @return this -> Return same class object.
	 */
	public void clickThirdPartyAgreeMiroTerms(){
			seleniumHelper.clickElement(chkThirdPartyTermsAgree);
			LogStatus.pass("Clicked successfully on Terms and condition.", false);
	}
	
	/** Click operation on Signup google button.
	 * @return this -> Return same class object.
	 */
	public SignupPage clickContinueToSignUp(){
		seleniumHelper.clickUsingJavaScript(btnContinueToSignUp);
		LogStatus.pass("Clicked successfully on google Signup button.", false);
		return this;
	}

	/** Click operation on Signup google button.
	 * @return this -> Return same class object.
	 */
	public void clickSignUpGoogle(){
		seleniumHelper.clickUsingJavaScript(btnSignUpGoogle);
		LogStatus.pass("Clicked successfully on google Signup button.", false);

	}
	
	/** Click operation on Get Started now button.
	 * @return this -> Return same class object.
	 */
	public SignupPage clickGetStartedNow() {
			seleniumHelper.clickUsingJavaScript(btnGetStartedNow);
			LogStatus.pass("Clicked successfully on Get started now button.", true);
			return this;
	}

	/** Verify all the fields error on Singup page.
	 * @return flag -> Return true if any error, else false.
	 */
	public boolean isError(){
		boolean flag =false;
		//verify email confirmation page is not displayed
		if (!(seleniumHelper.isElementVisibility(lblPageHeader) &&
			  lblPageHeader.getText().equals(AppConstant.emailConfirmPageHeading) &&
			  seleniumHelper.isUrlContains("email-confirm"))) {
			
			//Check Name field error
			String errorMessage = seleniumHelper.getText(lblNameError);
			if (!errorMessage.isEmpty()) {
				LogStatus.info("Name Field error on signup page : " + errorMessage);
				flag=true;
			}

			//Check Work Email field error
			errorMessage = seleniumHelper.getText(lblEmailError);
			if (!errorMessage.isEmpty()) {
				LogStatus.info("Work Email field error on signup page : " + errorMessage);
				flag=true;
			}
			
			//Check Password field error
			errorMessage = seleniumHelper.getText(lblPswError);
			if (!errorMessage.isEmpty()) {
				LogStatus.info("Password field error on signup page : " + errorMessage);
				flag=true;
			}

			//Check Terms and Privacy Policy field error
			errorMessage = seleniumHelper.getText(lblTermsError);
			if (!errorMessage.isEmpty()) {
				LogStatus.info("Terms and Privacy Policy field error on signup page : " + errorMessage);
				flag=true;
			}
			if(flag == true)
				LogStatus.info("One or more field(s) Error on signup page : ");
		}
		return flag;
	}
	
	/** Click operation on Accept Cookie button. */
	public void clickAcceptCookies() {
			seleniumHelper.clickElement(btnAcceptCookies);
	}

}
