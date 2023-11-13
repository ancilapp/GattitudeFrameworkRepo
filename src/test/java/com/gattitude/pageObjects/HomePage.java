package com.gattitude.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement dropdownMyAccount;
	
	@FindBy(linkText="Login")
	private WebElement btnLogin;
	
	@FindBy(name="search")
	private WebElement txtSearchItem;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement btnSearch;
	

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
	
	public void enterSearchItem(String item) {
		txtSearchItem.sendKeys(item);
	}
	
	public void btnSearchItem() {
		btnSearch.click();
	}
	

	
}
