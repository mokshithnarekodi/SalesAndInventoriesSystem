package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSpage {
	WebDriver driver;
	public POSpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Keyboard")
	private WebElement keyboardLink;
	
	
	@FindBy(xpath = "(//input[@value='Add'])[1]")
	private WebElement addProductBtn;
	
	@FindBy(name="customer")
	private WebElement customerDropdown;
	
	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "(//span)[8]")
	private WebElement proceedToPaymentBtn;
	@FindBy(name="cash")
	private WebElement cashEdit;
	@FindBy(linkText = "Mouse")
	private WebElement mouseLink;
	@FindBy(xpath = "(//td)[1]")
	private WebElement productInCart;
	
	
	public WebElement getProductInCart() {
		return productInCart;
	}

	public WebElement getMouseLink() {
		return mouseLink;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public WebElement getKeyboardLink() {
		return keyboardLink;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getCustomerDropdown() {
		return customerDropdown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	public WebElement getProceedToPaymentBtn() {
		return proceedToPaymentBtn;
	}

	public WebElement getCashEdit() {
		return cashEdit;
	}
	
	


}
