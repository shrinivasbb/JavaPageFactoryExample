package com.automationpractice.code.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage extends StartPage {
	
	@FindBy(name="passCount")
    @CacheLookup
    public WebElement ddPassengers;
	
	@FindBy(name="fromPort")
    @CacheLookup
    public WebElement ddFromPort;
	
	@FindBy(name="fromMonth")
    @CacheLookup
    public WebElement ddFromMonth;
	
	@FindBy(name="fromDay")
    @CacheLookup
    public WebElement ddFromDay;
	
	@FindBy(name="toPort")
    @CacheLookup
    public WebElement ddToPort;
	
	@FindBy(name="toMonth")
    @CacheLookup
    public WebElement ddToMonth;
	
	@FindBy(name="toDay")
    @CacheLookup
    public WebElement ddToDay;
	
	@FindBy(css="[value='Business']")
    @CacheLookup
    public WebElement radBusiness;
	
	@FindBy(css="[name='airline']")
    @CacheLookup
    public WebElement ddAirline;
	
	@FindBy(name="findFlights")
    @CacheLookup
    public WebElement btnContinue;
	
	public Select select;

	public FlightsPage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	}

	public SelectFlightsPage fillFormPage(String passengers,String from,String fmonth,String fday,String to,String tomonth,
			                              String today,String airline) {
		waits.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(ddPassengers)));
		select=new Select(ddPassengers);
		select.selectByVisibleText(passengers);
		select=new Select(ddFromPort);
		select.selectByVisibleText(from);
		select=new Select(ddFromMonth);
		select.selectByVisibleText(fmonth);
		select=new Select(ddFromDay);
		select.selectByVisibleText(fday);
		select=new Select(ddToPort);
		select.selectByVisibleText(to);
		select=new Select(ddToMonth);
		select.selectByVisibleText(tomonth);
		select=new Select(ddToDay);
		select.selectByVisibleText(today);
		radBusiness.click();
		select=new Select(ddAirline);
		select.selectByVisibleText(airline);
		btnContinue.click();
		return PageFactory.initElements(driver, SelectFlightsPage.class);
	}
	
	

}
