package com.framework.commons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.webdriver.WebDriverClass;

public class WebCommons {

	// All common methods related to web application automation

	public WebDriver driver = WebDriverClass.getDriver();
	Actions action = new Actions(driver);
	
	// Scroll till element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
	}

	// Click on the WebElement
	public void clickOnElement(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	// Enter text in textbox
	public void enterInfo(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}

	// Select Checkbox
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if (!element.isSelected())
			element.click();
	}

	// Select option from dropdown
	public void selectOption(WebElement element, String option, String method) {
		Select s = new Select(element);
		if (method.equalsIgnoreCase("Index"))
			s.selectByIndex(Integer.parseInt(option));
		else if (method.equalsIgnoreCase("value"))
			s.selectByValue(option);
		else if (method.equalsIgnoreCase("visibleText"))
			s.selectByVisibleText(option);
	}
	
	//Perform double click on element
	public void doubleClick(WebElement element) {
		action.doubleClick(element).perform();
	}
	
	//Perform right click on element
	public void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}
	
	//Perform mouse hover on element
	public void mouseHover(WebElement element) {
		action.moveToElement(element).perform();
	}
	
	// Java Wait
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Implicit wait
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	// Explicit wait 
	public void waitForLocator(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	// Fluent Wait
	
	// Method to generate unique id
	
	// Method to take screenshot of browser window and return the path of screenshot
	
	// Method to take screenshot of element and return the path of screenshot
	
	// Method to get page title 
	
	// Method to get window handle id
	
	// Method to get text value from element
	
	// Method to get attribute value from element
	
	// Method to wait for alert and then switch to alert
	
	// Method to switch to frame
	
	// Method to switch to window
	
	// Method to switch to default frame
	
	// Method to open new tab
	
	// Method to open new window
	
	

}
