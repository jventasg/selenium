package com.ryanair.jvselenium.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.ryanair.jvselenium.pageobjects.BookinHomePage;
import com.ryanair.jvselenium.pageobjects.FlightSelectionPage;
import com.ryanair.jvselenium.pageobjects.LoginPage;
import com.ryanair.jvselenium.util.ReadProperties;

/**
 * Provide some methods that reproduce some actions related to flight searches 
 * to be reused by several test cases
 *
 */
public class FlightSearch {
	
	protected WebDriver driver;
	ReadProperties properties; 
	
  public void seachOneWayFlight(String departure, String destination, String day) {
	  
		//Flight Search
		BookinHomePage bookinHomePage = new BookinHomePage(driver);
		
		bookinHomePage.setOneWay();
		
		bookinHomePage.setAirpots(departure, destination);
		
		bookinHomePage.setFlyOutDateByDay(day); 
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		bookinHomePage.clickLetsGo();
		
  	    //Flight Selection
		FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		flightSelectionPage.clickFlightButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		flightSelectionPage.clickStandardFare();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		flightSelectionPage.clickContinueButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		flightSelectionPage.clickContinueGuestButton();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		flightSelectionPage.clickCheckOutButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		flightSelectionPage.clickNoSeatReservation();
		
		//Loging
		LoginPage loginPage = new LoginPage(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage.clickLoginButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//loginPage.inputLoginInformation("jventas@gmail.com", "RynairTest1");
		loginPage.inputLoginInformation(properties.getProperty("username"), properties.getProperty("userpsw"));

		
  }
  
  
	/**
	 * Constructor
	 * @param driver
	 */
	public FlightSearch(WebDriver driver) {
		this.driver = driver; 
		properties = new ReadProperties();
	}
}
