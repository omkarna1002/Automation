package practice.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class home extends TestBase{
	public static WebDriver driver;	
	static HashMap<String, String> hm = new HashMap<String, String>();
	public home(WebDriver driver) throws IOException
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	public static WebElement electronics;
	
	@FindBy(xpath="//a[@title='Apple']")
	public static WebElement apple;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	public static WebElement alt;
	
	@FindBy(xpath="//div[@class='t-0M7P _2doH3V']/descendant::img[@alt='iPhone 7 Plus X3 for Store']/../..")
	public static WebElement iphone7;
	
	@FindBy(xpath="//div[text()='Apple iPhone 7 Plus (Black, 32 GB)']/../../div[2]/div/div/div")
	public static WebElement iphone7black;
	
	@FindBy(xpath="//div[text()='Apple iPhone 7 Plus (Rose Gold, 32 GB)']/../../div[2]/div/div/div")
	public static WebElement iphone7rosegold;
	
	
	public void getphone() throws AWTException, InterruptedException, IOException
	{
		hm= excel_reader.setMapData();	
		alt.click();					  
		WebDriverWait wb = new WebDriverWait(driver, 5);
		wb.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Electronics')]")));
		Actions act = new Actions(driver);
		act.moveToElement(electronics).build().perform();
		wb.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Apple']")));
		act.moveToElement(apple).click().build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		iphone7.click();
		Thread.sleep(4000);
		Assert.assertEquals(iphone7black.getText(), hm.get("Apple iPhone 7 Plus (Black, 32 GB)"));
		Assert.assertEquals(iphone7rosegold.getText(), hm.get("Apple iPhone 7 Plus (Rose Gold, 32 GB)"));
		
	}
	
}
