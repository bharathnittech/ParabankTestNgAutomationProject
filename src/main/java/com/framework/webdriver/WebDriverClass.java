package com.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass {

	// All common methods to launch , close and to share browser driver details with other classes

	WebDriver driver;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	// To launch new browser session
	@BeforeMethod(alwaysRun=true)
	@Parameters(value="browser")
	public synchronized void setupBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		setDriver(driver);
	}
	
	//to close browser session
	@AfterMethod(alwaysRun=true)
	public void teardownBrowser() {
		driver.quit();
	}
	
	public static synchronized void setDriver(WebDriver driver) {
		thread.set(driver);
	}
	
	public static synchronized WebDriver getDriver() {
		return 	thread.get();	
	}

}
