package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement profileImage;
	
	@FindBy(partialLinkText = "Logout")
	private WebElement logout_Link;
	
	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement alert_Logout;
	
	
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customerLink;
	
	@FindBy(xpath = "//span[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath = "//span[text()='POS']")
	private WebElement POSLink;
	
	@FindBy(xpath = "//span[text()='Supplier']")
	private WebElement supplierLink;
	@FindBy(xpath = "//span[text()='Inventory']")
	private WebElement inventoryLink;
	@FindBy(xpath = "//span[text()='Product']")
	private WebElement productLink;
	
	public WebElement getProfileImage() {
		return profileImage;
	}


	public WebElement getSupplierLink() {
		return supplierLink;
	}


	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getLogout_Link() {
		return logout_Link;
	}


	public WebElement getAlert_Logout() {
		return alert_Logout;
	}


	public WebElement getCustomerLink() {
		return customerLink;
	}
	
	
	public WebElement getHomeLink() {
		return homeLink;
	}
	

	public WebElement getPOSLink() {
		return POSLink;
	}

	
	public WebElement getInventoryLink() {
		return inventoryLink;
	}


	public void logOutFromApp()
	{
		profileImage.click();
		logout_Link.click();
		alert_Logout.click();	
	}	
	
	

}
