package com.application.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class LoginPageActions extends LoginPageElements{
	
	public void launchApplication() {
		driver.get(ReadProp.readData("Config.properties", "url"));
		Assert.assertEquals(getPageTitle(), ReadProp.readData("Config.properties", "title"));
		log("pass","Application Launched Successfully");
	}
	
	public void verifyLogo() {
		Assert.assertTrue(logo.isDisplayed());
		log("pass","Application Logo Displayed Successfully");
	}
	
	public void verifyCaption() {
		Assert.assertEquals(getElementText(caption), ReadProp.readData("Config.properties", "caption"));
		log("pass","Application Caption is Displayed Correctly");
	}
	
	public void verifyLoginPageHeader() {
		Assert.assertEquals(getElementText(loginSectionHeader), ReadProp.readData("Config.properties", "header"));
		log("pass","Application Login Page Header is Displayed Correctly");
	}
	
	public void enterCredentials(String Username, String Password) {
		enterInfo(usernameTextbox, Username);
		enterInfo(passwordTextbox, Password);
		log("pass","Credentials successfully updated");
	}
	
	public void clickOnLoginAndVerifyLoginIsSuccessful() {
		clickOnElement(loginButton);
		waitForLocator(accountOverviewLinkLocator);
		log("pass","Application Login is Successful");
	}
	
	public void getRegistrationPage() {
		clickOnElement(registerLink);
		log("pass","Clicked on Registration link Successfully");
	}
	
	public void getResetPasswordPage() {
		clickOnElement(forgotLoginLink);
		log("pass","Clicked on Forgot Login Info link Successfully");
	}
	
	public void getAdminPage() {
		clickOnElement(adminPage);
		log("pass","Clicked on Admin Page link Successfully");
	}
	
	public static LoginPageActions getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPageActions.class);
	}

}
