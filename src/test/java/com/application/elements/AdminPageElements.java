package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.commons.WebCommons;

public class AdminPageElements extends WebCommons{
	
	public WebElement header= driver.findElement(By.xpath("//h2"));

}
