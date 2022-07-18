package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.selenium.pom.factory.*;
public class BaseTest {

	//data hiding -encapsulation , we r providing protected access modifier , so that only the class that inherit BaseTest can access the driver
	protected WebDriver driver;

	@BeforeMethod
	public void startDriver() {
		driver = new DriverManager().initializeDriver();
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
