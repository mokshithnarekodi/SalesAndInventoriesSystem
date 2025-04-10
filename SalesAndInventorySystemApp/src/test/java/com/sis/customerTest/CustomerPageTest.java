package com.sis.customerTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sis.baseclass.BaseClass;
import com.sis.generic.objectRepository.HomePage;
import com.sis.generic.objectRepository.LoginPage;
import com.sis.generic.webdriverutility.ThreadLocalUtility;


@Listeners(com.sis.generic.listnerutility.ListenerImplementation.class)

public class CustomerPageTest extends BaseClass{
	@Test(groups = "smoke")
	public void customerPageTest() throws Throwable {
		ThreadLocalUtility.getTest().log(Status.INFO, "login to app");

		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin();
		ThreadLocalUtility.getTest().log(Status.INFO, "navigate to customerpage");

		HomePage hp=new HomePage(driver);
		hp.getCustomerLink().click();
	}
	
}
	
