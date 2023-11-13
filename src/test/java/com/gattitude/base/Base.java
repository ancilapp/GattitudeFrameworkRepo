package com.gattitude.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.gattitude.utils.ReadConfig;
import com.gattitude.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationUrl();

	public Base() {
		
		dataprop = new Properties();
		File datapropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\gattitude\\testData\\testdata.properties");
		
		try {
			FileInputStream fis = new FileInputStream(datapropFile);
			dataprop.load(fis);
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
		driver.get(baseURL);
		
		return driver;
	}
	

}
