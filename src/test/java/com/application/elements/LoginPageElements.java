package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class LoginPageElements extends WebCommons{
	
	@FindBy(xpath="//img[@class='logo']")
	public WebElement logo;
	
	@FindBy(xpath="//p[@class='caption']")
	public WebElement caption;
	
	@FindBy(xpath="//h2")
	public WebElement loginSectionHeader;
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot login')]")
	public WebElement forgotLoginLink;
	
	@FindBy(xpath="//a[text()='Register']")
	public WebElement registerLink;
	
	@FindBy(xpath="//a[text()='Accounts Overview']")
	public WebElement accountOverviewLink;
	
	public By accountOverviewLinkLocator = By.xpath("//a[text()='Accounts Overview']");
	
	@FindBy(xpath="//a[text()='Admin Page']")
	private WebElement adminPage;

}
