package com.ryanair.jvselenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Passenger Details Page Object
 * It contains all the elements needed to the user to fill the passenger information
 */
public class PaymentPassengerDetailsPage extends PageObject  {

	/**
	 * Select drop down to choose the passenger's title
	 */
	private Select titleSel;

	/**
	 * Input text box to fill the passenger's name
	 */
	@FindBy(xpath="//input[@class='core-input ng-pristine ng-untouched ng-valid-name ng-empty ng-invalid ng-invalid-required ng-valid-minlength ng-valid-maxlength magnifying-glass-input']")
	private WebElement name;
	
	/**
	 * Input text box to fill the passenger's last name
	 */
	@FindBy(xpath="//input[@class='core-input ng-pristine ng-untouched ng-valid-name ng-empty ng-invalid ng-invalid-required ng-valid-minlength ng-valid-maxlength']")
	private WebElement lastName;

	
	/**
	 * Set the passenger's detail information
	 * @param title
	 * @param pName
	 * @param pLastName
	 */
	public void inputPassengerDetails(String title, String pName, String pLastName) {
		name.clear();
		name.sendKeys(pName);
		
		lastName.clear();
		lastName.sendKeys(pLastName);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		titleSel = new Select(driver.findElement(By.xpath("//select[contains(@name,'title')]")));
		titleSel.selectByVisibleText(title);
	}
	
	/**
	 * Constructor
	 * @param driver
	 */
	public PaymentPassengerDetailsPage(WebDriver driver) {
		super(driver);
	}

}
