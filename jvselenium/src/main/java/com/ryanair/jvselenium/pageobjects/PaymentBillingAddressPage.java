package com.ryanair.jvselenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Payment Billing Address Page Object
 * It contains all the elements needed to the user to fill the payment billing address
 */
public class PaymentBillingAddressPage extends PageObject  {
	
	/**
	 * Input text box to fill the billing address
	 */
	@FindBy(xpath="//input[@id='billingAddressAddressLine1']")
	private WebElement billingAddress1;
	
	/**
	 * Input text box to fill the city from the billing address
	 */
	@FindBy(xpath="//input[@id='billingAddressCity']")
	private WebElement billingCity;
	
	/**
	 * Input text box to fill the billing address post code
	 */
	@FindBy(xpath="//input[@id='billingAddressPostcode']")
	private WebElement billingPostCode;
	
	/**
	 * Select drop down to choose the country from the billing address
	 */
	private Select billingCountry;
	
	/**
	 * Set the payment billing address information
	 * @param bAddress
	 * @param bCity
	 * @param bPostCode
	 * @param bCountry
	 */
	public void inputBillingAddress(String bAddress, String bCity, String bPostCode, String bCountry) {
		
		billingCountry = new Select(driver.findElement(By.xpath("//select[@id='billingAddressCountry']")));
		billingCountry.selectByVisibleText(bCountry);
		
		billingAddress1.clear();
		billingAddress1.sendKeys(bAddress);

		billingCity.clear();
		billingCity.sendKeys(bCity);
		
		billingPostCode.clear();
		billingPostCode.sendKeys(bPostCode);
	}
	
	/**
	 * Constructor
	 * @param driver
	 */
	public PaymentBillingAddressPage(WebDriver driver) {
		super(driver);
	}

}
