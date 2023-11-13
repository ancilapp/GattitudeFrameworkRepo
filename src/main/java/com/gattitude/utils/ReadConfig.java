package com.gattitude.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
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
	
	public String getApplicationUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getUserName() {
		String userName = prop.getProperty("validemail");
		return userName;
	}
	
	public String getPassword() {
		String Password = prop.getProperty("validpwd");
		return Password;
	}
}
