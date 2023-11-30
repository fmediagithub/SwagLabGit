package com.automation.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.automation.businesscomponents.Login;
import com.automation.businesscomponents.SetUp;
import com.automation.businesscomponents.TestMe;
import com.automation.common.Common;
import com.automation.pageelements.HomeObjects;
import com.automation.pageelements.LoginObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginBase extends TestMe{
	Logger logger = LogManager.getLogger(LoginBase.class.getName());
	
	public static void loginSwag() throws IOException {
		
		Common.enterText(LoginObjects.INPUT_USER_NAME, Common.getDatFromExcel("user name"),"user name");
		Common.enterText(LoginObjects.INPUT_PASSWORD, Common.getDatFromExcel("password"),"password");
		Common.clickElemnt(LoginObjects.BTN_LOGIN,"Login"); 	
		try {
			if(Common.checkElementpresence(HomeObjects.BTN_CART))
				Common.pass("<b>user logged sucessfully</b>");
			   
			
		} catch (Exception e) {
			Common.fail("user login failed");
			Common.info(e.getMessage());
			Assert.fail("Testng test failed");
		}
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

	}

	public static void navigate() throws IOException {
		
		String url="https://www.saucedemo.com/";
		driver.get(url);
		if(driver.getCurrentUrl().equals(url)) {
			Common.pass("Swag Lab Launched Successfully");
		}
		else
			Common.fail("Swag Lab Launch Failed");
		
	}

}
