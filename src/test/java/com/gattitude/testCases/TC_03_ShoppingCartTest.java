package com.gattitude.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gattitude.base.Base;
import com.gattitude.pageObjects.HomePage;

public class TC_03_ShoppingCartTest extends Base {

	
	public TC_03_ShoppingCartTest() {
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		driver = initBrowserOpenApplication();		
	}
	
	@AfterMethod
	public void tearDown() {
			driver.quit(); 
	}
	
}
