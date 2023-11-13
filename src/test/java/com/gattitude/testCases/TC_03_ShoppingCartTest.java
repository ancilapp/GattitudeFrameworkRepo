package com.gattitude.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gattitude.base.Base;
import com.gattitude.pageObjects.HomePage;

public class TC_03_ShoppingCartTest extends Base {

	public TC_03_ShoppingCartTest() {
		super();
	}
	
	public WebDriver driver;

	HomePage homepg = new HomePage(driver);

	@BeforeMethod
	public void setUp() {
		driver = initBrowserOpenApplication();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); 		
	}
	
	@Test(priority=1)
	public void shoppingCartDisplayedOnHomePage() {
		Assert.assertTrue(driver.findElement(By.id(prop.getProperty("lnkshoppingcart"))).isDisplayed());
	}
	/*
	@Test(priority=2)
	public void addItemToShoppingCart() {
		
	}
	*/
}
