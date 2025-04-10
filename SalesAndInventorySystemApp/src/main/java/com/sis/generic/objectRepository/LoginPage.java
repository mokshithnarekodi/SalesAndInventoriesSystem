package com.sis.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.generic.fileutility.PropertyfileUtility;
import com.sis.generic.webdriverutility.WebDriverUtility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user")
	private WebElement userNameEdit;
	
	@FindBy(name="password")
	private WebElement passwordEdit;
	
	@FindBy(name = "btnlogin")
	private WebElement loginButton;
	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginAsAdmin() throws Throwable {
		PropertyfileUtility flib=new PropertyfileUtility();
		String username=flib.getDataFromPropertyFile("admin_username");
		String password=flib.getDataFromPropertyFile("admin_password");
		
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);
		WebDriverUtility wu=new WebDriverUtility();
		wu.acceptAlert(driver);
	}
	public void loginAsUser() throws Throwable {
		PropertyfileUtility flib=new PropertyfileUtility();
		String username=flib.getDataFromPropertyFile("user_username");
		String password=flib.getDataFromPropertyFile("user_password");
		try {
			userNameEdit.sendKeys(username);
			passwordEdit.sendKeys(password);
			loginButton.click();
		} catch (Exception e) {
			Thread.sleep(1000);
			WebDriverUtility wu=new WebDriverUtility();
			wu.acceptAlert(driver);

		}
		
		}
	
}
