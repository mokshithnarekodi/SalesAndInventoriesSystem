package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPage {
	WebDriver driver;
	public CreateCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "firstname")
	private WebElement firstNameEdit;
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	@FindBy(name = "phonenumber")
	private WebElement phoneNumberEdit;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement saveBtn;
	public WebElement getFirstNameEdit() {
		return firstNameEdit;
	}
	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}
	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
