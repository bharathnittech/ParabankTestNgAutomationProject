package com.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class LoginPageElements extends WebCommons {
	
	@FindBy(xpath="//img[@title='ParaBank']")
	public WebElement logo;
	
	@FindBy(xpath="//p[@class='caption']")
	public WebElement caption;
	
	@FindBy(xpath="//a[text()='Admin Page']")
	public WebElement adminPageLink;


}
