package com.application.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.ForgotLoginInfoPageElements;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class ForgotLoginInfoPageActions extends ForgotLoginInfoPageElements{
	
	public void verifyWhetherRegistrationPageisLaunched() {
		waitForLocator(forgotPassPageHeader);
		log("pass", "Forgot Login Info page launched successfully");
	}
	
	public void verifyRegistrationPageHeader() {
		Assert.assertEquals(getElementText(forgotPassPageTitle),ReadProp.readData("Config.properties", "forgotPageHeader") );
		log("pass", "Application Forgot Login Info page header is as expected");
	}

	public static ForgotLoginInfoPageActions getFPPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ForgotLoginInfoPageActions.class);
	}
}
