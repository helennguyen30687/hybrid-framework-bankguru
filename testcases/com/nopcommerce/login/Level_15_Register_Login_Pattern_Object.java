package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	String emailAddress, password, date, month,year;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "'navigate to'" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123456";
		date = "30";
		month = "July";
		year = "2005";
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void User_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());

		log.info("User_01_Register - Step 02: Click to Register Link");
		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("User_01_Register - Step 03: Click to Male Radio Button");
		registerPage.clickToRadioButtonByText(driver,"Male");

		log.info("User_01_Register - Step 04: Enter to First Name textbox");
		registerPage.enterToTextboxByID(driver,"FirstName","John");

		log.info("User_01_Register - Step 05: Enter to Last Name textbox");
		registerPage.enterToTextboxByID(driver,"LastName","Terry");
		
		log.info("User_01_Register - Step 06: Enter to Email textbox with value: " + emailAddress);
		registerPage.enterToTextboxByID(driver,"Email",emailAddress);

		log.info("User_01_Register - Step 07: Enter to Password textbox with value: " + password);
		registerPage.enterToTextboxByID(driver,"Password",password);

		log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value: " + password);
		registerPage.enterToTextboxByID(driver,"ConfirmPassword",password);
		
		log.info("User_01_Register - Step 09: Select item in Date dropdown");
		registerPage.clickToDropDownByName(driver,"DateOfBirthDay",date);
		
		log.info("User_01_Register - Step 10: Select item in Month dropdown");
		registerPage.clickToDropDownByName(driver,"DateOfBirthMonth",month);
		
		log.info("User_01_Register - Step 11: Select item in Year dropdown");
		registerPage.clickToDropDownByName(driver,"DateOfBirthYear",year);

		log.info("User_01_Register - Step 12: Click on Register Button");
		registerPage.clickToButtonByText(driver, "Register");
		registerPage.sleepInSecond(3);

		log.info("User_01_Register - Step 13: Verify success message is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("User_01_Register - Step 14: Click to Logout link");
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("User_01_Register - Step 15: Verify Home Page is displayed");
		//verifyFalse(homePage.isHomePageSliderDisplayed());
		verifyTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void User_02_Login_To_System() {
		log.info("User_02_login - Step 01: Click To Login link");
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("User_02_login - Step 02: Enter to email textbox with value: " + emailAddress);
		registerPage.enterToTextboxByID(driver, "Email", emailAddress);

		log.info("User_02_login - Step 03: Enter to Password textbox with value: " + password);
		registerPage.enterToTextboxByID(driver, "Password", password);

		log.info("User_02_login - Step 04: Click On Login Button");
		registerPage.clickToButtonByText(driver, "Log in");
		homePage =PageGeneratorManager.getHomePage(driver);
				
		log.info("User_02_login - Step 05: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition - Close browser" + browserName);
		cleanBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	SearchPageObject searchPage;
	OrderPageObject orderPage;
}