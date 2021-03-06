package org.selenium.pom.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	//initialize driver and return webdriver object
	public WebDriver initializeDriver(String browser) {
		WebDriver driver;
		
		
		switch(DriverType.valueOf(browser)) {
		case CHROME:
			WebDriverManager.chromedriver().cachePath("Drivers").setup();
			 driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalStateException("Invalid browser name: "+browser);
			
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
}
