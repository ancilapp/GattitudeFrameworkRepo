package com.gattitude.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
		public static ExtentReports generateExtentReport() {
			
			ExtentReports extentReport = new ExtentReports();
			File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
			
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setReportName("Gattitude Test Results");
			sparkReporter.config().setDocumentTitle("Gattitude Automation Report");
			sparkReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm");
			
			extentReport.attachReporter(sparkReporter);
			
			Properties configProp = new Properties();
			File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\gattitude\\config\\config.properties");
			try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
			}catch(Throwable e) {
				e.printStackTrace();
			}
			extentReport.setSystemInfo("Application url", configProp.getProperty("url"));
			extentReport.setSystemInfo("Email", configProp.getProperty("validemail"));
			extentReport.setSystemInfo("Password", configProp.getProperty("validpwd"));
			extentReport.setSystemInfo("OS", System.getProperty("os.name"));
			extentReport.setSystemInfo("Username", System.getProperty("user.name"));
			extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
			
			return extentReport;
		}
}
