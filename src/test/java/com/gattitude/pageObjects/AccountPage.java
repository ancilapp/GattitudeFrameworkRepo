package com.gattitude.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountPage {

	WebDriver driver;
	
	//Objects
	@FindBy(linkText="Edit your account information")
	private WebElement lnkEditAccountInfo;
	
	//Actions
	public void accountPageDisplayed() {
		Assert.assertTrue(lnkEditAccountInfo.isDisplayed());
	}
}
