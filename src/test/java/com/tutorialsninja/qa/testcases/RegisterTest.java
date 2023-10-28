package com.tutorialsninja.qa.testcases;

import com.tutorialsninja.qa.utilities.utilities;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.AccountSuccessPage;


public class RegisterTest extends Base {
 



	public RegisterTest() throws IOException {
		super();
	
	}
	
	public WebDriver driver;
	  RegisterPage registerpage;
	  AccountSuccessPage accountSuccessHeading;
	
	@BeforeMethod
	public void setUp()
	{
	
		  driver= intializeBrowserAndOpenApplication(prop.getProperty("browser"));
           HomePage homepage=new HomePage(driver);
	      registerpage =homepage.naviagateToRegisterPage();
	}

 
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority=1)
	 public void VerifyRegistringAnAccountWithMandatoryFields()
	 {
    accountSuccessHeading=registerpage.register(dataProp.getProperty("firstName"), dataProp.getProperty("lastname"), utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephonenUmber"), prop.getProperty("ValidPassword"), prop.getProperty("ValidPassword"));
 Assert.assertEquals(accountSuccessHeading.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeadingMessage"),"Account success page is not displayed");
	 }
	 
	
	@Test(priority=2)	
	public void verifyRegistringAccountWithExistingEmail()
	{

	accountSuccessHeading=registerpage.register(dataProp.getProperty("firstName"), dataProp.getProperty("lastname"), prop.getProperty("ValidEmail"), dataProp.getProperty("telephonenUmber"), prop.getProperty("ValidPassword"), prop.getProperty("ValidPassword"));
Assert.assertEquals(registerpage.retrieveDuplicateEmailErrorMessage(), dataProp.getProperty("DuplicateEmailErrorMessage"),"Warning message regarding duplicate error message is not displayed");
	}
	
   @Test(priority=3)
	public void verifyRegistringAccountWithoutFillingDeatils()
	{
	   
	   accountSuccessHeading= registerpage.clickOnContinueButton();
    Assert.assertTrue(registerpage.displayStatusOfWarningMessages(dataProp.getProperty("PrivacyWarningMessage"), dataProp.getProperty("FirstNameWarningMessage"), dataProp.getProperty("LastNameWarningMessage"), dataProp.getProperty("EamilWarningMessage"), dataProp.getProperty("TelephoneWarningMessage"), dataProp.getProperty("PasswordWarningMessage")) ,"Warning messages is are not displayed");

	}
}



