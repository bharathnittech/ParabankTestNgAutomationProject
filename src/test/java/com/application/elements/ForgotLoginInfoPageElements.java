package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class ForgotLoginInfoPageElements extends WebCommons {

	public By forgotPassPageHeader = By.xpath("//h1[@class='title']");

	@FindBy(xpath = "//h1[@class='title']")
	public WebElement forgotPassPageTitle;

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@id='address.street']")
	public WebElement address;

	@FindBy(xpath = "//input[@id='address.city']")
	public WebElement city;

	@FindBy(xpath = "//input[@id='address.state']")
	public WebElement state;

	@FindBy(xpath = "//input[@id='address.zipCode']")
	public WebElement zipCode;

	@FindBy(xpath = "//input[@id='ssn']")
	public WebElement ssn;

	@FindBy(xpath = "//input[@value='Find My Login Info']")
	public WebElement findLoginInfoBtn;

}
