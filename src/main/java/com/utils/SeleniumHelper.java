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
public class SeleniumHelper {

	/**
	 * This method clicks on the given element if it is clickable.
	 * @param element -> WebElement in which click operation needs to do.
	 */
	public static void clickElement(final WebElement element) {
		explicitWaitForElementToBeClickable(element).click();
	}
	
	/**
	 * This method enter value on the given element if it is clickable.
	 * @param element -> WebElement in which value needs to enter.
	 * @param textToEnter -> Value to be entered.
	 */
	public static void enterText(final WebElement element, String textToEnter) {
		explicitWaitForElementToBeClickable(element).sendKeys(textToEnter);

	}
	
	/**
	 * This method clear the value on the given element.
	 * @param element -> WebElement in which value needs to clear.
	 * @param textToEnter -> Value to be cleared.
	 */
	public static void clearText(final WebElement element) {
		explicitWaitForElementToBeClickable(element).clear();

	}
	
	/**
	 * Verify element is displayed on screen.
	 * @param element which needs to check
	 * @return return true if element present, else false.
	 */
	public static boolean isElementDisplayed(final WebElement element) {
		return explicitWaitForElementToBeClickable(element).isDisplayed();
	}
	
	/**
	 * Get text value from the element.
	 * @param element 
	 * @return text from the element
	 */
	public static String getText(final WebElement element) {
		try {
			return explicitWaitForElementToBeClickable(element).getText().trim();
		}catch(Exception e) {
			return null;
		}
		
	}
	
	/**
	 * Explicit wait for element to be clickable.
	 * @param element which needs to check
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBeClickable(final WebElement element) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.EXPLICIT_MAXWAIT)
				.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Navigate back to previous.
	 */
	public static void navigateBack() {
		DriverManager.getDriver().navigate().back();
	}

	/**
	 * This method clicks on the given element if it is visible and clickable.
	 * @param locator -> WebElement in which click operation needs to do.
	 */
	public static void clickUsingJavaScript(final WebElement locator) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", 
				explicitWaitForElementToBeClickable(locator));
	}
	
	/**
	 * This method clicks on the given element if it is visible and clickable.
	 * @param locator -> WebElement in which click operation needs to do.
	 */
	public static void scrollToView(final WebElement locator) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].scrollIntoView();", 
				explicitWaitForElementToBeClickable(locator));
	}
	
	/**
	 * This method waits until the element is clickable on the DOM of the page.
	 * @param locator -> WebElement  Object
	 * @return flag -> True if clickable element, else false
	 */
	public static boolean isElementClickable(final WebElement locator) {
			return (explicitWaitForElementToBeClickable(locator) == null)?false:true;
	}
	
	/**
	 * This method highlight the webelement.
	 * @param locator -> WebElement which need to highlight.
	 */
	public static void highlightElement(WebElement element) {
		((JavascriptExecutor)DriverManager.getDriver())
		.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	/**
	 * Explicit wait for element to be present.
	 * @param by to locate web elements
	 * @return WebElement
	 */
	public static WebElement explicitWaitForElementToBeVisible(final WebElement locator) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.WAIT_TIME)
				.until(ExpectedConditions.visibilityOf(locator));
	}
	
	/**
	 * This method verify the the current URL contains the searched element.
	 * @param Pattern which needs to search in URL.
	 * @return Returns true if pattern exist in current URL, else false.
	 */
	public static boolean isUrlContains(final String searchPattern) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.WAIT_TIME)
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
