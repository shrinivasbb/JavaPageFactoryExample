package com.automationpractice.code.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends StartPage {

	@FindBy(id="email")
    @CacheLookup
    public WebElement txtEmail;
	
	@FindBy(name="password")
    @CacheLookup
    public WebElement txtPassword;
	
	@FindBy(name="confirmPassword")
    @CacheLookup
    public WebElement txtConfirmpassword;
	
	@FindBy(name="register")
    @CacheLookup
    public WebElement btnRegister;


	public RegisterPage(WebDriver driver) {
		super(driver);
		waits=new WebDriverWait(driver, 10);
	}
	
	public LoginPage registerUser(String username,String password) {
		//waits.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(txtEmail)));
		txtEmail.sendKeys(username);
		txtPassword.sendKeys(password);
		txtConfirmpassword.sendKeys(password);
		btnRegister.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	

}
