package org.selenium.pom.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;//<---------------explicit wait-------------------------
	


	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));//<---------------explicit wait-------------------------
	}

	public void load(String endPoint) {
		driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
	}
	public void waitForOverlaysToDisappear(By overlay) {

		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("Overlay size: " + overlays.size());
		if (overlays.size() > 0) {
				wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));//<---------------explicit wait-------------------------
			System.out.println("Overlay are invisible");

		}else {
			System.out.println("Overlay not found");
		}
	}
	
	public WebElement getElement(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
