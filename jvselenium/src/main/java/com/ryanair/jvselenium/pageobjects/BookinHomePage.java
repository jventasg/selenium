package com.ryanair.jvselenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Booking Home Page Object. 
 * It contains all the elements needed to perform a flight search
 */
public class BookinHomePage extends PageObject
{
	/**
	 * Radio Button to select One Way
	 */
	@FindBy(xpath="//*[@id=\"flight-search-type-option-one-way\"]")
    private WebElement oneWay;
	
	/**
	 * Departure Airport Input Text Box
	 */
	@FindBy(xpath="//*[@id=\"search-container\"]/div[1]/div/form/div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/input")
    private WebElement departureAirport;

	/**
	 * Destination Airport Input Text Box
	 */
	@FindBy(xpath="//*[@id=\"search-container\"]/div[1]/div/form/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/input")
    private WebElement destinationAirport;	
	
	/**
	 * Continue Button
	 */
	@FindBy(xpath="//*[@id=\"search-container\"]/div[1]/div/form/div[4]/button[1]/span")
    private WebElement continueButton;	
	
	/**
	 * Fly Out Day
	 */
	@FindBy(xpath="//*[@id=\"row-dates-pax\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]")
    private WebElement flyOutDD;
	
	/**
	 * Fly Out Month
	 */
	@FindBy(xpath="//*[@id=\"row-dates-pax\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]")
    private WebElement flyOutMM;
	
	/**
	 * Fly Out Year
	 */
	@FindBy(xpath="//*[@id=\"row-dates-pax\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]")
    private WebElement flyOutYYYY;
	
	/**
	 * Lets Go Button
	 */
	@FindBy(xpath="//*[@id=\"search-container\"]/div[1]/div/form/div[4]/button[2]")
    private WebElement letsGo;
	
	
	/**
	 * Select one way option
	 */
	public void setOneWay() {
		oneWay.click();
	}
	
	
	/**
	 * Set the departure and destination airports
	 * @param departure Departure airport
	 * @param destination Destination airport
	 */
	public void setAirpots(String departure, String destination) {
		departureAirport.clear();
		departureAirport.sendKeys(departure);
		departureAirport.sendKeys(Keys.RETURN);
		
		destinationAirport.clear();
		destinationAirport.sendKeys(destination);
		destinationAirport.sendKeys(Keys.RETURN);
	}
	
	
	/**
	 * Click on Continue Button
	 */
	public void clickContinue () {
		
		//before the element is available to click
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.executeScript("arguments[0].click();", continueButton);
	}
	
	
	/**
	 * Set the fly out date
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setFlyOutDate(String year, String month, String day) {
		flyOutDD.clear();
		flyOutDD.sendKeys(day);
		
		flyOutMM.clear();
		flyOutMM.sendKeys(month);
		
		flyOutYYYY.clear();
		flyOutYYYY.sendKeys(year);
		flyOutYYYY.sendKeys(Keys.RETURN);
	}
	
	/**
	 * Set the fly out day and let the system to fill the month and year with 
	 * the closer date available for the day
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setFlyOutDateByDay(String day) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		flyOutDD.clear();
		flyOutDD.sendKeys(day);
		flyOutYYYY.sendKeys(Keys.RETURN);
	}
	

	/**
	 * Click on Continue Button
	 */
	public void clickLetsGo () {
		letsGo.click();
	}
	
	
	/**
	 * Constructor
	 * @param driver
	 */
	public BookinHomePage(WebDriver driver) {
		super(driver);
	}


}
