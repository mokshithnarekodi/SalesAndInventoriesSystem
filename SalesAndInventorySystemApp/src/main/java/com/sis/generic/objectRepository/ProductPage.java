package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[@data-toggle='modal'])[2]")
	private WebElement createProductBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextEdit;
	
	@FindBy(xpath = "(//td)[1]")
	private WebElement productode;

	@FindBy(xpath = "(//td)[2]")
	private WebElement productName;

	@FindBy(xpath = "(//td)[3]")
	private WebElement price;
	
	@FindBy(xpath = "(//td)[4]")
	private WebElement category;
	
	public WebElement getcreateProductBtn() {
		return createProductBtn;
	}
	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}
	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}
	public WebElement getProductode() {
		return productode;
	}
	public WebElement getProductName() {
		return productName;
	}
	public WebElement getPrice() {
		return price;
	}
	public WebElement getCategory() {
		return category;
	}
	
	
	

}
