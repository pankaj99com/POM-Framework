package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();// TestBase class constructor will be called

	}

	@BeforeMethod
	public void setup() {
		
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority=1,invocationCount=2)
	public void LoginPageTitleTest() {
		
		String title=loginPage.validateLoginPageTitle();
		log.info("**************Validating Login page title:***************** ");
		Assert.assertEquals(title,"Free CRM  - CRM software for customer relationship management, sales, and support.");
	}
	
	
	@Test(priority=2,invocationCount=3)
	public void CRMLogoTest() {
		boolean logo=loginPage.validateCRMLogo();
		log.info("**************Validating logo of login page:***************** ");
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		log.info("**************entering username and password***************** ");
	homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("*****************Quiting browser**************** ");
		driver.quit();
	}
}
