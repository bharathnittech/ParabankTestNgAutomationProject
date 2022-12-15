package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.reports.ReportsClass;
import com.framework.utilities.Utils;
import com.framework.webdriver.WebDriverClass;

public class WebCommons {

	// All common methods related to web application automation

	public WebDriver driver = WebDriverClass.getDriver();

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

	// Perform double click on element
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	// Perform right click on element
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// Perform mouse hover on element
	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	// Java Wait
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Implicit wait
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.WAIT_TIME));
	}

	// Explicit wait
	public void waitForLocator(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utils.WAIT_TIME));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	// Fluent Wait
	public void fluentWait(By locator, int polling) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Utils.WAIT_TIME))
				.pollingEvery(Duration.ofSeconds(polling));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	// Method to generate unique id
	public String uniqueId() {
		String uniqueId = new SimpleDateFormat("MMddyyhhmmss").format(Calendar.getInstance().getTime());
		return uniqueId;
	}

	// TaKe Screenshot of browser window and get the path to attach in report
	public String takeScreenshotOfWindow(String name) {
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + name + uniqueId() + ".png";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	// TaKe Screenshot of element and get the path to attach in report
	public String takeScreenshotOfElement(WebElement element, String name) {
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + name + uniqueId() + ".png";
		File file = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	// Browser actions
	public void browserAction(String action) {
		if (action.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else if (action.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (action.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
	}

	// get the page Title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// get the text from element
	public String getElementText(WebElement element) {
		return element.getText();
	}

	// get the attribute value from element
	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	// Get window handle id
	public String getWindowHandleId() {
		return driver.getWindowHandle();
	}

	// Switch to Alert
	public Alert getAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	// Method to switch to frame
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	// Method to switch to default frame
	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	// Method to switch to window
	public void switchToWindow(String windowHandleId) {
		driver.switchTo().window(windowHandleId);
	}

	// Method to open new tab
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	// Method to open new window
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	//Method to print message in report
	public void log(String status, String message) {
		if (status.equalsIgnoreCase("pass"))
			ReportsClass.logger.pass(message);
		else if (status.equalsIgnoreCase("fail"))
			ReportsClass.logger.fail(message);
		else if (status.equalsIgnoreCase("warning"))
			ReportsClass.logger.warning(message);
		else if (status.equalsIgnoreCase("info"))
			ReportsClass.logger.info(message);
	}

}
