package com.nopcommerce.login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
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

public class Level_13_Register_Login_Log_Extent_Report_V2 extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123456";
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Verify Home Page is displayed");
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 02: Click to Register Link");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 03: Click to Male Radio Button");
//		registerPage.clickToMaleGenderRadioButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 04: Enter to First Name textbox");
//		registerPage.enterToFirstNameTextbox("John");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 05: Enter to Last Name textbox");
//		registerPage.enterToLastNameTextbox("Terry");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 06: Enter to Email textbox with value: " + emailAddress);
//		registerPage.enterToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 07: Enter to Password textbox with value: " + password);
//		registerPage.enterToPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 08: Enter to Confirm Password textbox with value: " + password);
//		registerPage.enterToConfirmPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 09: Click on Register Button");
//		registerPage.clickOnRegisterButton();
//		registerPage.sleepInSecond(3);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 10: Verify success message is displayed");
//		verifyTrue(registerPage.isSuccessMessageDisplayed());
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 11: Click to Logout link");
//		homePage = registerPage.clickToLogOutLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 12: Verify Home Page is displayed");
//		verifyFalse(homePage.isHomePageSliderDisplayed());
//
//		ExtentTestManager.endTest();
	}

	@Test
	public void User_02_Login_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_02_login");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_login - Step 01: Click To Login link");
//		loginPage = homePage.clickToLoginLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_login - Step 02: Enter to email textbox with value: " + emailAddress);
//		loginPage.enterToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_login - Step 03: Enter to Password textbox with value: " + password);
//		loginPage.enterToPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_login - Step 04: Click On Login Button");
//		homePage = loginPage.clickOnLoginButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_login - Step 05: Verify Home Page is displayed");
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//		
//		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	SearchPageObject searchPage;
	OrderPageObject orderPage;
}