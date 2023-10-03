package com.gattitude.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gattitude.base.BaseClass;
import com.gattitude.pageObjects.HomePage;
import com.gattitude.pageObjects.LoginPage;
import com.gattitude.utils.Utilities;

public class TC_01_LoginTest extends BaseClass 
{
	public TC_01_LoginTest() {
		super();
	}
	
	public WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		driver = initBrowserOpenApplication();
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
	}
	
	@AfterMethod
	public void tearDown() {
			driver.quit(); 
	}
	
	
	
	@Test(priority=1)
	public void verifyLogin() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(prop.getProperty("validemail"));
		lp.enterPassword(prop.getProperty("validpwd"));
		lp.clickLogin();
			//change in Login test
		Assert.assertTrue(driver.findElement(By.linkText("Edit your xyz account information")).isDisplayed(),"Failed to display");
	}
	
	/*
	@DataProvider
	public Object[][] supplyTestData(){
		Object [][] data = {
				//{"teat1@gmail.com","76832"},
				//{"test2@gmail.com","99999"},
				{"test3@gmail.com","55555"}
		};
		
		return data;
				
	}	*/
	
	

	
	@Test(priority=2,dataProvider="credentialSupplier")
	public void verifyLoginInvalidCreds(String email, String pwd) 
	{
		/*
		driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("invalidemail"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidpwd"));
		*/
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Failed");
	}
	
	@DataProvider(name="credentialSupplier")
	public Object[][] supplyTestData(){
		Object [][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
	@Test(priority=3)
	public void verifyLoginValidEmailInvalidPwd() 
	{

		driver.findElement(By.id("input-email")).sendKeys("pascalron54@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Seleni23dum1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Failed");
	}
	
	@Test(priority=4)
	public void verifyLoginValidEmailValidPwd() 
	{

		driver.findElement(By.id("input-email")).sendKeys("pascaeeelron54@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Failed");
	}
	
	@Test(priority=5)
	public void verifyLoginNoCred() 
	{
//test
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Failed");
	}
	
	
}
