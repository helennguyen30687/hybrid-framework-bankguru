package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceLab.InventoryPageObject;
import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGenerator;


public class Level_18_Sort extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		inventoryPage=loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(inventoryPage.isProductNameSortAscending());
		
		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
		verifyTrue(inventoryPage.isProductNameSortDescending());

		
	}
	@Test
	public void Sort_02_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(inventoryPage.isProductNameSortDescending());

		
	}
	@Test
	public void Sort_03_Price() {
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		verifyTrue(inventoryPage.isProductPriceSortAscending());
		
		inventoryPage.selectItemInSortDropdown("Price (high to low)");
		verifyTrue(inventoryPage.isProductPriceSortDescending());
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition - Close browser" + browserName);
		cleanBrowserAndDriver();
	}

}