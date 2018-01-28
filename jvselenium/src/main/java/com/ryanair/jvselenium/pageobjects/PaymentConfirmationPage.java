package com.ryanair.jvselenium.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Payment Confirmation Page Object
 * It contains all the elements needed to confirm the payment and collect any error
 */
public class PaymentConfirmationPage extends PageObject  {

	/**
	 * Check Box to accept the terms and conditions
	 */
	@FindBy(xpath="//translate[@ng-if='!$ctrl.operatedBy']")
	private WebElement terms;
	
	/**
	 * Button to start the payment process
	 */
	@FindBy(xpath="//button[@class='core-btn-primary core-btn-medium']")
	private WebElement payButton;
	
	/**
	 * Error message due to payment not authorized
	 */
	@FindBy(xpath="//span[contains(.,'As your payment was not authorised we could not complete your reservation. Please ensure that the information was correct or use a new payment to try again')]")
	private WebElement errorMessage;	
	
	
	/**
	 * Set the check box to accept the terms and conditions
	 */
	public void clickAcceptTerms () {
		terms.click();
	}

	/**
	 * Click on the button to start the payment process
	 */
	public void clickPayButton () {		
		payButton.click();
	}

	/**
	 * Get the error message if the payment is rejected
	 */
	public String getErrorMessage () {
		String errorMsg;
		try {
		    errorMsg = errorMessage.getText();
			System.out.println("Payment Error: " + errorMsg);
		} catch (NoSuchElementException e) {
			System.out.println("Error Message Not Found.");
			errorMsg = null;;
		}
		return errorMsg;
	}
	

	/**
	 * Constructor
	 * @param driver
	 */
	public PaymentConfirmationPage(WebDriver driver) {
		super(driver);
	}

}
