package testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Close_Browser {
	WebDriver driver;

	@BeforeClass // Pre-condition
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");

		// init browser/driver
		// init page class
		// init data test
		// Query to DB
		// create flow for below TC
		Assert.assertTrue(false);
	}

	@Test
	public void TC_01() {
	}

	@Test
	public void TC_02() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
