package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	//form[@id="vContactsForm"]/table/tbody/child::tr//a[@context='contact']

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;	
	
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateContactLabel() {
		
		boolean visible=contactsLabel.isDisplayed();
		
		Assert.assertTrue(visible);
	}
	
	
	public void searchUser(String name) {
		WebElement present=driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"));
		boolean b=present.isDisplayed();
		Assert.assertTrue(b);
	}
	
	
	public void createNewContact(String usertitle,String fn,String ln,String comp) {
		
		
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(usertitle);
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		company.sendKeys(comp);
		saveBtn.click();
	}
}
