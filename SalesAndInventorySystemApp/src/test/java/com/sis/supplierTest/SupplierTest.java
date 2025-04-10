package com.sis.supplierTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sis.baseclass.BaseClass;
import com.sis.generic.objectRepository.CreateSupplierPage;
import com.sis.generic.objectRepository.HomePage;
import com.sis.generic.objectRepository.LoginPage;
import com.sis.generic.objectRepository.SupplierPage;
import com.sis.generic.webdriverutility.ThreadLocalUtility;

@Listeners(com.sis.generic.listnerutility.ListenerImplementation.class)

public class SupplierTest extends BaseClass {

	@Test(groups="smoke")
	public void createSupplierTest() throws Throwable, Throwable {
		String companyName = elib.getDataFromExcel("supplier", 1, 2) + jlib.getRandomNumber();
		String provience = elib.getDataFromExcel("supplier", 1, 3);
		String city = elib.getDataFromExcel("supplier", 1, 4);
		String phonenum = elib.getDataFromExcel("supplier", 1, 5) + jlib.getRandomNumber();

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
		
	}
}
