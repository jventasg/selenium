package com.ryanair.jvselenium.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Main Page Object class to host the WebDriver and the JavascriptExecutor
 *
 */
public class PageObject {

	protected WebDriver driver; 
	JavascriptExecutor executor;
	
	
	/**
	 * Constructor
	 * @param driver
	 */
	public PageObject(WebDriver driver){ 
		this.driver = driver; 
		PageFactory.initElements(driver, this); 
		executor = (JavascriptExecutor)driver;
	}

}
