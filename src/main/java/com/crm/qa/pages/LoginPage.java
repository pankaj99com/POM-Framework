package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//LoginPage Page Factory--OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement crmLogo;
	
	
	//Initialize the ELEMENTS
	public LoginPage() {
		
		PageFactory.initElements(driver,this );//or use(driver,this)-to refer to current class
	}
	
	//Actions or Methods
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new  HomePage();
	}
}
