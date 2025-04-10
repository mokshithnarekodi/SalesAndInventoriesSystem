package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebDriver driver;
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextEdit;
	
	@FindBy(xpath = "(//td)[1]")
	private WebElement productode;

	@FindBy(xpath = "(//td)[2]")
	private WebElement productName;
	
	@FindBy(xpath = "(//td)[3]")
	private WebElement quantity;
	
	@FindBy(xpath = "(//td)[4]")
	private WebElement onHand;
	
	@FindBy(xpath = "(//td)[5]")
	private WebElement category;
	
	
	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}
	
	public WebElement getProductode() {
		return productode;
	}
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getCategory() {
		return category;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getOnHand() {
		return onHand;
	}
	
	
}
