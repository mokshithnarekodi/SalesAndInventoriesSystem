package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSupplierPage {
	WebDriver driver;
	public CreateSupplierPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "companyname")
	private WebElement companyNameEdit;
	
	@FindBy(name="province")
	private WebElement provinceDropdown;
	
	@FindBy(name="city")
	private WebElement cityDropdown;
	
	@FindBy(name = "phonenumber")
	private WebElement phoneNumberEdit;
	public WebElement getCompanyNameEdit() {
		return companyNameEdit;
	}

	public WebElement getProvinceDropdown() {
		return provinceDropdown;
	}

	public WebElement getCityDropdown() {
		return cityDropdown;
	}

	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}
	
}
