package com.gattitude.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gattitude.base.Base;
import com.gattitude.pageObjects.HomePage;
import com.gattitude.utils.Utilities;

public class TC_02_SearchTest extends Base {
	
	
	public TC_02_SearchTest() {
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
	
	
	@DataProvider(name="searchItemList")
	public Object[][] supplyTestData(){
		Object [][] data = {{"canon","Fail"},{"phone","iPhone"}};
		return data;
	}

	/*
	@DataProvider(name="searchItemExcel")
	public Object[][] supplyExcelData(){
		Object[][] data = Utilities.getTestDataFromExcel("Login") ;
				return data;
	}
	
	*/
	@Test(dataProvider="searchItemList")
	public void searchItem(String lookupItem, String searchResult) {
		HomePage homepg = new HomePage(driver);
		homepg.enterSearchItem(lookupItem);
		homepg.btnSearchItem();

		String lookingFor = driver.findElement(By.xpath("//div[@id='content']/descendant::h4")).getText();
		System.out.println(lookingFor);
		
		Assert.assertTrue(driver.findElement(By.linkText(searchResult)).isDisplayed());
		
	}
	
	

}
