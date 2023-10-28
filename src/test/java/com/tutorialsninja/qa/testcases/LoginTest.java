package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utilities.utilities;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.AccountPage;


public class LoginTest extends Base {
	

	
	public LoginTest() throws IOException
	{
		super();
	}
	
	public WebDriver driver;
	LoginPage loginpage;
	AccountPage accountpage;
	
	@BeforeMethod
	public void setUp()
	{
         driver= intializeBrowserAndOpenApplication(prop.getProperty("browser"));
         HomePage homepage=new HomePage(driver);
        loginpage= homepage.naviagateToLoginPage();
	}
	
 
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="valiDataCredntialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) throws InterruptedException
	{
		accountpage=loginpage.login(email, password);
	    Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your login Deatils if login is failed");
	    Thread.sleep(2000);
	}
	
	@DataProvider(name="valiDataCredntialsSupplier")
	public Object[][] supplyTestData() throws IOException
	{
		Object[][] data= utilities.getTestdataFromExecel("Login");
		return data;
	}
	
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials()
	{
		accountpage=loginpage.login(utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
        Assert.assertEquals(loginpage.retrievengEmailPaaswordNotMatchingWarningMessageText(), dataProp.getProperty("EmailPasswordNotMatchingWarning"),"Expected warning message is not displayed");

	}
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailInvalidPassword()
	{
		accountpage=loginpage.login(prop.getProperty("ValidEmail"), dataProp.getProperty("invalidPassword"));
   Assert.assertEquals(loginpage.retrievengEmailPaaswordNotMatchingWarningMessageText(), dataProp.getProperty("EmailPasswordNotMatchingWarning"),"Expected warning message is not displayed");
	
	}
	
	@Test(priority=4)
	public void verifyLoginWithInValidEmailvalidPassword()
	{
		accountpage=loginpage.login(utilities.generateEmailWithTimeStamp(), prop.getProperty("ValidPassword"));
      Assert.assertEquals(loginpage.retrievengEmailPaaswordNotMatchingWarningMessageText(), dataProp.getProperty("EmailPasswordNotMatchingWarning"),"Expected warning message is not displayed");
		
	}
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials()
	{
     accountpage=loginpage.clickOnLoginButton();
    Assert.assertEquals(loginpage.retrievengEmailPaaswordNotMatchingWarningMessageText(), dataProp.getProperty("EmailPasswordNotMatchingWarning"),"Expected warning message is not displayed");
		
	}
	
	
}
