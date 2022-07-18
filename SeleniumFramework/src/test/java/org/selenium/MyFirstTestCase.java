package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

		

		HomePage homePage = new HomePage(driver).load();
		StorePage storePage = homePage.navigateToStoreUsingMenu();

		storePage.search("Blue");

		Assert.assertEquals(storePage.getTitle(), "Search results: �Blue�");
		storePage.clickAddToCartBtn("Blue Shoes");
		Thread.sleep(4000);
		CartPage cartPage = storePage.clickViewCart();

		Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

		CheckoutPage checkoutPage = cartPage.checkout();

		checkoutPage.enterFirstName("demo").enterLastName("user").enterAddressLineOne("San Fransico")
				.enterCity("San Fransico").enterPostCode("94188").enterEmail("askomdch@gamil.com").placeOrder();

		Thread.sleep(5000);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}

	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

	
		HomePage homePage = new HomePage(driver).load();
		StorePage storePage = homePage.navigateToStoreUsingMenu();

		storePage.search("Blue");

		Assert.assertEquals(storePage.getTitle(), "Search results: �Blue�");
		storePage.clickAddToCartBtn("Blue Shoes");
		Thread.sleep(4000);
		CartPage cartPage = storePage.clickViewCart();

		Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

		CheckoutPage checkoutPage = cartPage.checkout();

		checkoutPage.showLogin();

		Thread.sleep(3000);

		checkoutPage.enterUsername("demouser987").enterPassword("demouser987").clickLogin();
		Thread.sleep(5000);
		checkoutPage.enterFirstName("").enterLastName("").enterAddressLineOne("").enterCity("").enterPostCode("");
		Thread.sleep(5000);
//		checkoutPage.enterFirstName("demo").enterLastName("user").enterAddressLineOne("San Fransico")
//				.enterCity("San Fransico").enterPostCode("94188");

		checkoutPage.enterEmail("");
		checkoutPage.enterEmail("demouser987").placeOrder();

		Thread.sleep(5000);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}
}