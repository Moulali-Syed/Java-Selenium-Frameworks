package org.selenium.pom.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver initializeDriver(String browser) {
		
		WebDriver driver;
		//using browser from testng xml as a default browser
		//to read comman line arguments
		String localbrowser = System.getProperty("browser",browser);
		localbrowser = browser;
		switch(BrowserType.valueOf(localbrowser)) {
		case CHROME:
			WebDriverManager.chromedriver().cachePath("Drivers").setup();
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalStateException("Invalid browser name: "+browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
}
