package com.automationpractice.code.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
	
	public WebDriver driver;
	public WebDriverWait waits;
	
	@FindBy(linkText="REGISTER")
    @CacheLookup
    public WebElement linkREGISTER;
	
  public StartPage(WebDriver driver) {
	  this.driver=driver;
	  waits=new WebDriverWait(driver, 10);
  }
  
  public LoginPage NavigateTo(String url) {
	driver.manage().window().maximize();
	driver.get(url);
	return PageFactory.initElements(driver, LoginPage.class);
  }
  
}
