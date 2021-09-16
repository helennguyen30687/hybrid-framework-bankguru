package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_11_Register_Login_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());

		registerPage.enterToEmailTextbox("helen@gmail.com");
		registerPage.sleepInSecond(2);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
	}

	@Test
	public void Register_03_Element_Undisplayed_Not_In_DOM() {
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
	}

	@Test
	public void Register_04_Element_Undisplayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
	}

	public void cleanBrowser() {
		driver.quit();
	}

	RegisterPageObject registerPage;
}