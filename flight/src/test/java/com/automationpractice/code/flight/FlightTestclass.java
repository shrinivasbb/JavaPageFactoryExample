package com.automationpractice.code.flight;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.PropertiesFile;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class FlightTestclass {
  
	public WebDriver driver;
	public StartPage startPage;
	public SelectFlightsPage selectFlightsPage;
	public LoginPage loginPage;
	public BookAFlightPage bookAFlightPage;
	public FlightConfirmationPage flightConfirmationPage;
	public RegisterPage registerPage;
	public FlightsPage flightsPage;
	public PropertiesFile propertiesfile;
	public Properties properties;
	public SoftAssert softAssert;
	
	
  @BeforeTest(alwaysRun=true)
  public void beforeTest() throws IOException {
	  softAssert=new SoftAssert();
	  String projPath=System.getProperty("user.dir");
	  propertiesfile=new PropertiesFile(projPath+"/src/test/resources/data.properties");
	  properties=propertiesfile.getProperties();
	  if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
		 if(System.getProperty("os.name").indexOf("nix")>=0||System.getProperty("os.name").indexOf("nux")>=0) {
			 driver=new ChromeDriver();
		 }
		 else {
		  System.setProperty("webdriver.chrome.driver", projPath+"/src/test/resources/chromedriver.exe");
		  	driver=new ChromeDriver();
		 }
	  }
	  else  {
		  System.setProperty("webdriver.gecko.driver", projPath+"/src/test/resources/geckodriver.exe");
		  driver=new FirefoxDriver();
	  }
		  
	  startPage=new StartPage(driver);
	  loginPage=startPage.NavigateTo(properties.getProperty("url"));
  }
  

  @Test
  public void flightOperationsTest() {
	  
	  registerPage=loginPage.clickregister();
	  loginPage=registerPage.registerUser(properties.getProperty("username"), properties.getProperty("password"))
			                .clickSignin();
	  softAssert.assertEquals(loginPage.labelUser.get(1).getText().trim(), "Note: Your user name is "+properties.getProperty("username")+".");
	  loginPage.loginToApp(properties.getProperty("username"), properties.getProperty("password"));
	  flightsPage=loginPage.clickFlightsLink();
	  selectFlightsPage=flightsPage.fillFormPage(properties.getProperty("passengers"),properties.getProperty("from"),
			                                     properties.getProperty("frommonth"),properties.getProperty("fromday"),
			                                     properties.getProperty("to"),properties.getProperty("tomonth"),
			                                     properties.getProperty("today"),properties.getProperty("airline"));
	  
	  softAssert.assertEquals(selectFlightsPage.lableTravel.get(0).getText(), 
			                    properties.getProperty("from")+ " to "+properties.getProperty("to"));
	  softAssert.assertEquals(selectFlightsPage.lableTravel.get(2), properties.getProperty("to")+ " to "+properties.getProperty("from"));
	  
	  bookAFlightPage=selectFlightsPage.selectFlight();
	  flightConfirmationPage=bookAFlightPage.fillDetailsAndPurchase(properties.getProperty("passfname1"),properties.getProperty("passlname1"),
			  														properties.getProperty("passfname2"),properties.getProperty("passlname2"),
			  														properties.getProperty("creditcard"));
	  flightConfirmationPage.logoutFromApp();
  }
  
  
  
  
  @AfterTest(alwaysRun=true)
  public void afterTest() {
	  driver.quit();
  }

}
