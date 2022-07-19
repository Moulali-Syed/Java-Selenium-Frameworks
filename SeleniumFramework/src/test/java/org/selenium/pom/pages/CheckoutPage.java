package org.selenium.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private final By firstnameFld = By.id("billing_first_name");
	private final By lastNameFld = By.id("billing_last_name");
	private final By addressLineOneFld = By.id("billing_address_1");
	private final By billingCityFld = By.id("billing_city");
	private final By billingPostCodeFld = By.id("billing_postcode");
	private final By billingEmailFld = By.id("billing_email");
	private final By placeOrderBtn = By.id("place_order");
	private final By successNotice = By.cssSelector(".woocommerce-notice");
	private final By showLogin = By.className("showlogin");
	private final By userName = By.id("username");
	private final By password = By.id("password");
	private final By login = By.name("login");
	private final By overlay = By.cssSelector(".blockUI.blockOverlay");
	private final By countryDropDown = By.id("billing_country");
	private final By stateDropdown  = By.id("billing_state");
	
	public CheckoutPage enterFirstName(String firstName) {
		WebElement e = getElement(firstnameFld);
		e.clear();
		e.sendKeys(firstName);
//		driver.findElement(firstnameFld).sendKeys(firstName);
		return this;
	}

	public CheckoutPage enterLastName(String lastName) {
		driver.findElement(lastNameFld).sendKeys(lastName);
		return this;
	}
	
	public CheckoutPage selectCountry(String countryName) {
		Select select = new Select(driver.findElement(countryDropDown));
		select.selectByVisibleText(countryName);
		return this;
	}

	public CheckoutPage enterAddressLineOne(String addressLineOne) {
		driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
		return this;
	}

	public CheckoutPage enterCity(String city) {
		driver.findElement(billingCityFld).sendKeys(city);
		return this;
	}

	public CheckoutPage selectState(String stateName) {
		Select select = new Select(driver.findElement(stateDropdown));
		select.selectByVisibleText(stateName);
		return this;
	}
	
	public CheckoutPage enterPostCode(String postCode) {
		driver.findElement(billingPostCodeFld).sendKeys(postCode);
		return this;
	}

	public CheckoutPage enterEmail(String email) {
		driver.findElement(billingEmailFld).sendKeys(email);
		return this;
	}
	
	public CheckoutPage placeOrder() {
		waitForOverlaysToDisappear(overlay);
		
		driver.findElement(placeOrderBtn).click();
		return this;
	}
	
	public String getNotice() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
//		return driver.findElement(successNotice).getText();
	}
	
	public CheckoutPage showLogin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(showLogin)).click();
//		driver.findElement(showLogin).click();
		return this;
	}
	
	public CheckoutPage enterUsername(String txt) {
		wait.until(ExpectedConditions.elementToBeClickable(userName)).sendKeys(txt);
//		driver.findElement(userName).sendKeys(txt);
		return this;
	}
	
	public CheckoutPage enterPassword(String txt) {
		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(txt);
//		driver.findElement(password).sendKeys(txt);
		return this;
	}
	
	public CheckoutPage clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
//		driver.findElement(login).click();
		return this;
	}

	public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
		return enterFirstName(billingAddress.getFirstName())
		.enterLastName(billingAddress.getLastName())
		.selectCountry(billingAddress.getCountry())
		.enterAddressLineOne(billingAddress.getAddressLineOne())
		.enterCity(billingAddress.getCity())
		.selectState(billingAddress.getCity())
		.enterPostCode(billingAddress.getPostalCode())
		.enterEmail(billingAddress.getEmail());
	}
}
