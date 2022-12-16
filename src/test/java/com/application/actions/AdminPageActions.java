package com.application.actions;

import org.openqa.selenium.support.PageFactory;

import com.framework.webdriver.WebDriverClass;

public class AdminPageActions {

	public static AdminPageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminPageActions.class);
	}

}
