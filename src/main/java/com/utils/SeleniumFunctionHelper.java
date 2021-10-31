package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browser.DriverManager;
import com.constants.FrameworkConstant;
import com.reports.LogStatus;

/**
 * Represents the selenium functionalities.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class SeleniumFunctionHelper {

	/** This is a WebDrvier Wait Instance Variable. */
	private WebDriverWait wait;

	/**
	 * This Constructor to initializes the SeleniumFunctionHelper.
	 */
	public SeleniumFunctionHelper() {
			this.wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.waitTime);
	}

	/**
	 * This method verify the the current URL contains the searched element.
	 * @param searchPattern -> pattern which needs to search in URL.
	 * @return flag -> Returns true if pattern exist in current URL, else false.
	 */
	public boolean isUrlContains(final String searchPattern) {
		boolean flag = false;
		flag = wait.until(ExpectedConditions.urlContains(searchPattern));
		return flag;
	}

	/**
	 * This method clicks on the given element if it is visible and clickable.
	 * @param objectTobeClicked -> WebElement in which click operation needs to do.
	 */
	public void clickElement(final WebElement objectTobeClicked) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(objectTobeClicked));
		element.click();
	}

	/**
	 * This method clicks on the given element if it is visible and clickable.
	 * @param objectTobeClicked -> WebElement in which click operation needs to do.
	 */
	public void clickUsingJavaScript(final WebElement objectTobeClicked) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(objectTobeClicked));
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method enter value on the given element if it is visible and clickable.
	 * @param locator -> WebElement in which value needs to enter.
	 * @param textToEnter -> Value tobe entered.
	 */
	public void enterText(final WebElement locator, String textToEnter) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.sendKeys(textToEnter);

	}

	/**
	 * This method provide the text in that given webelement.
	 * @param element -> WebElement from which get the text.
	 */
	public String getText(final WebElement element) {
		return element.getText();
	}

	/**
	 * This method clear the value in the textBox/textarea element.
	 * @param locator -> WebElement in which the text need to clear.
	 */
	public void clearText(final WebElement locator){
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
	}
	
	/**
	 * This method highlight the webelement.
	 * @param locator -> WebElement which need to highlight.
	 */
	public void highlightElement(WebElement element) {
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * This method waits until the element is visible and known to be present on the DOM.
	 * @param locator -> WebElement
	 * @return true -> element it is visible return true, else false.
	 */
	public boolean isElementVisibility(final WebElement locator) {
		boolean flag = false;
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
		flag = isElementNotNull(element);
		return flag;
	}

	/**
	 * This method waits until the element is clickable on the DOM of the page.
	 * @param locator -> WebElement  Object
	 * @return flag -> True if clickable element, else false
	 */
	public boolean isElementClickable(final WebElement locator) {
		boolean flag = false;
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		flag = isElementNotNull(element);
		return flag;
	}

	/**
	 * This method verify the element is null or not.
	 * @param locator -> WebElement  Object
	 * @return flag -> True if not null, else false
	 */
	private boolean isElementNotNull(final WebElement element) {
		if (element != null) {
			return true;
		} else {
			return false;
		}
	}
}
