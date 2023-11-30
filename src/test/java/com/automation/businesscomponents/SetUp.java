package com.automation.businesscomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.common.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@Test(priority = 1)
	public static void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize(); 
		
		Common.createTestReport(); 
		
		
	}
}
