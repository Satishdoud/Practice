package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
 
	@FindBy (xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy (xpath = "//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy (xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy (xpath = "(//input[@class='search'])[1]")
	WebElement companyName;
	
	@FindBy (xpath = "//input[@placeholder='Email address']")
	WebElement emailId;
	
	@FindBy (xpath ="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
//	@FindBy (xpath = "//div[@class='ui header item mb5 light-black']")
//	WebElement 
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[4]
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).click();
	}
	
	public void createNewContact(String ftname, String ltname, String cmpyname, String eid, String category, String status,  String channel, String time) {
		Select s1=new Select(driver.findElement(By.name("category")));
		s1.selectByVisibleText(category);
		
		Select s2=new Select(driver.findElement(By.name("status")));
		s2.selectByVisibleText(status);
		
		Select s3=new Select(driver.findElement(By.name("channel_type")));
		s3.selectByVisibleText(channel);
		
		Select s4=new Select(driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[3]")));
		s4.selectByVisibleText(time);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		companyName.sendKeys(cmpyname);
		emailId.sendKeys(eid);
		saveBtn.click();
	}
}
