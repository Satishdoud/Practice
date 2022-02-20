package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy (xpath = "//input[contains(@name, 'email')]")
	WebElement username;
	
	@FindBy (xpath = "//input[contains(@name,'password')]")
	WebElement password;
	
	@FindBy (xpath = "/html/body/div[1]/div/div/form/div/div[4]")
	WebElement loginBtn;
	
	@FindBy (xpath = "//a[text()='Sign Up']")
	WebElement signUpBtn;
	
//	@FindBy (xpath ="//img[@class='img-responsive']")
//	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver , this);
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();		
	}
//	public boolean validatecrmLogo()
//	{
//		return crmLogo.isDisplayed();
//	}
	public HomePage login(String un, String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	

}
