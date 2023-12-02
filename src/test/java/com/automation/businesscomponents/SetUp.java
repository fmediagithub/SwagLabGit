package com.automation.businesscomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.common.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	@Test(priority = 1)
	public static void setUpBrowser() {
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		
		WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver(options);

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize(); 
		
		Common.createTestReport(); 
		
		
	}
}
