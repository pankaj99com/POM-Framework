package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(HomePageTest.class);
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil=new TestUtil();
		
	}
	
	@Test
	public void homePageTitleTest() {
		log.info("**************Validating Home page title:***************** ");
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Tile is incorrect");
		
	}
	@Test
	public void verifyCorrectUserName() {
		log.info("**************switching to frame:***************** ");
		testUtil.switchToFrame();
		
		log.info("**************Validating Username:***************** ");
		homePage.verifyUserName();
		
	}
	
	@Test
	public void contactLinkTest() {
		testUtil.switchToFrame();
		log.info("**************Validating Home page title:***************** ");
		homePage.clickOnContactsLink();
		log.info("**************clicking on Contacts link:***************** ");
		System.out.println(driver.getTitle());
		log.info("**************Validating title:***************** ");
		
		
		
	}
	@Test
	public void dealsLinkTest() {
		testUtil.switchToFrame();
		log.info("**************Validating Home page title:***************** ");
		homePage.clickOnDealsLink();
		log.info("***************clicking on deals link:***************** ");
		System.out.println(driver.getTitle());
		
		
		
	}
	
	@Test
	public void tasksLinkTest() {
		testUtil.switchToFrame();
		log.info("**************Validating Home page title:***************** ");
		homePage.clickOnTasksLink();
		log.info("***************clicking on tasks link:***************** ");
		System.out.println(driver.getTitle());
		
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		log.info("***************Qutiting browser:***************** ");
		driver.quit();
	}
	

}
