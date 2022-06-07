package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	//notice how i'm not defaulting to use public access modifier , remember this 
	//expose only that is required ,hide everything else - this is encapsulation
//	private WebDriver driver;
	//notice how im not changing to public access modifier , just going one level up as 
	//required , as much as we like freedom to do anything , we also need to set some ground rules to follow
	//some restrictions.the driver shouldnot be accessible outside base class and sub classes.if we do so we r inviting
	//a lot of troubles down the line
	//with protected whichever classes are inheriting BaseTest class can only see driver[encapsulation - data hiding]
	//protected WebDriver driver;

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private void setDriver(WebDriver driver) {
		this.driver.set(driver);	
		}
	
	protected WebDriver getDriver() {
		return this.driver.get();
	}
	@Parameters("browser")
	@BeforeMethod
	public void startDriver(String browser) {
		browser = System.getProperty("browser",browser);
		setDriver(new DriverManager().initializeDriver(browser));
	}
	
	@AfterMethod
	public void quitDriver() {
		getDriver().quit();
	}

}
