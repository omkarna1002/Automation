package practice.demo;

import java.awt.AWTException;
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


import com.relevantcodes.extentreports.LogStatus;


public class homepage extends TestBase {
	static home homePage;
	static WebDriver driver;
	
	public homepage() {
		super();
	}
	
	@BeforeMethod
	public void set() throws IOException {
		driver= initialization();				
	}
		
	@Test()

	public void selectphone() throws AWTException, InterruptedException, IOException {

		home homePage= PageFactory.initElements(driver, home.class);
		homePage.getphone();

	}	
}