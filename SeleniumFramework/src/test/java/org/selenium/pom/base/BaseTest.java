package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.selenium.pom.factory.*;
public class BaseTest {

	//data hiding -encapsulation , we r providing protected access modifier , so that only the class that inherit BaseTest can access the driver
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void startDriver(String browser) {
		driver = new DriverManager().initializeDriver(browser);
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
