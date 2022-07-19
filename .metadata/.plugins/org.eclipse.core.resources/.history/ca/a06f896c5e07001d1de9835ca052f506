package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	public HomePage load() {
		load("/");
		return this;
	}
	private final By storemenuLink = By.cssSelector("#menu-item-1227 > a");
	
	

	public StorePage navigateToStoreUsingMenu() {
		driver.findElement(storemenuLink).click();
		return new StorePage(driver);
	}
}
