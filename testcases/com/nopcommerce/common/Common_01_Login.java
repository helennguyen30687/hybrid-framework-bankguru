package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Common_01_Login extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	public static Set<Cookie> loginPageCookie;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser'" + browserName + "'navigate to'" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123456";

		log.info("Common_01 - Step 01: Verify Home Page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());

		log.info("Common_01 - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Common_01 - Step 03: Click to Male Radio Button");
		registerPage.clickToMaleGenderRadioButton();

		log.info("Common_01 - Step 04: Enter to First Name textbox");
		registerPage.enterToFirstNameTextbox("John");

		log.info("Common_01 - Step 05: Enter to Last Name textbox");
		registerPage.enterToLastNameTextbox("Terry");

		log.info("Common_01 - Step 06: Enter to Email textbox with value: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Common_01 - Step 07: Enter to Password textbox with value: " + password);
		registerPage.enterToPasswordTextbox(password);

		log.info("Common_01 - Step 08: Enter to Confirm Password textbox with value: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Common_01 - Step 09: Click on Register Button");
		registerPage.clickOnRegisterButton();
		registerPage.sleepInSecond(3);

		log.info("Common_01 - Step 10: Verify success message is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());

		log.info("Common_01 - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogOutLink();

		log.info("Common_01 - Step 12: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());

		log.info("Common_01 - Step 13: Click To Login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Common_01 - Step 14: Enter to email textbox with value: " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);

		log.info("Common_01 - Step 15: Enter to Password textbox with value: " + password);
		loginPage.enterToPasswordTextbox(password);

		log.info("Common_01 - Step 16: Click On Login Button");
		homePage = loginPage.clickOnLoginButton();

		log.info("Common_01 - Step 17: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());

		log.info("Common_01 - Step 18: Get all login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		System.out.println("driver tai common "+driver);
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