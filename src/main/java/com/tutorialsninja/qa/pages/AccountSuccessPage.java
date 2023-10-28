package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
WebDriver driver;
	
	//objects
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement actualSuccessPageHeading;
	
	
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this=HomePage.class//initializing the elements which are on the home page meaning of this sentenece
		
	}
	
	//actions
	public String retrieveAccountSuccessPageHeading()
	{
		String actualSuccessPageHeadingText= actualSuccessPageHeading.getText();
		return actualSuccessPageHeadingText;
	}
	

	
}
