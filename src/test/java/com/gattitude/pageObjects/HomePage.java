package com.gattitude.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement dropdownMyAccount;
	
	@FindBy(linkText="Login")
	private WebElement btnLogin;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickMyAccount() {
		dropdownMyAccount.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
