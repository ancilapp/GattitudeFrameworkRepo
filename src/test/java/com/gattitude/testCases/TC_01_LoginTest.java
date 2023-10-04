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
	public void verifyLoginWithValidCreds() 
	{
		LoginPage lp = new LoginPage(driver);
			//prop.getProperty("validemail")
			//prop.getProperty("validpwd")
		lp.enterEmail(prop.getProperty("validemail"));
		lp.enterPassword(prop.getProperty("validpwd"));
		lp.clickLogin();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Failed to display");
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCreds() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(prop.getProperty("validemail"));
		lp.enterPassword("Wrong");
		lp.clickLogin();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Failed");
	}
	

	
	
	
		
}
