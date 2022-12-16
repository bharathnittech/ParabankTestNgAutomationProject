package com.application.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.RegistrationPageElements;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class RegistrationPageActions extends RegistrationPageElements{
	
	public void verifyWhetherRegistrationPageisLaunched() {
		waitForLocator(regTitleLocator);
		log("pass", "Registration page launched successfully");
	}
	
	public void verifyRegistrationPageHeader() {
		Assert.assertEquals(getElementText(title),ReadProp.readData("Config.properties", "regHeader") );
		log("pass", "Application registration page header is as expected");
	}

	public static RegistrationPageActions getRegPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), RegistrationPageActions.class);
	}
}
