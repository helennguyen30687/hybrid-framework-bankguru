package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Driver at TestCase = " + driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		emailAddress = "john" + getRandomEmail();
		password = "123456";

	}

	@Test
	public void Login_01_Empty_Email_Password() {
		driver.get("http://live.demoguru99.com/index.php");
		homePage = new HomePageObject(driver);
		
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmailEmptyErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getPasswordEmptyErrorMessage(), "This is a required field.");
	}

	//@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("helen@123.456");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
//	@Test(description = "Password less than 6 characters")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
//	@Test(description = "Email not exist in system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("holo@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}
	
//	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("helen@gmail.com");
		loginPage.enterToPasswordTextbox("1234567");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage.loginToSystem("helen@gmail.com", "123456");
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "helennguyen" + rand.nextInt(9999) + "@gmail.com";
	}

	public void cleanBrowser() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
}
