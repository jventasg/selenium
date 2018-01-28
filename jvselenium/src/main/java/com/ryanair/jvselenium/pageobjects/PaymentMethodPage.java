package com.ryanair.jvselenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Payment Method Page Object
 * It contains all the elements needed to the user to fill the payment method and information
 * (only the elements for credit card choice have been implemented)
 */
public class PaymentMethodPage extends PageObject  {

	/**
	 * Radio to select Credit / Debit card payment method
	 */
	@FindBy(xpath="//input[@id='CC']")
	private WebElement payMethod;
	
	/**
	 * Input text box to fill the credit/debit card number
	 */
	@FindBy(xpath="//input[@name='cardNumber']")
	private WebElement cardNumber;
	
	/**
	 * Input text box to fill the CVV security code
	 */
	@FindBy(xpath="//input[@name='securityCode']")
	private WebElement securityCode;

	/**
	 * Input text box to fill the card holder name
	 */
	@FindBy(xpath="//input[@name='cardHolderName']")
	private WebElement holderName;
	
	/**
	 * Select drop down to choose the credit/debit card type
	 */
	private Select cardType;
	
	/**
	 * Select drop down to choose the card expiration month
	 */
	private Select expirationMonth;
	
	/**
	 * Select drop down to choose the card expiration year
	 */
	private Select expirationYear;

	
	/**
	 * Set the payment method and payment information
	 * @param pCardNumber
	 * @param pCardType
	 * @param expMonth
	 * @param expYear
	 * @param pCVV
	 * @param pName
	 */
	public void inputPaymentMethodCard(String pCardNumber, String pCardType, String expMonth, String expYear, String pCVV, String pName) {
		
		payMethod.click();
		
		cardNumber.clear();
		cardNumber.sendKeys(pCardNumber);
		
		securityCode.clear();
		securityCode.sendKeys(pCVV);
		
		holderName.clear();
		holderName.sendKeys(pName);
		

		cardType = new Select(driver.findElement(By.xpath("//select[@name='cardType']")));
		cardType.selectByVisibleText(pCardType);
		
		expirationMonth = new Select(driver.findElement(By.xpath("//select[@name='expiryMonth']")));
		expirationMonth.selectByVisibleText(expMonth);
		
		expirationYear = new Select(driver.findElement(By.xpath("//select[@name='expiryYear']")));
		expirationYear.selectByVisibleText(expYear);

	}

	
	/**
	 * Constructor
	 * @param driver
	 */
	public PaymentMethodPage(WebDriver driver) {
		super(driver);
	}

}
