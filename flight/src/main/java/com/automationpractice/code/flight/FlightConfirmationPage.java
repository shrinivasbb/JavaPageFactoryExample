package com.automationpractice.code.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage extends StartPage {

	@FindBy(css="a[href='mercurysignoff.php']")
    @CacheLookup
    public WebElement btnLogOut;
	
	
	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	}

	public LoginPage logoutFromApp() {
		btnLogOut.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
}
