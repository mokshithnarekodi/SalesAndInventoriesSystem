package com.sis.customerTest;

import org.openqa.selenium.JavascriptExecutor;
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
		//hp.getCustomerLink().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", hp.getCustomerLink());
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to create customerpage");

		CustomerPage cp=new CustomerPage(driver);
		
        js.executeScript("arguments[0].click();", cp.getCreateCustomerBtn());
		//cp.getCreateCustomerBtn().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "create customer by filling all the data");

		CreateCustomerPage ccp=new CreateCustomerPage(driver);
		
		wlib.waitForElementPresent(driver, ccp.getFirstNameEdit());
		//ccp.getFirstNameEdit().sendKeys(firstname);
		js.executeScript("arguments[0].value='"+firstname+"';", ccp.getFirstNameEdit());

		wlib.waitForElementPresent(driver, ccp.getLastNameEdit());
		js.executeScript("arguments[0].value='"+lastname+"';", ccp.getLastNameEdit());

		//ccp.getLastNameEdit().sendKeys(lastname);
		wlib.waitForElementPresent(driver, ccp.getPhoneNumberEdit());
		js.executeScript("arguments[0].value='"+phonenum+"';", ccp.getPhoneNumberEdit());

		//ccp.getPhoneNumberEdit().sendKeys(phonenum);
		//ccp.getSaveBtn().click();
        js.executeScript("arguments[0].click();", ccp.getSaveBtn());

		ThreadLocalUtility.getTest().log(Status.INFO, "verifying customer creation");

		//cp.getSearchTextEdit().sendKeys(firstname+" "+lastname);
		
		wlib.waitForElementPresent(driver, cp.getFirstName());

		Assert.assertEquals(cp.getFirstName().getText(), firstname);
		ThreadLocalUtility.getTest().log(Status.PASS, "first name verified successfully");
	
		Assert.assertEquals(cp.getLastName().getText(), lastname);
		ThreadLocalUtility.getTest().log(Status.PASS, "last name verified successfully");
		Assert.assertEquals(cp.getPhoneNumber().getText(), phonenum);
		ThreadLocalUtility.getTest().log(Status.PASS, "phone number verified successfully");

	}
	
}
