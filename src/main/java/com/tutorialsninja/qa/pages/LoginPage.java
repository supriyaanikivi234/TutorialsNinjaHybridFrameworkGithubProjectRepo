package com.tutorialsninja.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement EmailAddressField;
	

	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement ActualWarningMessageEmailPasswordNotMatching;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	/*
		public void EnterEmailAddress(String EmailText)
		{
			EmailAddressField.sendKeys(EmailText);
		}
		
		public void EnterPasswordAddress(String Password)
		{
			PasswordField.sendKeys(Password);
		}
		

		public AccountPage clickOnLoginButton() {
			
			loginButton.click();
			return new AccountPage(driver);
		}
		*/
		
	public AccountPage clickOnLoginButton() {
		
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String EmailText,String Password)
		{
			EmailAddressField.sendKeys(EmailText);
			PasswordField.sendKeys(Password);
			loginButton.click();
			return new AccountPage(driver);
		}


		public String retrievengEmailPaaswordNotMatchingWarningMessageText() {
			String WarningText=ActualWarningMessageEmailPasswordNotMatching.getText();
        	return WarningText;
		}
	
}
