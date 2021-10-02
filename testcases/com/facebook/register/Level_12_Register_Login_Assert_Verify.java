package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Register_Login_Assert_Verify extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Verify() {
		//Failed lan 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());

		registerPage.enterToEmailTextbox("helen@gmail.com");
		registerPage.sleepInSecond(2);
		//Failed Lan 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		verifyTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		//Failed lan 3
		verifyFalse(registerPage.isLoginButtonUndisplayed());
	}


	public void cleanBrowser() {
		driver.quit();
	}

	RegisterPageObject registerPage;
}