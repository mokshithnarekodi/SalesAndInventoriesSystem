 package com.sis.customerTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sis.baseclass.BaseClass;
import com.sis.generic.objectRepository.CreateCustomerPage;
import com.sis.generic.objectRepository.CustomerPage;
import com.sis.generic.objectRepository.HomePage;
import com.sis.generic.objectRepository.LoginPage;
import com.sis.generic.objectRepository.POSpage;
import com.sis.generic.webdriverutility.ThreadLocalUtility;

@Listeners(com.sis.generic.listnerutility.ListenerImplementation.class)

public class CreateCustomerVerifyInPosTest extends BaseClass {
	@Test(groups="system")
	public void createCustomerVerifyInPosTest() throws IOException, Throwable{
		String firstname = elib.getDataFromExcel("customer", 1, 2);
		String lastname = elib.getDataFromExcel("customer", 1, 3)+jlib.getRandomNumber();
		String phonenum = elib.getDataFromExcel("customer", 1, 4)+jlib.getRandomNumber();
		
		ThreadLocalUtility.getTest().log(Status.INFO, "login to app");

		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin();
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

		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to POS page");
		hp.getPOSLink().click();
		ThreadLocalUtility.getTest().log(Status.INFO, "add a product to cart");
		POSpage pp=new POSpage(driver);
		pp.getKeyboardLink().click();
		wlib.waitForElementToBeClickable(driver, pp.getAddProductBtn());
		pp.getAddProductBtn().click();
		
		ThreadLocalUtility.getTest().log(Status.INFO, "verify created customer info in POS page");
		 wlib.select(pp.getCustomerDropdown(),firstname+" "+lastname );
		
		Select sel=new Select(pp.getCustomerDropdown());
		List<WebElement> selectedname = sel.getAllSelectedOptions();
		for(WebElement name:selectedname) {
			boolean custName = name.getText().equals(firstname+" "+lastname);
			Assert.assertTrue(custName);
			ThreadLocalUtility.getTest().log(Status.PASS, "customer information successfully verified in POS page");
		}
	}

}


