package com.ryanair.jvselenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Contact Details Page Object
 * It contains all the elements needed to the user to fill the contact information
 */
public class PaymentContactDetailsPage extends PageObject  {

	/**
	 * Select drop down to choose the contry's phone to determine the prefix
	 */
	private Select phoneCountry;
	
	/**
	 * Input text box to fill the passenger's phone number
	 */
	@FindBy(xpath="//input[@name='phoneNumber']")
	private WebElement phone;
	
	
	/**
	 * Set the passenger's contact information
	 * @param pPhoneCountry
	 * @param pPhone
	 */
	public void inputContactDetail(String pPhoneCountry, String pPhone) {
		
		phoneCountry = new Select(driver.findElement(By.xpath("//select[@name='phoneNumberCountry']")));
		phoneCountry.selectByVisibleText(pPhoneCountry);
		
		phone.clear();
		phone.sendKeys(pPhone);		
	}


	/**
	 * Constructor
	 * @param driver
	 */
	public PaymentContactDetailsPage(WebDriver driver) {
		super(driver);
	}

}
