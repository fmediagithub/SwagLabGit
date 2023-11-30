package com.automation.businesscomponents;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.LoginBase;
import com.automation.common.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login  extends TestMe{
	Logger log = LogManager.getLogger(Login.class.getName());
	@Test(priority = 0)
	public void swagLabNavigation() throws InterruptedException, IOException {
		log.info("Inside swagLabNavigation() method:-");
		Common.createTestName("Test case - Laucnch Swag Lab");
		LoginBase.navigate();
       
       
       
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		log.info("Inside "+name+" method");
		Common.createTestName("Test case - Standard User Login");
		LoginBase.loginSwag();

	}
}
