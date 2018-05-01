package com.automationpractice.code.flight;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends StartPage {

	

	@FindBy(linkText="REGISTER")
    @CacheLookup
    public WebElement txtREGISTER;
	
	@FindBy(name="userName")
    @CacheLookup
    public WebElement txtUsername;
	
	@FindBy(name="password")
    @CacheLookup
    public WebElement txtPassword;
	
	@FindBy(name="login")
    @CacheLookup
    public WebElement btnLogin;
	
	@FindBy(linkText="Flights")
	@CacheLookup
	public WebElement linkFlights;
	
	@FindBy(css="a[href='mercurysignon.php']")
	@CacheLookup
	public WebElement linkSignIn;
	
	@FindBy(css="font>b")
	@CacheLookup
	public List<WebElement> labelUser;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	} 
	
	public LoginPage loginToApp(String username,String password) {
		waits.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(txtUsername)));
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public LoginPage clickSignin() {
		linkSignIn.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public FlightsPage clickFlightsLink() {
		linkFlights.click();
		return PageFactory.initElements(driver, FlightsPage.class);
	}
	
	public RegisterPage clickregister() {
		linkREGISTER.click();
		return PageFactory.initElements(driver, RegisterPage.class);
	}
	
	
}
