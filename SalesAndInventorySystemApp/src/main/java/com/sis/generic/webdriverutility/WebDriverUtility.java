package com.sis.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	JavascriptExecutor js=(JavascriptExecutor)ThreadLocalUtility.getDriver();
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	public void switchToTabBasedOnUrl(WebDriver driver, String partialUrl) {
		Set<String> windows = driver.getWindowHandles();
		for(String window: windows) {
			driver.switchTo().window(window);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	
	public void switchToTabBasedOnTitle(WebDriver driver, String partialTitle) {
		Set<String> windows = driver.getWindowHandles();
		for(String window: windows) {
			driver.switchTo().window(window);
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void switchToChildWindow(WebDriver driver) {
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window: windows) {
			driver.switchTo().window(window);
			if(window.contains(currentWindow)) {
				continue;
			}
			else {
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	
	
	
	public void select(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element);
	}
	public void click(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	public void enterData(WebElement element, String data) {
		js.executeScript("arguments[0].value='"+data+"';", element);

	}
}
