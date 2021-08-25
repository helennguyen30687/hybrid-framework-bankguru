package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));

		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));

		homePage.openPageByNumber("12");
		Assert.assertTrue(homePage.isPageActiveByNumber("12"));
	}

	//@Test
	public void Table_02_Input() {
		// input textbox
		homePage.inputToHeaderTextboxByName("Females", "1920");

		homePage.inputToHeaderTextboxByName("Country", "Sao Tome and Principe");

		homePage.inputToHeaderTextboxByName("Males", "2130");

		homePage.inputToHeaderTextboxByName("Total", "4110");
		homePage.refreshCurrentPage(driver);
	}
	//@Test
	public void Table_03_Click_Icon() {
		// click button
		homePage.openPageByNumber("2");
		Assert.assertTrue(homePage.isPageActiveByNumber("2"));
		homePage.sleepInSecond(3);
		homePage.clickToIconByCountryName("Azerbaijan", "remove");
		homePage.clickToIconByCountryName("Bahrain", "remove");
		homePage.clickToIconByCountryName("Belarus", "edit");
		homePage.refreshCurrentPage(driver);
	}
	//@Test
	public void Table_04_Verify_Data() {
		homePage.inputToHeaderTextboxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplayed("384187","Afghanistan","407124","791312"));
	}
	
	//@Test
	public void Table_05_Input_To_Row_Textbox() {
		homePage.inputToTextboxRowNumber("Contact Person","2","Helen");
		homePage.sleepInSecond(3);
		homePage.inputToTextboxRowNumber("Order Placed","3","Nguyen");
		homePage.sleepInSecond(3);
		//homePage.inputToTextboxRowNumber("Member Since","1","02/12/1993");
		//homePage.sleepInSecond(3);
	}
	
	@Test
	public void Table_06_Click_Icon_At_Row() {
		homePage.clickToIconByRowNumber("3","Move Up");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.sleepInSecond(3);
	}
	// @AfterClass
	public void afterClass() {
		driver.quit();
	}

}