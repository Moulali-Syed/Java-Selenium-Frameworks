package org.selenium.pom.tests;

import java.io.IOException;

import org.selenium.pom.api.actions.CartApi;
import org.selenium.pom.api.actions.SignUpApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void loginDuringCheckout() throws IOException {
		String username = "demouser" + new FakerUtils().generateRandomNumber();
		User user = new User().setUsername(username).setPassword("demopwd").setEmail(username + "@askomdch.com");

		SignUpApi signupAPi = new SignUpApi();
		signupAPi.register(user);

		CartApi cartApi = new CartApi();
		Product product = new Product(1215);
		cartApi.addToCart(product.getId(), 1);

		injectCookiesToBrowser(cartApi.getCookies());

		CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load().clickLogin().showLogin();

		Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));

	}
}
