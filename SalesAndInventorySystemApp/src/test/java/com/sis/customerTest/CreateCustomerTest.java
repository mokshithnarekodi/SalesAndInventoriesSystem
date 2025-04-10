package com.sis.customerTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sis.baseclass.BaseClass;
import com.sis.generic.objectRepository.CreateCustomerPage;
import com.sis.generic.objectRepository.CustomerPage;
import com.sis.generic.objectRepository.HomePage;
import com.sis.generic.objectRepository.LoginPage;
import com.sis.generic.webdriverutility.ThreadLocalUtility;

@Listeners(com.sis.generic.listnerutility.ListenerImplementation.class)

public class CreateCustomerTest extends BaseClass{
	@Test(groups = "integration")
	public void createCustomerTest() throws Throwable {
		String firstname = elib.getDataFromExcel("customer", 1, 2);
		String lastname = elib.getDataFromExcel("customer", 1, 3)+jlib.getRandomNumber();
		String phonenum = elib.getDataFromExcel("customer", 1, 4)+jlib.getRandomNumber();
		
		ThreadLocalUtility.getTest().log(Status.INFO, "login to app");

		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin();
		//driver.switchTo().alert().accept();
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to customerpage");

		HomePage hp=new HomePage(driver);
		hp.getCustomerLink().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to create customerpage");

		CustomerPage cp=new CustomerPage(driver);
		cp.getCreateCustomerBtn().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "create customer by filling all the data");

		CreateCustomerPage ccp=new CreateCustomerPage(driver);
		
		wlib.waitForElementPresent(driver, ccp.getFirstNameEdit());
		ccp.getFirstNameEdit().sendKeys(firstname);
		wlib.waitForElementPresent(driver, ccp.getLastNameEdit());

		ccp.getLastNameEdit().sendKeys(lastname);
		wlib.waitForElementPresent(driver, ccp.getPhoneNumberEdit());

		ccp.getPhoneNumberEdit().sendKeys(phonenum);
		Thread.sleep(1000);
		ccp.getSaveBtn().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "verifying customer creation");

		cp.getSearchTextEdit().sendKeys(firstname+" "+lastname);
		Thread.sleep(500);
		wlib.waitForElementPresent(driver, cp.getFirstName());

		Assert.assertEquals(cp.getFirstName().getText(), firstname);
		ThreadLocalUtility.getTest().log(Status.PASS, "first name verified successfully");
		Thread.sleep(500);
	
		Assert.assertEquals(cp.getLastName().getText(), lastname);
		ThreadLocalUtility.getTest().log(Status.PASS, "last name verified successfully");
		Thread.sleep(500);
		Assert.assertEquals(cp.getPhoneNumber().getText(), phonenum);
		ThreadLocalUtility.getTest().log(Status.PASS, "phone number verified successfully");

	}
	
}
