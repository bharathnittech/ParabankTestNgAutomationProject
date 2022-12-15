package com.application.tests;

import org.testng.annotations.Test;

import com.application.actions.AdminPageActions;
import com.application.actions.ForgotLoginInfoPageActions;
import com.application.actions.LoginPageActions;
import com.application.actions.RegistrationPageActions;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass{
	
	LoginPageActions loginpage;
	RegistrationPageActions regpage;
	AdminPageActions adminpage;
	ForgotLoginInfoPageActions fppage;
	
	@Test(priority=1)
	public void VerifyWhetherApplicationLaunchedSuccessfully() {
		loginpage = LoginPageActions.getLoginPage();
		loginpage.launchApplication();
	}
	
	@Test(priority=2)
	public void VerifyApplicationLogoAndCaption() {
		loginpage = LoginPageActions.getLoginPage();
		loginpage.launchApplication();
		loginpage.verifyLogo();
		loginpage.verifyCaption();
	}
	
	@Test(priority=3,dataProvider="logindata")
	public void VerifyApplicationLogin(String Username,String Password) {
		loginpage = LoginPageActions.getLoginPage();
		loginpage.launchApplication();
		loginpage.verifyLoginPageHeader();
		loginpage.enterCredentials(Username, Password);
		loginpage.clickOnLoginAndVerifyLoginIsSuccessful();
	}

}
