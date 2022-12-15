package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageElements {
	
	public By adminPageTitle = By.xpath("//h1[@class='title']");
	
	public static By dataAccessMode(String name) {
		return By.xpath("//input[@value='"+name+"']");
	}

	@FindBy(xpath="//select[@id='loanProvider']")
	private WebElement loanProviderDropdown;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitButton;
}
