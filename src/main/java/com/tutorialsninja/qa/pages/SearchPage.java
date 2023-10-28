package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	 WebDriver driver;
		
		@FindBy(linkText="HP LP3065")
		private WebElement ValidHpProduct;
		
		@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
		private WebElement noProdcutMessage;
		
		public SearchPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);  //this=HomePage.class//initializing the elements which are on the home page meaning of this sentenece
			
		}
		
		public boolean getDisplayStatusOfHpProduct()
		{
			boolean displayStatusHpProduct=ValidHpProduct.isDisplayed();
			return displayStatusHpProduct; 
	    }
		
		public String retrieveNoProductMessageText()
		{
		 String noProdcutMessageText =noProdcutMessage.getText();
			return noProdcutMessageText; 
	    }
}
