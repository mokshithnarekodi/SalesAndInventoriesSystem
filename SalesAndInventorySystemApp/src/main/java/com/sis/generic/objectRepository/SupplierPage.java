package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierPage {
	WebDriver driver;
	public SupplierPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[@data-toggle='modal'])[2]")
	private WebElement createSupplierBtn;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextEdit;
	
	@FindBy(xpath = "(//td)[1]")
	private WebElement companyName;

	@FindBy(xpath = "(//td)[2]")
	private WebElement provience;

	@FindBy(xpath = "(//td)[3]")
	private WebElement city;
	
	@FindBy(xpath = "(//td)[4]")
	private WebElement phoneNumber;
	
	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}

	public WebElement getCreateSupplierBtn() {
		return createSupplierBtn;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getProvience() {
		return provience;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}
	

}
