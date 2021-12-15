package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environmentConfig.Environment;
import retryConfig.RetryListener;

@Listeners(RetryListener.class)
public class Level_21_Multiple_Environment extends BaseTest {
	Environment environment;
	WebDriver driver;

	@Parameters({"browser","environment"})
	@BeforeClass
	public void beforeClass(String browserName, String env) {
		ConfigFactory.setProperty("env", env);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(browserName, environment.appUrl());
		System.out.println(environment.osName());
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
	public void Employee_04_Edit_Contact_Details() {

	}

	@Test
	public void Employee_05_Emergency_Details() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@Test
	public void Employee_12_Memberships() {

	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition - Close browser" + browserName);
		cleanBrowserAndDriver();
	}

}