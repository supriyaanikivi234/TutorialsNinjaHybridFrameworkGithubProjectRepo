package com.tutorialsninja.qa.base;

import java.time.Duration;
import java.util.*;
import java.io.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utilities.utilities;

import org.openqa.selenium.WebDriver;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() throws IOException
	{
		prop= new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis= new FileInputStream(propFile);
		prop.load(fis);
		
		
		dataProp= new Properties();
		File propFile1= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream fis1= new FileInputStream(propFile1);
		dataProp.load(fis1);
		
	}
	
	public WebDriver intializeBrowserAndOpenApplication(String browserName)
	{


					if(browserName.equalsIgnoreCase("chrome"))
					{
						driver= new ChromeDriver();	
						
					}else if(browserName.equalsIgnoreCase("firefox"))
					{
						driver= new FirefoxDriver();
						
					}else if(browserName.equalsIgnoreCase("edge"))
					{
						driver= new EdgeDriver();
						
					}else if(browserName.equalsIgnoreCase("safari"))
					{
						driver= new SafariDriver();
					}
					
					//opera depricated, ie is also disconnuiting
				
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.implicitly_Wait));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.pageLoadTime));
					driver.get(prop.getProperty("url"));
					
					return driver;
	}
}
