package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NaviagtionTest extends BaseTest {

	@Test
	public void NavigateFromHomeToStoreUisngMainMenu() {

		HomePage homePage = new HomePage(getDriver()).load();
		StorePage storePage = homePage.navigateToStoreUsingMenu();

		Assert.assertEquals(storePage.getTitle(), "Store");
	}

}
