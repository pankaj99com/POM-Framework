package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	
	@FindBy(xpath = "//td[contains(text(),'User: Gayatri das')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasksLink;

	// Initializing the Page Objects

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}
	public boolean verifyUserName() {
		
		String username=userNameLabel.getText();
		Assert.assertEquals(username,"  User: Gayatri das","Incorrect username");
		return false;
	}


	public ContactsPage clickOnContactsLink() {
		
		contactsLink.click();

		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		
		dealsLink.click();

		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		
		tasksLink.click();

		return new TasksPage();
	}
	
	public void clickOnNewContact() throws InterruptedException {
		
		Actions action=new Actions(driver);
		
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(4000);
		newContactLink.click();
		
	}
}
