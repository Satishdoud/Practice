package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	 @FindBy (xpath ="//div[@class='header item']")
	 WebElement crmLogo;
	
     @FindBy (xpath="//span[text()='Satish Doud']")
     WebElement userNameLabel;
     
     @FindBy (xpath="//i[@class='users icon']")
     WebElement contactsLinks;
     
     @FindBy (xpath="(//button[@class='ui mini basic icon button'])[2]")
     WebElement newContactLink;
     
     @FindBy (xpath="//a[@href='/deals']")
     WebElement dealsLink;
     
     @FindBy (xpath="//a[@href='/tasks']")
     WebElement tasksLink;
     
     public HomePage() {
    	 PageFactory.initElements(driver, this);
     }
     
     public boolean validatecrmLogo() {
 		return crmLogo.isDisplayed();
 	}
     
     public boolean verifyUserNameLable() {
    	 return userNameLabel.isDisplayed();
     }
     
     public String verifyHomePageTitle() {
    	 return driver.getTitle();
     }
     
     public ContactsPage clickOnContactsLink() {
    	 contactsLinks.click();
    	return new ContactsPage();
     }
     
     public DealsPage clickOnDealsLink() {
    	 dealsLink.click();
    	 return new DealsPage();
     }
     
     public TaskPage clickOnTaskLink() {
    	 tasksLink.click();
    	 return new TaskPage();
     }
     
     public void clickOnNewContactCreate() {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(contactsLinks).build().perform();
    	 newContactLink.click();
     }
}

