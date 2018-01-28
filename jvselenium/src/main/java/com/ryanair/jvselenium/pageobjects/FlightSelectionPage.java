package com.ryanair.jvselenium.pageobjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Flight Selection Page Object
 * It contains all the elements needed to select one of the flight results from the search
 * and check it out
 */
public class FlightSelectionPage  extends PageObject {
	
	/**
	 * Radio to select Standard Fare
	 */
	@FindBy(xpath="//span[contains(@class,'flights-table-fares__fare-radio')]")
	private WebElement standardFareRadio;
	
	/**
	 * Button to select one of the flights from the result list
	 */
	@FindBy(xpath="//span[contains(@class,'flights-table-price__header')]")
	private WebElement flightButton;
	
	/**
	 * Button to continue the reservation
	 */
	@FindBy(xpath="//button[@id='continue']")
	private WebElement continueButton;
	
	/**
	 * Link to confirm to continue the process as a guest
	 */
	@FindBy(xpath="//a[@ng-click='$ctrl.closeDialog()']")
	private WebElement guestButton;	
	
	/**
	 * Button to start the Check Out process
	 */
	@FindBy(xpath="//button[@class='core-btn-primary core-btn-block core-btn-medium btn-text']")
	private WebElement checkOutButton;	
	
	/**
	 * Link to cancel the seat's reservation
	 */
	@FindBy(xpath="//button[@ng-if='::$ctrl.message.dismissButton.display']")
	private WebElement noSeatReservation;	
	
	/**
	 * Click on the button to select one of the flights
	 */
	public void clickFlightButton () {
		executor.executeScript("arguments[0].click();", flightButton);
	}
	
	/**
	 * Select the radio to confirm Standard Fare
	 */
	public void clickStandardFare () {
		
		standardFareRadio.click();
	}
	
	
	/**
	 * Click on the button to continue the reservation process
	 */
	public void clickContinueButton () {
		
		//before the element is available to click
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	    executor.executeScript("arguments[0].click();", continueButton);

	}
	
	/**
	 * Click to discard login and Continue as Guest
	 */
	public void clickContinueGuestButton () {
		
		try
		{
			executor.executeScript("arguments[0].click();", guestButton);
		}
		catch (NoSuchElementException e) {
			//If the element does not exist is because the user has performed a previous search 
			//and selected this option already
		     System.out.println("User is already a guest.");
		} catch (Exception e) {
	         System.out.println("Exception occurred while selecting to continue as a guest.");
	      }
	}
	
	/**
	 * Click on the button to start the Check Out process
	 */
	public void clickCheckOutButton () {
		executor.executeScript("arguments[0].click();", checkOutButton);
	}
	
	
	/**
	 * Click to discard the reservation of a seat
	 */
	public void clickNoSeatReservation () {		
		try
		{
			executor.executeScript("arguments[0].click();", noSeatReservation);
		}
		catch (NoSuchElementException e) {
		     System.out.println("User has already declined to reserve seats.");
		} catch (Exception e) {
	         
	         System.out.println("Exception occurred while selecting to continue without making a seat reservation.");
	      }
	}
	
	/**
	 * Constructor
	 * @param driver
	 */
	public FlightSelectionPage(WebDriver driver) {
		super(driver);
	}
}
