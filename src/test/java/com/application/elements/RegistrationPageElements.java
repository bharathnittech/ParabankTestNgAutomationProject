package com.application.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class RegistrationPageElements extends WebCommons{
	
	@FindBy(xpath="//h1[@class='title']")
	public WebElement title;
	
	public By regTitleLocator = By.xpath("//h1[@class='title']");
	
	@FindBy(xpath="//input[@name='customer.firstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@name='customer.lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@name='customer.address.street']")
	public WebElement address;
	
	@FindBy(xpath="//input[@name='customer.address.city']")
	public WebElement city;
	
	@FindBy(xpath="//input[@name='customer.address.state']")
	public WebElement state;
	
	@FindBy(xpath="//input[@name='customer.address.zipCode']")
	public WebElement zipCode;
	
	@FindBy(xpath="//input[@name='customer.phoneNumber']")
	public WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='customer.ssn']")
	public WebElement ssn;
	
	@FindBy(xpath="//input[@name='customer.username']")
	public WebElement username;
	
	@FindBy(xpath="//input[@name='customer.password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='repeatedPassword']")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//input[@value='Register']")
	public WebElement registerButton;
	
	@FindBy(xpath="//span[@class='error']")
	public List<WebElement> errors;
	
	By registrationSuccess = By.xpath("//h1[@class='title' and contains(text(),'Welcome')]");

}
