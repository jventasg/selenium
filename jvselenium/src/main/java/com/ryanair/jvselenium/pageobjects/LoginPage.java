package com.ryanair.jvselenium.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Login Page Object
 * It allows the user to login into the system
 *
 */
public class LoginPage  extends PageObject {

	/**
	 * Button to confirm login
	 */
	@FindBy(xpath="//button[@ui-sref='login']")
	private WebElement loginButton;
	
	/**
	 * Email input text box
	 */
	@FindBy(xpath="//input[@ng-model='$ctrl.credentials.username']")
	private WebElement emailInput;
	
	/**
	 * Password input text box
	 */
	@FindBy(xpath="//input[@name='password']")
	private WebElement pswInput;
	
	/**
	 * Button to start the login process. It won't be needed if user press enter on email text box
	 */
	@FindBy(xpath="//button[@ng-click='!$ctrl.isLoading && $ctrl.onClick()']")
	private WebElement loginActpButton;

	
	/**
	 * Fill the login information and start the login process
	 * @param email
	 * @param psw
	 */
	public void inputLoginInformation(String email, String psw) {
		emailInput.clear();
		emailInput.sendKeys(email);
		emailInput.sendKeys(Keys.RETURN);
		
		pswInput.clear();
		pswInput.sendKeys(psw);
		//By pressing enter we will start the login process
		pswInput.sendKeys(Keys.RETURN);
	}

	/**
	 * Click the button to indicate the user desired to login in the system
	 */
	public void clickLoginButton () {
		loginButton.click();
	}
	
	
	/**
	 * Constructor
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}
}
