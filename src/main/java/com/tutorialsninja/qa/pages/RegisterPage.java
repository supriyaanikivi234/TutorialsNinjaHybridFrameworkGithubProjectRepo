package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameField;
	

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;

	@FindBy(xpath="//input[@name='telephone']")
	private WebElement tellephoneNumberField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement passwordConfirmationField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content']/p")
	private WebElement actualDuplicateEmailErrorMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement ActualPrivacyWarningMessage;
	
	@FindBy(xpath="//input[@name='firstname']//following-sibling::div")
	private WebElement actualFirstNameWarningMessage;
	
	@FindBy(xpath="//input[@name='lastname']//following-sibling::div")
	private WebElement actualLastNameWarningMessage;
	
	@FindBy(xpath="//input[@name='email']//following-sibling::div")
	private WebElement actualEamilWarningMessage;
	
	@FindBy(xpath="//input[@name='telephone']//following-sibling::div")
	private WebElement actualTelephoneWarningMessage;
	
	@FindBy(xpath="//input[@name='password']//following-sibling::div")
	private WebElement actualPasswordWarningMessage;
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
		public void enterFirstName(String firstNameText)
		{
			firstNameField.sendKeys(firstNameText);
		}
		
		public void enterLastName(String lastNameText)
		{
			lastNameField.sendKeys(lastNameText);
		}
		
		public void enterEmail(String emailText)
		{
			emailField.sendKeys(emailText);
		}
		
		public void enterTellphoneNumber(String tellephoneNumberText)
		{
			tellephoneNumberField.sendKeys(tellephoneNumberText);
		}
		
		public void enterPassword(String passwordText)
		{
			passwordField.sendKeys(passwordText);
		}
		
		public void enterConfirmPassword(String passwordConfirmationText)
		{
			passwordConfirmationField.sendKeys(passwordConfirmationText);
		}
		
		public void selectPrivacyPolicy()
		{
			privacyPolicyField.click();
		}
		
		public AccountSuccessPage clickOnContinueButton()
		{
			continueButton.click();
			return new AccountSuccessPage(driver);
		}
		
		public String retrieveDuplicateEmailErrorMessage() {
			String DuplicateEmailErrorMessage= actualDuplicateEmailErrorMessage.getText();
			return DuplicateEmailErrorMessage;
		}
		
		public String retrievePrivacyWarningMessage() {
			String PrivacyWarningMessage= ActualPrivacyWarningMessage.getText();
			return PrivacyWarningMessage;
		}
		public String retrieveActualFirstNameWarningMessage() {
			String FirstNameWarningMessage= actualFirstNameWarningMessage.getText();
			return FirstNameWarningMessage;
		}
		public String retrieveActualLastNameWarningMessage() {
			String LastNameWarningMessage= actualLastNameWarningMessage.getText();
			return LastNameWarningMessage;
		}
		public String retrieveActualEamilWarningMessage() {
			String EamilWarningMessage= actualEamilWarningMessage.getText();
			return EamilWarningMessage;
		}
		public String retrieveActualTelephoneWarningMessage() {
			String TelephoneWarningMessage= actualTelephoneWarningMessage.getText();
			return TelephoneWarningMessage;
		}
		public String retrieveActualPasswordWarningMessage() {
			String PasswordWarningMessage= actualPasswordWarningMessage.getText();
			return PasswordWarningMessage;
		}
		
		public AccountSuccessPage register(String firstNameText,String lastNameText,String emailText,String tellephoneNumberText,String passwordText,String passwordConfirmationText)
		{
			firstNameField.sendKeys(firstNameText);
			lastNameField.sendKeys(lastNameText);
			emailField.sendKeys(emailText);
			tellephoneNumberField.sendKeys(tellephoneNumberText);
			passwordField.sendKeys(passwordText);
			passwordConfirmationField.sendKeys(passwordConfirmationText);
			privacyPolicyField.click();
			continueButton.click();
			return new AccountSuccessPage(driver);
		}
		
public boolean displayStatusOfWarningMessages(String expectedPrivacyWarningMessage,String expectedFirstNameWarningMessage, String expectedLastNameWarningMessage, String expectedEamilWarningMessage,
		String expctedTelephoneWarningMessage, String expctedPasswordWarningMessage)
		
		{
	boolean PrivacyPolicyWarningStatus= ActualPrivacyWarningMessage.getText().equals(expectedPrivacyWarningMessage);
	boolean FirstNameWarningStatus= actualFirstNameWarningMessage.getText().equals(expectedFirstNameWarningMessage);
	boolean LastNameWarningStatus= actualLastNameWarningMessage.getText().equals(expectedLastNameWarningMessage);
	boolean EmailWarningStatus=  actualEamilWarningMessage.getText().equals(expectedEamilWarningMessage);
	boolean TelephoneWarningStatus=  actualTelephoneWarningMessage.getText().equals(expctedTelephoneWarningMessage);
	boolean PasswordWarningStatus= actualPasswordWarningMessage.getText().equals(expctedPasswordWarningMessage);
	return PrivacyPolicyWarningStatus && FirstNameWarningStatus && LastNameWarningStatus && EmailWarningStatus &&  TelephoneWarningStatus && PasswordWarningStatus;
	
	//String ActualPrivacyWarning= ActualPrivacyWarningMessage.getText();
   //String ActualFirstNameWarning= actualFirstNameWarningMessage.getText();
  //String ActualLastNameWarning= actualLastNameWarningMessage.getText();
  //String ActualEmailWarning=  actualEamilWarningMessage.getText();
 //String ActualTelephoneWarning= actualTelephoneWarningMessage.getText();
 //String ActualPasswordWarning= actualPasswordWarningMessage.getText();
}
}
