package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;


public class SearchTest extends Base  {

	public WebDriver driver;
	SearchPage serachpage;
	   HomePage homepage;
	
	public SearchTest() throws IOException
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
   driver= intializeBrowserAndOpenApplication(prop.getProperty("browser"));
   homepage=new HomePage(driver);
	}


	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() throws InterruptedException
	{
		serachpage=homepage.searchForAProduct(dataProp.getProperty("ValidProduct"));
        Assert.assertTrue(serachpage.getDisplayStatusOfHpProduct(), "the poduct HP LP3065 is not displayed");
		Thread.sleep(2000);	
	}
	@Test(priority=2)
	public void verifySearchWithInValidProduct() throws InterruptedException
	{
		serachpage=homepage.searchForAProduct(dataProp.getProperty("InvalidProduct"));
         Assert.assertEquals(serachpage.retrieveNoProductMessageText(),dataProp.getProperty("NoProductTextSearchResults"),"no product that matches the search criteria- message is  not displayed");
         Assert.assertTrue(false);
         Thread.sleep(2000);	
     
	}
	@Test(priority=3, dependsOnMethods= {"verifySearchWithInValidProduct"})
	public void verifySearchWithoutAnyProduct() throws InterruptedException
	{
		serachpage=homepage.clickOnSearchButton();
    Assert.assertEquals(serachpage.retrieveNoProductMessageText(),dataProp.getProperty("NoProductTextSearchResults"),"no product that matches the search criteria- message is  not displayed");
		Thread.sleep(2000);	
        
	}
}
