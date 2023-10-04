package com.gattitude.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gattitude.base.BaseClass;
import com.gattitude.pageObjects.HomePage;
import com.gattitude.utils.Utilities;

public class TC_02_SearchTest extends BaseClass {
	
	
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
		Object [][] data = {{"canon","test"},{"phone","iPhone"}};
		return data;
	}
	
	@Test(dataProvider="searchItemList")
	public void searchItem(String lookupItem, String searchResult) {
		HomePage homepg = new HomePage(driver);
		homepg.enterSearchItem(lookupItem);
		homepg.btnSearchItem();
		
	}
	
	

}
