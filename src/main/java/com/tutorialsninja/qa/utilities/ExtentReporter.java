package com.tutorialsninja.qa.utilities;
import com.aventstack.extentreports.*;
import java.io.*;
import java.util.Properties;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporter {

	public static ExtentReports generatedExentReport() throws IOException
	{
		ExtentReports extentReport = new ExtentReports();
		File f1=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(f1);
        sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Tutorials Ninja automation results");
		sparkReporter.config().setDocumentTitle("TN automation results");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkReporter);
		
		Properties prop= new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis= new FileInputStream(propFile);
		prop.load(fis);
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Application Browser name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Email", prop.getProperty("ValidEmail"));
		extentReport.setSystemInfo("Password", prop.getProperty("ValidPassword"));
		extentReport.setSystemInfo("java.version", System.getProperty("java.version"));
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		
		return extentReport;
	}
}
