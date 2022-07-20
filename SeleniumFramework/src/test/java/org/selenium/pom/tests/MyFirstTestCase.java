package org.selenium.pom.tests;

import java.io.IOException;
import java.io.InputStream;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

		String searchFor = "Blue";
/*		BillingAddress billingAddress = new BillingAddress();
		billingAddress.setFirstName("demo");
		billingAddress.setLastName("user");
		billingAddress.setAddressLineOne("San Fransico");
		billingAddress.setCity("San Fransico");
		billingAddress.setPostalCode("94188");
		billingAddress.setEmail("askomdch@gamil.com");*/
		
//		BillingAddress billingAddress = new BillingAddress("demo","user","San Fransico","San Fransico","94188","askomdch@gmail.com");
		
		//now instead of hardcoding data as above, we can pass from json file
		/*BillingAddress billingAddress = new BillingAddress();
		InputStream is = getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");
		billingAddress = JacksonUtils.deserializeJson(is, billingAddress);*/
		
		//now we have generalized the deserializejson method we can write below code
		BillingAddress billingAddress = JacksonUtils.deserializeJson("\\resources\\myBillingAddress.json",BillingAddress.class);
		Product product = new Product(1215);

		HomePage homePage = new HomePage(getDriver()).load(); //-------------------<
		StorePage storePage = homePage.navigateToStoreUsingMenu();
		storePage.isLoaded(); //-------------------<
		storePage.search(searchFor);

		Assert.assertEquals(storePage.getTitle(), "Search results: "+searchFor+"");
		storePage.clickAddToCartBtn(product.getName());
		Thread.sleep(4000);
		CartPage cartPage = storePage.clickViewCart();
		cartPage.isLoaded(); //-------------------<
		Assert.assertEquals(cartPage.getProductName(), product.getName());

		CheckoutPage checkoutPage = cartPage.checkout().setBillingAddress(billingAddress).placeOrder();

		Thread.sleep(5000);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}
	
	@Test
	public void guestCheckoutUsingDirectBankTransfer1() throws InterruptedException, IOException {

		// using jacksonUtils
		BillingAddress billingAddress = JacksonUtils.deserializeJson("\\resources\\myBillingAddress.json", BillingAddress.class);

		StorePage storePage = new HomePage(getDriver()).load().navigateToStoreUsingMenu().search("Blue");

		Assert.assertEquals(storePage.getTitle(), "Search results: Blue");
		storePage.clickAddToCartBtn("Blue Shoes");
		Thread.sleep(3000);
		CartPage cartPage = storePage.clickViewCart();

		Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
		CheckoutPage checkoutPage = cartPage.checkout().setBillingAddress(billingAddress).placeOrder();

		Thread.sleep(5000);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}

	@Test
	public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

		String searchFor = "Blue";
		BillingAddress billingAddress = JacksonUtils.deserializeJson("\\resources\\myBillingAddress.json",BillingAddress.class);
		Product product = new Product(1215);
		
		User user = new User(ConfigLoader.getInstance().getUsername(),ConfigLoader.getInstance().getPassword());
		
		
		HomePage homePage = new HomePage(getDriver()).load();
		StorePage storePage = homePage.navigateToStoreUsingMenu();

		storePage.search("Blue");

		Assert.assertEquals(storePage.getTitle(), "Search results: "+searchFor+"");
		storePage.clickAddToCartBtn(product.getName());
		Thread.sleep(4000);
		CartPage cartPage = storePage.clickViewCart();

		Assert.assertEquals(cartPage.getProductName(), product.getName());

		CheckoutPage checkoutPage = cartPage.checkout();

		checkoutPage.showLogin();

		Thread.sleep(3000);

		checkoutPage.enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLogin();
		Thread.sleep(5000);
		checkoutPage.setBillingAddress(billingAddress);
		Thread.sleep(5000);
//		checkoutPage.enterFirstName("demo").enterLastName("user").enterAddressLineOne("San Fransico")
//				.enterCity("San Fransico").enterPostCode("94188");

		checkoutPage.enterEmail("");
		checkoutPage.enterEmail("demouser987").placeOrder();

		Thread.sleep(5000);
		Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

	}
}
