package com.sis.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sis.generic.fileutility.ExcelUtility;
import com.sis.generic.fileutility.PropertyfileUtility;
import com.sis.generic.objectRepository.HomePage;
import com.sis.generic.webdriverutility.JavaUtility;
import com.sis.generic.webdriverutility.ThreadLocalUtility;
import com.sis.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver=null;
	
	public PropertyfileUtility flib=new PropertyfileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	
	@BeforeSuite
	public void configBS() {
		
	}
	@Parameters("browser")
	@BeforeClass
	public void configBC(@Optional("chrome") String browser) throws Throwable {
		System.out.println("launch browser");

		//String browser = flib.getDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-save-password-bubble");   // Disable save password prompt
	        option.addArguments("--password-store=basic");           // Set the password store to basic (instead of Google Password Manager)
	        option.addArguments("--disable-features=PasswordManager"); // Disable the entire password manager feature

			driver=new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		ThreadLocalUtility.setDriver(driver);
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("login");
		wlib.waitForPageToLoad(driver);
		String url = flib.getDataFromPropertyFile("url");
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void configAM() {
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		hp.logOutFromApp();
//		hp.getProfileImage().click();
//		wlib.waitForElementToBeClickable(driver, hp.getProfileLogoutBtn());
//		hp.getProfileLogoutBtn().click();
//		wlib.waitForElementToBeClickable(driver, hp.getAlertLogoutBtn());
//		hp.getAlertLogoutBtn().click();
		
		
	}
	@AfterClass
	public void configAC() {
		System.out.println("close browser");
		driver.quit();
		
	}
	@AfterSuite
	public void configAS() {
		
	}

}
