package com.ryanair.jvselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ryanair.jvselenium.actions.FlightSearch;
import com.ryanair.jvselenium.actions.PerformPayment;
import com.ryanair.jvselenium.pageobjects.PaymentConfirmationPage;
import com.ryanair.jvselenium.util.ReadProperties;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BookingCardDeclinedTest   extends TestCase {
	
	ReadProperties properties;  
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BookingCardDeclinedTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BookingCardDeclinedTest.class );
    }
    
    
    /**
     * Selenium Web Driver
     */
    protected static WebDriver driver; 
    

    public void setUp(){ 
    	properties = new ReadProperties();
    	String driver_name = properties.getProperty("driver");
    	String path = properties.getProperty("driver_location");
    	
    	System.setProperty(driver_name,path);        
    	driver = new FirefoxDriver(); 
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(properties.getProperty("ryanairurl"));
    } 
    
    public void cleanUp(){ 
    	driver.manage().deleteAllCookies(); 
    } 
    

    public void tearDown(){ 
    	driver.close(); 
    } 
    
    public void testBookingCardDeclinedTest() {
    	
    	//Given I make a booking from Madrid to London the 23rd for 1 adult
    	FlightSearch flightSearch = new FlightSearch(driver);
    	flightSearch.seachOneWayFlight("Madrid", "London Stansted","23");
    	
    	//When I pay for booking with card details “5555 5555 5555 5557”, “10/18” and “265”
    	PerformPayment performPayment = new PerformPayment(driver);
    	performPayment.performPaymentInvalidCard("Mr", "Javier", "Garcia","Spain", "666666666","5555555555555557", "MasterCard", "2",
    			"2022", "Javier Garcia", "Calle Alcala", "Madrid", "28080", "Spain");
    	
    	//Then I should get payment declined message
    	PaymentConfirmationPage paymentConfirmationPage = new PaymentConfirmationPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String error = paymentConfirmationPage.getErrorMessage();
		Assert.assertEquals("As your payment was not authorised we could not complete your reservation. Please ensure that the information was correct or use a new payment to try again", error);
    	
    }

}
