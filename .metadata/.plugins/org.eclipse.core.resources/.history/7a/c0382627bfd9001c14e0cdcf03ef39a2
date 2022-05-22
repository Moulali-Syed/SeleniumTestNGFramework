package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	//notice how i'm not defaulting to use public access modifier , remember this 
	//expose only that is required ,hide everything else - this is encapsulation
//	private WebDriver driver;
	//notice how im not changing to public access modifier , just going one level up as 
	//required , as much as we like freedom to do anything , we also need to set some ground rules to follow
	//some restrictions.the driver shouldnot be accessible outside base class and sub classes.if we do so we r inviting
	//a lot of troubles down the line
	//with protected whichever classes are inheriting BaseTest class can only see driver[encapsulation - data hiding]
	protected WebDriver driver;

	@BeforeMethod
	public void startDriver() {
		driver = new DriverManager().initializeDriver();
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

}
