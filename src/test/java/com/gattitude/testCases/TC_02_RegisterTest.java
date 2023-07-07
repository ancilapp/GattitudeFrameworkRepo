package com.gattitude.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gattitude.base.BaseClass;

public class TC_02_RegisterTest extends BaseClass
{
	public TC_02_RegisterTest() {
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = initBrowserOpenApplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
	public void tearDown() {
			driver.quit(); 
	}
	
	@Test(priority=1)
	public void verifyRegisterationPageDiaplyed() 
	{

		String actualLabel = driver.findElement(By.xpath("//*[contains(@for,'input-firstname')]")).getText();
		String expectedLabel = "First Name";
		System.out.println(actualLabel);
		Assert.assertTrue(actualLabel.contains(expectedLabel), "Failed");
		//testing normal push//
		
	}
	
	@Test(priority=2)
	public void selectYesForNewsletter() 
	{

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
	}
	
}
