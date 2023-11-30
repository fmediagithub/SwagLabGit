package com.automation.businesscomponents;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.automation.base.CartBase;
import com.automation.base.HomeBase;
import com.automation.base.LoginBase;
import com.automation.common.Common;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMe {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter htmlReporter;
	public static final Logger logger = null; 
	

	@BeforeSuite
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize(); 
		Common.createTestReport(); 
		
	}

	@AfterSuite
	public void quite() {
		driver.quit();
	}
}
