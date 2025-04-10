package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.generic.webdriverutility.WebDriverUtility;

public class CreateProductPage {
	WebDriver driver;
	public CreateProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(name = "prodcode")
	private WebElement prodcodeEdit;
	
	@FindBy(name="name")
	private WebElement nameEdit;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionEdit;
	
	@FindBy(name="quantity")
	private WebElement quantityEdit;
	
	@FindBy(name="onhand")
	private WebElement onhandEdit;
	
	@FindBy(name="price")
	private WebElement priceEdit;

	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//select[@name='supplier']")
	private WebElement supplierDropdown;

	
	@FindBy(xpath = "//input[@placeholder='Date Stock In']")
	private WebElement datestockEdit;
	
	public WebElement getProdcodeEdit() {
		return prodcodeEdit;
	}
	public WebElement getNameEdit() {
		return nameEdit;
	}
	public WebElement getDescriptionEdit() {
		return descriptionEdit;
	}
	public WebElement getQuantityEdit() {
		return quantityEdit;
	}
	public WebElement getOnhandEdit() {
		return onhandEdit;
	}
	public WebElement getPriceEdit() {
		return priceEdit;
	}
	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}
	public WebElement getSupplierDropdown() {
		return supplierDropdown;
	}
	public WebElement getDatestockEdit() {
		return datestockEdit;
	}
	
	public void createProduct(WebDriverUtility wlib, String productcode,String productname, String description,String quantity,String onhand,String price,String category,String companyName,String dateofstock) throws InterruptedException {
	
		prodcodeEdit.sendKeys(productcode);
		nameEdit.sendKeys(productname);
		//Thread.sleep(2000);
		//wlib.mouseMoveOnElement(driver, null);
		//wlib.waitForElementPresent(driver, ppp.getDescriptionEdit());
		//pp.getDescriptionEdit().click();
		wlib.waitForElementToBeClickable(driver, descriptionEdit);
		descriptionEdit.sendKeys(description);
		quantityEdit.sendKeys(quantity);
		onhandEdit.sendKeys(onhand);
		priceEdit.sendKeys(price);
		wlib.select(categoryDropdown, category);
		wlib.select(supplierDropdown, companyName);
		//datestockEdit.sendKeys(dateofstock);
		Actions act=new Actions(driver);
		act.sendKeys(datestockEdit, dateofstock).perform();
		
		datestockEdit.submit();

	}
	


}
