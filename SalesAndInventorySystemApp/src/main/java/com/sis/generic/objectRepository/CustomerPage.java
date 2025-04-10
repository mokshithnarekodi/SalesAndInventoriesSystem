package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	WebDriver driver;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//a[@data-toggle='modal'])[2]")
	private WebElement createCustomerBtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextEdit;

	@FindBy(xpath = "(//td)[1]")
	private WebElement firstName;

	@FindBy(xpath = "(//td)[2]")
	private WebElement lastName;

	@FindBy(xpath = "(//td)[3]")
	private WebElement phoneNumber;
	
	

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

}
