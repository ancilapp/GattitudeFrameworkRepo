package com.gattitude.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gattitude.utils.Utilities;

public class BaseClass {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public BaseClass() {
		
		dataprop = new Properties();
		File datapropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\gattitude\\testData\\testdata.properties");
		
		try {
			FileInputStream fis = new FileInputStream(datapropFile);
			dataprop.load(fis);
			}catch(Throwable e) 
				{
						e.printStackTrace();
				}
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\gattitude\\config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			}catch(Throwable e) 
				{
						e.printStackTrace();
				}
	}
		
	public WebDriver initBrowserOpenApplication() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
}
