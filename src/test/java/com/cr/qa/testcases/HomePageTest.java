package com.cr.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsLink;
	TaskPage taskLink;
	
	public HomePageTest()
	{
		super();
	}
	
    @BeforeMethod
    public void setUP() {
      initialization();
      contactsPage = new ContactsPage();
      dealsLink= new DealsPage();
      taskLink= new TaskPage();
      loginPage = new LoginPage();
      homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    @Test (priority=3)
	public void crmLogoImageTest() {
	  boolean flag=homePage.validatecrmLogo();
	  Assert.assertTrue(flag);
    }
    
    @Test (priority=2)
    public void verifyUserNameLabelTest() {
    	Assert.assertTrue(homePage.verifyUserNameLable());
    }
    
    @Test (priority=1)
    public void verifyHomePageTitleTest() {
    	String homePageTitle=homePage.verifyHomePageTitle();
    	Assert.assertEquals(homePageTitle, "Cogmento CRM", "Homepage title is not match");
    }
    
    @Test (priority=4)
    public void contactsLinkTest() {
    	contactsPage=homePage.clickOnContactsLink();
    }
    
    @Test (priority=5)
    public void dealsLinkTest() {
    	dealsLink=homePage.clickOnDealsLink();
    }
    
    @Test (priority=6)
    public void  taskLinkTest() {
    	taskLink=homePage.clickOnTaskLink();
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
    
}
