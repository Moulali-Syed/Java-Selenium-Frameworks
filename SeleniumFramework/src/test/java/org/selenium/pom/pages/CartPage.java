package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

	/*private final By productName = By.cssSelector("td[class='product-name'] a");
	private final By checkoutBtn = By.cssSelector(".checkout-button");*/
	private final By cartHeading = By.cssSelector(".has-text-align-center");
	
	@FindBy(css="td[class='product-name'] a") private WebElement productName;
	@FindBy(how = How.CSS ,using=".checkout-button") @CacheLookup private WebElement checkoutBtn;
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);//if we are using Pagefactory in all pages , then we can keep this statement
		//in the BasePage constructor instead duplicating it in all the page classes constructor
	}

	public Boolean isLoaded() {
		//wait for the element that takes more time
		return wait.until(ExpectedConditions.textToBe(cartHeading,"Cart"));
	}
	

	public String getProductName() {
		
		return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
//		return productName.getText();
	}

	public CheckoutPage checkout() {
		//now we can use the explicit wait for the element , whichever to be waited by using the below syntax of explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
//		checkoutBtn.click();
		return new CheckoutPage(driver);
	}
}
