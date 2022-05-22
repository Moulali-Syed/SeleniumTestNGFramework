package org.selenium.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckoutPage extends BasePage {

	private final By firstName = By.id("billing_first_name");
	private final By lastname = By.id("billing_last_name");
	private final By address = By.id("billing_address_1");
	private final By city = By.id("billing_city");
	private final By zipCode = By.id("billing_postcode");
	private final By emailId = By.id("billing_email");
	private final By placeOrderBtn = By.id("place_order");
	private final By successNotice = By.cssSelector(".woocommerce-notice");

	private final By clickLoginBtn = By.xpath("//a[@class='showlogin']");
	private final By userName = By.id("username");
	private final By password = By.id("password");
	private final By loginBtn = By.name("login");
	private final By overlay = By.cssSelector(".blockUI.blockOverlay");

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	public CheckoutPage setFirstName(String fname) {
		WebElement e =  wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		e.clear();
		e.sendKeys(fname);
//		driver.findElement(firstName).clear();
//		driver.findElement(firstName).sendKeys(fname);
		return this;
	}

	public CheckoutPage setLastname(String lname) {
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(lname);
		return this;
	}

	public CheckoutPage setAddress(String add) {
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(add);
		return this;
	}

	public CheckoutPage setCity(String cityName) {
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(cityName);
		return this;
	}

	public CheckoutPage setZipCode(String zip) {
		driver.findElement(zipCode).clear();
		driver.findElement(zipCode).sendKeys(zip);
		return this;
	}

	public CheckoutPage setEmailId(String email) {
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(email);
		return this;
	}

	public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
		return setFirstName(billingAddress.getFirstName()).setLastname(billingAddress.getLastName())
				.setAddress(billingAddress.getAddressLine()).setCity(billingAddress.getCity())
				.setZipCode(billingAddress.getPostalCode()).setEmailId(billingAddress.getEmail()).setPlaceOrderBtn();
	}

	public CheckoutPage setPlaceOrderBtn() {
		waitForOverlaystoDisappear(overlay);
		driver.findElement(placeOrderBtn).click();
		return this;
	}

	public String getNotice() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
	}

	public CheckoutPage clickHereToLoginLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickLoginBtn)).click();
		
		return this;

	}

	public CheckoutPage enterUserName(String uname) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys(uname);
		
		return this;
	}

	public CheckoutPage enterPassword(String pwd) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pwd);
		
		return this;
	}

	public CheckoutPage clickLoginBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
	
		return this;
	}

	public CheckoutPage login(String uName, String pawd) {
		return enterUserName(uName).enterPassword(pawd).clickLoginBtn();
	}
	
	public CheckoutPage login1(User user) {
		return enterUserName(user.getUsername()).enterPassword(user.getPassword()).clickLoginBtn();
	}

}
