package com.hrm.employee;

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

public class Level_16_Live_Coding extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "'navigate to'" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);

	}

	@Test
	public void Employee_01_Add_New_Employee() {

	}

	@Test
	public void Employee_02_Upload_Avatar() {

	}
	
	@Test
	public void Employee_03_Edit_Personal_Details() {

	}
	
	@Test
	public void Employee_01_Add_New_Employee() {

	}
	
	@Test
	public void Employee_01_Add_New_Employee() {

	}
	
	@Test
	public void Employee_01_Add_New_Employee() {

	}
	
	@Test
	public void Employee_01_Add_New_Employee() {

	}
	
	@Test
	public void Employee_01_Add_New_Employee() {

	}
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition - Close browser" + browserName);
		cleanBrowserAndDriver();
	}
}