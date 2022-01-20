package com.utils;


import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browser.DriverManager;
import com.constants.FrameworkConstant;

/**
 * Represents the Selenium functionalities.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class SeleniumFunctionHelper {

	/**
	 * This method clicks on the given element if it is visible and clickable.
	 * @param objectTobeClicked -> WebElement in which click operation needs to do.
	 */
	public void clickElement(final WebElement locator) {
		explicitWaitForElementToBeClickable(locator).click();
	}
	
	/**
	 * This method enter value on the given element if it is visible and clickable.
	 * @param locator -> WebElement in which value needs to enter.
	 * @param textToEnter -> Value tobe entered.
	 */
	public void enterText(final WebElement locator, String textToEnter) {
		WebElement element = explicitWaitForElementToBeClickable(locator);
		element.sendKeys(textToEnter);

	}

	/**
	 * This method clicks on the given element if it is visible and clickable.
	 * @param locator -> WebElement in which click operation needs to do.
	 */
	public void clickUsingJavaScript(final WebElement locator) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", 
				explicitWaitForElementToBeClickable(locator));
	}
	
	/**
	 * This method clear the value in the textBox/textarea element.
	 * @param locator -> WebElement in which the text need to clear.
	 */
	public void clearText(final WebElement locator){
		WebElement element = explicitWaitForElementToBeClickable(locator);
		element.clear();
	}
	
	/**
	 * This method waits until the element is clickable on the DOM of the page.
	 * @param locator -> WebElement  Object
	 * @return flag -> True if clickable element, else false
	 */
	public boolean isElementClickable(final WebElement locator) {
			return (explicitWaitForElementToBeClickable(locator) == null)?false:true;
	}
	
	/**
	 * Explicit wait for element to be clickable.
	 * @param by to locate web elements
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBeClickable(final WebElement locator) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.waitTime)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * This method provide the text in that given webelement.
	 * @param locator -> WebElement from which get the text.
	 */
	public String getText(final WebElement locator) {
		return locator.getText();
	}
	
	/**
	 * This method highlight the webelement.
	 * @param locator -> WebElement which need to highlight.
	 */
	public void highlightElement(WebElement element) {
		((JavascriptExecutor)DriverManager.getDriver())
		.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * This method waits until the element is visible and known to be present on the DOM.
	 * @param locator -> WebElement
	 * @return true -> element it is visible return true, else false.
	 */
	public boolean isElementVisibility(final WebElement locator) {
		return (explicitWaitForElementToBeVisible(locator) == null)?false:true;
	}
	
	/**
	 * Explicit wait for element to be present.
	 * @param by to locate web elements
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBeVisible(final WebElement locator) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.waitTime)
				.until(ExpectedConditions.visibilityOf(locator));
	}
	
	/**
	 * This method verify the the current URL contains the searched element.
	 * @param Pattern which needs to search in URL.
	 * @return Returns true if pattern exist in current URL, else false.
	 */
	public boolean isUrlContains(final String searchPattern) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.waitTime)
				.until(ExpectedConditions.urlContains(searchPattern));
	}
	
	public static String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static String getPageSource() {
		return DriverManager.getDriver().getPageSource();
	}

	public static String getCurrentUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	public static String getWindowHandle() {
		return DriverManager.getDriver().getWindowHandle();
	}
	
	public static void switchToWindow(String windowName) {
		DriverManager.getDriver().switchTo().window(windowName);
	}

	public static Set<String> getAllWindowHandle() {
		return DriverManager.getDriver().getWindowHandles();
	}
	
	public static void dismissAert() {
		DriverManager.getDriver().switchTo().alert().dismiss();
	}

	public static void acceptAert() {
		DriverManager.getDriver().switchTo().alert().accept();
	}

	public static void sendValueToAlert(String value) {
		DriverManager.getDriver().switchTo().alert().sendKeys(value);
	}
	
	public static String getAertText() {
		return DriverManager.getDriver().switchTo().alert().getText();
	}
	
}
