package org.Sample.PrashulOrange;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;


public class Shopify extends BaseTest implements ObjectRepository 
{
	WebDriver driver = new ChromeDriver();
	
	
	
	//To launch the Browser
	@BeforeMethod
	public void testbefore() throws InterruptedException 
	{
		
		try 
		{
			ETtest = reports.createTest("Sample Test","This is sample Test");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			//Launch Orange HRM
			driver.get("https://addcyi-hj.myshopify.com/");
			ETtest.log(Status.PASS, "https://addcyi-hj.myshopify.com/");
			
			driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			System.out.println(e);
			ETtest.log(Status.FAIL, "https://addcyi-hj.myshopify.com/");
		}
	}
		
	@Test(priority = 2)
	public void testvalidatePlaceOrder() 
	{
		try
		{
			
			List<WebElement> Products = driver.findElements(productsList);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			for(int i=0; i<2; i++)
			{
				Products.get(i).click();
				Assert.assertEquals("Flash Sale Madness!", driver.findElement(flashSaleText).getText().trim());
				
//				if(!driver.findElement(mostPopularOffer).isSelected())
//				{
//					driver.findElement(mostPopularOffer).click();
//				}
				
				WebElement cartBtn = driver.findElement(addToCartBtn);
				js.executeScript("arguments[0].scrollIntoView(true);", cartBtn);
				driver.findElement(addToCartBtn).click();
				ETtest.log(Status.PASS, "Product is added to cart successfully");
				Thread.sleep(1000);
				driver.navigate().back();
			}
			

			js.executeScript("window.scrollBy(0, -400)", "");
			
			WebElement cartBtn = driver.findElement(Cartbtn);
			js.executeScript("arguments[0].click();", cartBtn);
		
			Assert.assertEquals("Your cart", driver.findElement(CartTitleText).getText().trim());
	
			//js.executeScript("window.scrollBy(0, 400)", "");
			
			WebElement Checkoutbtn = driver.findElement(CheckOutBtn);
			js.executeScript("arguments[0].scrollIntoView(true);", Checkoutbtn);
			js.executeScript("arguments[0].click();", Checkoutbtn);
			
			ETtest.log(Status.PASS, "Product is validated successfully");
			
			driver.findElement(EmailIpBox).sendKeys("Prashul@gmail.com");
			driver.findElement(FirstName).sendKeys("Prashul");
			driver.findElement(LastName).sendKeys("Damkondwar");
			driver.findElement(Address).sendKeys("Pune");
			driver.findElement(ApartmentAdd).sendKeys("Flat no. 123, ABC society, Hinjewadi");
			driver.findElement(City).sendKeys("Pune");
			
			WebElement SelectState = driver.findElement(State);
			
			Select select = new Select(SelectState);
			select.selectByVisibleText("Maharashtra");
			
			driver.findElement(PinCode).sendKeys("411057");
			driver.findElement(CodOrder).click();
			Thread.sleep(1000);
			Thread.sleep(2000);
			driver.findElement(CompleteO).click();					
			ETtest.log(Status.PASS, "Order placed successfully");
		}
		catch (Exception e) 
		{
			System.out.println(e);
			ETtest.log(Status.FAIL, "Failed to place the Order");
		}
	}


		@Test(priority = 1)
		public void VerifyPageTitle() 
		{
			try
			{
				//Launch the URL and verify the title
				String titleName = driver.findElement(titlename).getText();
				Assert.assertEquals(titleName, "Welcome to our store Trendy Nest");				
				
				ETtest.log(Status.PASS, titleName + " Is verified successfully");
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		//To close the Browser
		@AfterTest
		public void teardown() throws InterruptedException
		{
			driver.close();
		}
}
