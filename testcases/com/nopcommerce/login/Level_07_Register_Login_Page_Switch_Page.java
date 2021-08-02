package com.nopcommerce.login;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level_07_Register_Login_Page_Switch_Page extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = "john" + getRandomEmail();
		password = "123456";
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Register_To_System() {
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToMaleGenderRadioButton();
		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Terry");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickOnRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogOutLink();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickOnLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	@Test
	public void Login_03_Switch_Page_At_Footer() {
		searchPage= homePage.openSearchPage();
		
		myAccountPage = searchPage.openMyAccountPage();
		
		orderPage = myAccountPage.openOrderPage();
		
		myAccountPage = orderPage.openMyAccountPage();
		
		searchPage = myAccountPage.openSearchPage();
	}
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
