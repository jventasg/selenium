package com.ryanair.jvselenium.actions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.ryanair.jvselenium.pageobjects.PaymentBillingAddressPage;
import com.ryanair.jvselenium.pageobjects.PaymentConfirmationPage;
import com.ryanair.jvselenium.pageobjects.PaymentContactDetailsPage;
import com.ryanair.jvselenium.pageobjects.PaymentMethodPage;
import com.ryanair.jvselenium.pageobjects.PaymentPassengerDetailsPage;


/**
 * Provide some methods that reproduce some actions related to check out and payment 
 * to be reused by several test cases
 *
 */
public class PerformPayment {

	protected WebDriver driver; 
	
	 public void performPaymentInvalidCard(String title, String passName, String pLastName, String pPhoneCountry, String pPhone,
			 String pCardNumber, String pCardType, String expMonth, String expYear, String holderName,
			 String bAddress, String bCity, String bPostCode, String bCountry) {
		 
	    //Payment Passenger Details
		PaymentPassengerDetailsPage paymentPassengerDetailsPage = new PaymentPassengerDetailsPage(driver);
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		paymentPassengerDetailsPage.inputPassengerDetails(title, passName, pLastName);
		
		
		//Payment Contact Details
		PaymentContactDetailsPage paymentContactDetailsPage = new PaymentContactDetailsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		paymentContactDetailsPage.inputContactDetail(pPhoneCountry, pPhone);
		
		//Payment method and information
		PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
		//Selecting a random CVV to avoid the system to recognize the payment attempt as duplicated
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		String ramdomCVV = String.valueOf(randomNum);
		System.out.println("Ramdom CVV: "+ ramdomCVV);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		paymentMethodPage.inputPaymentMethodCard(pCardNumber, pCardType, expMonth, expYear, ramdomCVV, holderName);
		
		
		//Payment billing address information
		PaymentBillingAddressPage paymentBillingAddressPage = new PaymentBillingAddressPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		paymentBillingAddressPage.inputBillingAddress(bAddress, bCity, bPostCode, bCountry);
		
		//Payment confirmation 
		PaymentConfirmationPage paymentConfirmationPage = new PaymentConfirmationPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		paymentConfirmationPage.clickAcceptTerms();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		paymentConfirmationPage.clickPayButton();
		 	 
	 }
	
	/**
	 * Constructor
	 * @param driver
	 */
	public PerformPayment(WebDriver driver) {
		this.driver = driver; 
	}
}
