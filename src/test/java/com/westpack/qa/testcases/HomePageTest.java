package com.westpack.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.westpack.qa.base.TestBase;
import com.westpack.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	static HomePage homePage;
	static WebDriver driver;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void set() throws IOException {
		driver= initialization();				
	}
		
	@Test(priority=1)
	@Parameters({"column"})
	public void Taxcalculation(Integer column) {
		logger=extent.startTest("Westpac Test Suite");
		HomePage homePage= PageFactory.initElements(driver, HomePage.class);				
       	homePage.taxrate_display(column);	
		homePage.checkmessageicon();	
		homePage.finaltaxrate();	
	}
		
	@AfterMethod
	public void failedscreenshot(ITestResult result1)
	{
		screenShot(result1);
	}
	

}
