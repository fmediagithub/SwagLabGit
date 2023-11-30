package com.automation.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.businesscomponents.SetUp;
import com.automation.businesscomponents.TestMe;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.api.model.Driver;

public class Common extends TestMe {

	
	//public static File screenshot ;
	
	public static void enterText(By element, String text, String msg) throws IOException {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(text);
			pass("<b>"+msg+" Entered</b>");

		} catch (Exception e) {
			fail("<b>"+msg+" Text Enter Failed</b>");
		}

	}

	public static void clickElemnt(By element, String str) throws IOException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			pass("<b>Clicked on " + str + "</b>");

		} catch (Exception e) {
			fail("click failed "+e.getMessage());
		}

	}

	public static WebElement getElement(By element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static String getText(By element) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(element)).getText();
	}

	public static boolean checkElementpresence(By element) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed();
	}

	public static List<WebElement> getElements(By element) {
		return driver.findElements(element);

	}
	
	public static void selectByText(By element,String text) throws IOException {
		Select select = new Select(getElement(element));
		select.selectByVisibleText(text);
		Common.pass(text+" selected");

	}

	public static void createTestReport() {
  System.out.println("inside  createtest report");
		htmlReporter = new ExtentSparkReporter("extentreportnew.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);

	}
   public static void createTestName(String testname) {
	 extentTest = extentReports.createTest(testname);
	 		extentReports.flush();
	   
   }
	public static void pass(String str) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File("./screenshots/" + UUID.randomUUID() + ".png");
		FileUtils.copyFile(screenshot, dest);
		
		String errflpath = dest.getAbsolutePath();
		//System.out.println(errflpath);
		// extentTest.addScreenCaptureFromPath(errflpath) test level
		extentTest.info(str).pass(MediaEntityBuilder.createScreenCaptureFromPath(errflpath).build());

		extentReports.flush();
	}

	public static void fail(String str) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + UUID.randomUUID() + ".png");
		FileUtils.copyFile(screenshot, dest);

		String errflpath = dest.getAbsolutePath();
		System.out.println(errflpath);
		// extentTest.addScreenCaptureFromPath(errflpath) test level
		extentTest.info(str).fail(MediaEntityBuilder.createScreenCaptureFromPath(errflpath).build());

		extentReports.flush();
	}

	public static void info(String str) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + UUID.randomUUID() + ".png");
		FileUtils.copyFile(screenshot, dest);

		String errflpath = dest.getAbsolutePath();
		System.out.println(errflpath);
		// extentTest.addScreenCaptureFromPath(errflpath) test level
		extentTest.info(str).info(MediaEntityBuilder.createScreenCaptureFromPath(errflpath).build());

		extentReports.flush();
	}
	
	
	public static String getDatFromExcel(String str) throws IOException {
		FileInputStream file = new FileInputStream("./TestData/data.xlsx");
		ArrayList<String> list = new ArrayList<String>();
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row headerRow = sheet.getRow(0); 
		for (Row row : sheet) {
			for (Cell cell : row) {
				list.add(cell.getStringCellValue());

			}

		}
	

		return list.get(list.indexOf(str) + 1);
	}
}