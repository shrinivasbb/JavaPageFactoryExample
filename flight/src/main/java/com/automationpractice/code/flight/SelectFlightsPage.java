package com.automationpractice.code.flight;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightsPage extends StartPage{
	
	@FindBy(css=".title font[size='2']")
    @CacheLookup
    public List<WebElement> lableTravel;
	
	@FindBy(css="input[value='Unified Airlines$363$281$11:24']")
    @CacheLookup
    public WebElement rdflight1;
	
	@FindBy(css="input[value='Unified Airlines$633$303$18:44']")
    @CacheLookup
    public WebElement rdFlight2;
	
	@FindBy(name="reserveFlights")
    @CacheLookup
    public WebElement btnReserveFlights;
	

	public SelectFlightsPage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	}
	
	public BookAFlightPage selectFlight() {
		rdflight1.click();
		rdFlight2.click();
		btnReserveFlights.click();
		return PageFactory.initElements(driver, BookAFlightPage.class);
	}

}
