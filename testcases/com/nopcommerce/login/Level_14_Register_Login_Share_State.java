package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_14_Register_Login_Share_State extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Open browser '" + browserName + "' navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		System.out.println("driver tai level 14 "+driver);
		emailAddress = getRandomEmail();
		password = "123456";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition - Step 01: Click To Login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 02: Set login page cookie");
		
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		loginPage.sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);
		
		log.info("Pre-condition - Step 03: Click to HomePage displayed");
		homePage = loginPage.openHomePage(driver);

		log.info("Pre-condition - Step 04: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void User_01_Create_New_Account() {

	}

	@Test
	public void User_02_Move_Account() {

	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition - Close browser " + browserName);
		cleanBrowserAndDriver();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	SearchPageObject searchPage;
	OrderPageObject orderPage;
}