package com.reporting;

import com.relevantcodes.extentreports.ExtentTest;

/** 
 * This class handles the thread local for the ExtentTest type.
 * @author Nisha Vekariya
 * @version 1.0
*/
public class ExtentManager {

	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	/* This method returns the value in the current thread’s copy of this thread-local variable.*/
	public static ExtentTest getExtTest() {
		return extentTest.get();
	}

	/* This method sets the current thread’s copy of this thread-local variable to the specified value. */
	public static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

}
