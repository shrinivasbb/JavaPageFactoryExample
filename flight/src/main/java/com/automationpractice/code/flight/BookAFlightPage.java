package com.automationpractice.code.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookAFlightPage extends StartPage {

	@FindBy(name="passFirst0")
    @CacheLookup
    public WebElement txtFname;
	
	@FindBy(name="passLast0")
    @CacheLookup
    public WebElement txtLname;
	
	@FindBy(name="passFirst1")
    @CacheLookup
    public WebElement txtFname1;
	
	@FindBy(name="passLast1")
    @CacheLookup
    public WebElement txtLname1;
	
	@FindBy(name="creditnumber")
    @CacheLookup
    public WebElement txtNumber;
	
	@FindBy(name="buyFlights")
    @CacheLookup
    public WebElement btnSecurePurchase;
	
	public BookAFlightPage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	}

	public FlightConfirmationPage fillDetailsAndPurchase(String fname1,String lname1,String fname2,String lname2,String number) {
		txtFname.sendKeys(fname1.toString());
		txtLname.sendKeys(lname1.toString());
		txtFname1.sendKeys(fname2.toString());
		txtLname1.sendKeys(lname2.toString());
		txtNumber.sendKeys(number.toString());
		btnSecurePurchase.click();
		return PageFactory.initElements(driver, FlightConfirmationPage.class);
	}
	
}
