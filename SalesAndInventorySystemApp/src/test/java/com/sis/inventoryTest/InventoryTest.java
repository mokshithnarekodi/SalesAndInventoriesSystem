package com.sis.inventoryTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sis.baseclass.BaseClass;
import com.sis.generic.objectRepository.CreateProductPage;
import com.sis.generic.objectRepository.CreateSupplierPage;
import com.sis.generic.objectRepository.HomePage;
import com.sis.generic.objectRepository.InventoryPage;
import com.sis.generic.objectRepository.LoginPage;
import com.sis.generic.objectRepository.ProductPage;
import com.sis.generic.objectRepository.SupplierPage;
import com.sis.generic.webdriverutility.ThreadLocalUtility;

@Listeners(com.sis.generic.listnerutility.ListenerImplementation.class)

public class InventoryTest extends BaseClass{
	
	@Test(groups = "system")
	public void createProductandVerifyInventoryTest() throws IOException, Throwable {
		String companyName = elib.getDataFromExcel("supplier", 1, 2) + jlib.getRandomNumber();
		String provience = elib.getDataFromExcel("supplier", 1, 3);
		String city = elib.getDataFromExcel("supplier", 1, 4);
		String phonenum = elib.getDataFromExcel("supplier", 1, 5) + jlib.getRandomNumber();
		
		String productcode = elib.getDataFromExcel("product", 1, 2) + jlib.getRandomNumber();
		String productname = elib.getDataFromExcel("product", 1, 3)+ jlib.getRandomNumber();
		String description = elib.getDataFromExcel("product", 1, 4);
		String quantity = elib.getDataFromExcel("product", 1, 5);
		String onhand = elib.getDataFromExcel("product", 1, 6) ;
		String price = elib.getDataFromExcel("product", 1, 7);
		String category =elib.getDataFromExcel("product", 1, 8);
		String dateofstock = jlib.getSystemDateYYYYMMDD();

		ThreadLocalUtility.getTest().log(Status.INFO, "login to app");
		LoginPage lp = new LoginPage(driver);
		lp.loginAsAdmin();
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to supplier page");
		HomePage hp = new HomePage(driver);
		hp.getSupplierLink().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to create supplier page");
		SupplierPage sp = new SupplierPage(driver);
		sp.getCreateSupplierBtn().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "create supplier by filling all data");
		CreateSupplierPage csp = new CreateSupplierPage(driver);
		wlib.waitForElementToBeClickable(driver, csp.getCompanyNameEdit());
		csp.getCompanyNameEdit().sendKeys(companyName);
		wlib.waitForElementToBeClickable(driver, csp.getProvinceDropdown());
		wlib.select(csp.getProvinceDropdown(), provience);
		wlib.waitForElementToBeClickable(driver, csp.getCityDropdown());
		wlib.select(csp.getCityDropdown(), city);
		wlib.waitForElementToBeClickable(driver, csp.getPhoneNumberEdit());
		csp.getPhoneNumberEdit().sendKeys(phonenum);
		csp.getPhoneNumberEdit().submit();
		
		ThreadLocalUtility.getTest().log(Status.INFO, "verify the supplier creation");
		sp.getSearchTextEdit().sendKeys(companyName);
		Thread.sleep(500);
		wlib.waitForElementPresent(driver, sp.getCompanyName());
		Assert.assertEquals(sp.getCompanyName().getText(), companyName);
		ThreadLocalUtility.getTest().log(Status.PASS, "company name verified successfully");

		Assert.assertEquals(sp.getProvience().getText(), provience);
		ThreadLocalUtility.getTest().log(Status.PASS, "provience name verified successfully");

		Assert.assertEquals(sp.getCity().getText(), city);
		ThreadLocalUtility.getTest().log(Status.PASS, "city verified successfully");

		Assert.assertEquals(sp.getPhoneNumber().getText(), phonenum);
		ThreadLocalUtility.getTest().log(Status.PASS, "phone number verified successfully");

		ThreadLocalUtility.getTest().log(Status.PASS, "supplier created successfully");
		
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to product page");
		hp.getProductLink().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to create product page");
		ProductPage ppp = new ProductPage(driver);
		ppp.getcreateProductBtn().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "create product by filling all the details");
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(wlib, productcode, productname, description, quantity, onhand, price, category, companyName,dateofstock);
		ThreadLocalUtility.getTest().log(Status.INFO, "verifying the product creation");
		ppp.getSearchTextEdit().sendKeys(productname);
		Thread.sleep(500);
		wlib.waitForElementPresent(driver, ppp.getProductode());
		Assert.assertEquals(ppp.getProductode().getText(), productcode);
		ThreadLocalUtility.getTest().log(Status.PASS, "productcode verified successfully");

		Assert.assertEquals(ppp.getProductName().getText(), productname);
		ThreadLocalUtility.getTest().log(Status.PASS, "product name verified successfully");

		Assert.assertEquals(ppp.getPrice().getText(), price);
		ThreadLocalUtility.getTest().log(Status.PASS, "price verified successfully");

		Assert.assertEquals(ppp.getCategory().getText(), category);
		ThreadLocalUtility.getTest().log(Status.PASS, "category verified successfully");
		ThreadLocalUtility.getTest().log(Status.PASS, "product created successfully");
		
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to inventory page");
		hp.getInventoryLink().click();
		
		ThreadLocalUtility.getTest().log(Status.INFO, "verifying the product in inventory page");
		InventoryPage ip=new InventoryPage(driver);
		ip.getSearchTextEdit().sendKeys(productname);
		
		Thread.sleep(500);
		wlib.waitForElementPresent(driver, ip.getProductode());
		Assert.assertEquals(ip.getProductode().getText(), productcode);
		ThreadLocalUtility.getTest().log(Status.PASS, "productcode verified successfully in inventory page");

		Assert.assertEquals(ip.getProductName().getText(), productname);
		ThreadLocalUtility.getTest().log(Status.PASS, "product name verified successfully in inventory page");

		Assert.assertEquals(ip.getQuantity().getText(), quantity);
		ThreadLocalUtility.getTest().log(Status.PASS, "quantity verified successfully in inventory page");
		
		Assert.assertEquals(ip.getOnHand().getText(), quantity);
		ThreadLocalUtility.getTest().log(Status.PASS, "onhand quantity verified successfully in inventory page");
		
		Assert.assertEquals(ip.getCategory().getText(), category);
		ThreadLocalUtility.getTest().log(Status.PASS, "category verified successfully in inventory page");
	}


}
