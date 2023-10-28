package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccounTdropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	WebElement RegisterOption;
	
	@FindBy(xpath="//input[@type='text'][@placeholder='Search']")
	WebElement SearchBoxField;
	
	@FindBy(xpath="//button[@type='button'][@class='btn btn-default btn-lg']")
	WebElement SearchButton;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this=HomePage.class//initializing the elements which are on the home page meaning of this sentenece
		
	}
	
	//actions

 public LoginPage naviagateToLoginPage()
	{
		MyAccounTdropMenu.click();
		loginOption.click();
		return new LoginPage(driver); 
	}

	public RegisterPage naviagateToRegisterPage() 
	{
		MyAccounTdropMenu.click();
		RegisterOption.click();
		return new RegisterPage(driver); 
	}

	public SearchPage searchForAProduct(String productName)
	{
		SearchBoxField.sendKeys(productName);
		SearchButton.click();
		return new SearchPage(driver);
	}

	public SearchPage clickOnSearchButton() {
		SearchButton.click();
		return new SearchPage(driver);
		
		
	}
	
	/*
	  	public void enterProductIntoSearchBoxFiled(String productName)
	{
		SearchBoxField.sendKeys(productName);
	}


	public SearchPage clickOnSearchButton() {
		SearchButton.click();
		return new SearchPage(driver);
		
	}
	
	public void selectLoginOption()
	{
		loginOption.click();
	}

	
	public void selectRegisterOption()
	{
		RegisterOption.click();
	}
	public void clickOnMyAccount()
	{
		MyAccounTdropMenu.click();
	}
	
	public LoginPage selectLoginOption()
	{
		loginOption.click();
		return new LoginPage(driver); 
	}
*/
	

	
}
