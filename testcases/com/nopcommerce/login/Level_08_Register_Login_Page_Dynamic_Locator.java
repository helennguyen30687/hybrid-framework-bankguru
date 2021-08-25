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
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123456";
		homePage = new HomePageObject(driver);
	}

	//@Test
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

	//@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickOnLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
//	@Test
	public void Login_03_Open_Page_At_Footer() {
		
		//home=>search=>my acount =>order =>my account=>Search=>Order
		searchPage= (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver, "My account");
		
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver, "Orders");
		
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver, "My account");
		
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver,"Search");
		
		orderPage = (OrderPageObject) searchPage.getFooterPageByName(driver,"Orders");
	}
	
	@Test
	public void Login_04_Open_Page_At_Footer() {
		//home=>search=>my acount =>order =>my account=>Search=>Order
		homePage.openFooterPageByName(driver, "Search");
		searchPage= PageGeneratorManager.getSearchPage(driver);
		
		 searchPage.openFooterPageByName(driver, "My account");
		 myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		 
		myAccountPage.openFooterPageByName(driver, "Orders");
		orderPage =  PageGeneratorManager.getOrderPage(driver);
		
		orderPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		myAccountPage.openFooterPageByName(driver,"Search");
		 searchPage =PageGeneratorManager.getSearchPage(driver);
		
		searchPage.openFooterPageByName(driver,"Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
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