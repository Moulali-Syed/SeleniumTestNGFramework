package org.selenium.pom.tests;

import java.io.IOException;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;



public class MyFirstTestCaseTest extends BaseTest {

	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

		String searchFor = "Blue";
		// using jacksonUtils
		BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
		Product product = new Product(1215);
		StorePage storePage = new HomePage(getDriver()).load().clickStoreMenuLink().search(searchFor);

		//Assert.assertEquals(storePage.getTitle(), "Search results: ?"+searchFor+"?");
		Assert.assertTrue(storePage.getTitle().contains("Search results: "));	
		storePage.clickAddToCartBtn(product.getName());
		
		CartPage cartPage = storePage.clickViewCart();

		Assert.assertEquals(cartPage.getProductName(), product.getName());
		CheckoutPage checkoutPage = cartPage.clickCheckoutBtn().setBillingAddress(billingAddress);

		
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}

	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

		String searchFor = "Blue";
		BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
		Product product = new Product(1215);
		User user = new User("demouser2804", "demouser2804");

		StorePage storePage = new HomePage(getDriver()).load().clickStoreMenuLink().search(searchFor);

		//Assert.assertEquals(storePage.getTitle(), "Search results: ?"+searchFor+"?");
		Assert.assertTrue(storePage.getTitle().contains("Search results: "));	
		storePage.clickAddToCartBtn(product.getName());
		Thread.sleep(3000);
		CartPage cartPage = storePage.clickViewCart();

		Assert.assertEquals(cartPage.getProductName(), product.getName());
		CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
		checkoutPage.clickHereToLoginLink();
		Thread.sleep(5000);

		//checkoutPage.login(null, null)
		checkoutPage.login(user.getUsername(),user.getPassword()).setBillingAddress(billingAddress);
		Thread.sleep(7000);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}
}
