package org.selenium.pom.base;

import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.selenium.pom.utils.CookieUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.restassured.http.Cookies;
public class BaseTest {

	//data hiding -encapsulation , we r providing protected access modifier , so that only the class that inherit BaseTest can access the driver
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	//no body else should be able to set the browser , so make it private
	private void setDriver(WebDriver driver) {
		//every thread will get a local copy of this thread, there will be no conflict
		this.driver.set(driver);
	}
	
	//to make it accessible only in inherited classes
	protected WebDriver getDriver() {
		return this.driver.get();
	}
	@Parameters("browser")
	@BeforeMethod
	public void startDriver(@Optional String browser) {
		//use the setter method to set driver instance
		browser = System.getProperty("browser",browser);
		setDriver(new DriverManager().initializeDriver(browser));
		System.out.println("Current Thread: "+Thread.currentThread().getId() + ","+" Driver = "+getDriver());
	}

	@AfterMethod
	public void quitDriver() throws InterruptedException {
		//use getter method to quit the required instance of driver
		Thread.sleep(100);
		System.out.println("Current Thread: "+Thread.currentThread().getId() + ","+" Driver = "+getDriver());	
		getDriver().quit();
	}
	
	public void injectCookiesToBrowser(Cookies cookies) {
		List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
		
		for(Cookie cookie: seleniumCookies) {
			getDriver().manage().addCookie(cookie);
		}
	}
}
