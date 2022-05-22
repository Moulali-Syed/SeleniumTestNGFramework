package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

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

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	public CheckoutPage setFirstName(String fname) {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(fname);
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
		driver.findElement(placeOrderBtn).click();
		return this;
	}

	public String getNotice() {
		return driver.findElement(successNotice).getText();
	}

	public CheckoutPage clickHereToLoginLink() {
		driver.findElement(clickLoginBtn).click();
		return this;

	}

	public CheckoutPage enterUserName(String uname) {
		driver.findElement(userName).sendKeys(uname);
		return this;
	}

	public CheckoutPage enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
		return this;
	}

	public CheckoutPage clickLoginBtn() {
		driver.findElement(loginBtn).click();
		return this;
	}

	public CheckoutPage login(String uName, String pawd) {
		return enterUserName(uName).enterPassword(pawd).clickLoginBtn();
	}

}
