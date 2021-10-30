package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing1 extends BaseTest {
	
	@Test(description = "Testin1")
	public void TC01_SignUpFree() {
		System.out.println("In the testcase");
		Assert.assertTrue(false);
	}
}
