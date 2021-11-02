package com.qa.stepDefinitions;

import org.junit.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomePageSteps extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	@Given("user opens browser")
	public void user_opens_browser() {
	   TestBase.initialization();
	}

	@Then("user is on Login Page")
	public void user_is_on_Login_Page() {
		loginPage=new LoginPage();
	 String title= loginPage.validateLoginPageTitle();
	 Assert.assertEquals("CRMPRO Log In Screen", title);
	}

	@Then("^user logs into app$")
	public void user_logs_into_app() {
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Then("Validate Home page title")
	public void validate_Home_page_title() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO",title);
	}

	@Then("validate loggedIn username")
	public void validate_loggedIn_username() {
		testUtil=new TestUtil();
		testUtil.switchToFrame();
		
		
		homePage.verifyUserName();
		
	}
	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
		
	}


}
