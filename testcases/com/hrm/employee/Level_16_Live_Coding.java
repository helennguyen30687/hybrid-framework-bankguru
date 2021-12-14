package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePageObject;
import pageObjects.hrm.DashboardPageObject;
import pageObjects.hrm.EmployeeListPageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGenerator;
import retryConfig.RetryListener;
import utilities.DataHelper;
import pageObjects.hrm.MyInfoPageObject;

@Listeners(RetryListener.class)
public class Level_16_Live_Coding extends BaseTest {
	WebDriver driver;
	String adminUserName, adminPassword, empFirstName, empLastName, empFullName, empUserName, empPassword, statusValue, employeeID;
	String avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "Avatar.jpg";
	String editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNational;
	String editConAdd1, editConAdd2, editConCity, editConState, editConZip, editConCountry, editConHomeTel, editConMobile, editConWorkTel,
			editConWorkEmail, editConOtherEmail;
	String memAmount, memSubCommenceDate, memSubRenewalDate, memMembership, memSubPaidBy, memCurrency;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "'navigate to'" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		statusValue = "Enabled";
		adminUserName = "Admin";
		adminPassword = "admin123";
		empFirstName = "Helen";
		empLastName = "Tran";
		empFullName = empFirstName + " " + empLastName;
		empUserName = "Helentran124";
		empPassword = "Helentran124";

		editEmpFirstName = "John";
		editEmpLastName = "Wick";
		editEmpGender = "Male";
		editEmpMaritalStatus = "Single";
		editEmpNational = "Vietnamese";

		editConAdd1 = "Ho Xuan Huong";
		editConAdd2 = "Tan Hung";
		editConCity = "Bao Loc";
		editConState = "Lam Dong";
		editConZip = "70010";
		editConCountry = "Bangladesh";
		editConHomeTel = "0526355982";
		editConMobile = "0568974123";
		editConWorkTel = "8918795322";
		editConWorkEmail = "johnwick1@gmail.com";
		editConOtherEmail = "johnwick2@gmail.com";

		memAmount = "32.00";
		memSubCommenceDate = "2014-10-01";
		memSubRenewalDate = "2018-11-02";
		memMembership = "British Computer Society (BCS)";
		memSubPaidBy = "Individual";
		memCurrency = "United States Dollar";

		log.info("Pre-condition - Step 02: Login with 'Admin' role ");
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open 'Employee List' page");
		dashboardPage.openSubMenuPageHRM(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 02: Click 'Add' button");
		employeeListPage.clickToButtonByIDHRM(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePage(driver);

		log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxByIDHRM(driver, "firstName", empFirstName);

		log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByIDHRM(driver, "lastName", empLastName);

		log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getTextboxValueByIDHRM(driver, "employeeId");

		log.info("Add_New_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabelHRM(driver, "Create Login Details");

		log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByIDHRM(driver, "user_name", empUserName);

		log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByIDHRM(driver, "user_password", empPassword);

		log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByIDHRM(driver, "re_password", empPassword);

		log.info("Add_New_01 - Step 10: Select '" + statusValue + "' value in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByIDHRM(driver, "status", statusValue);

		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByIDHRM(driver, "btnSave");
		myInfoPage = PageGenerator.getPersonalDetailPageO(driver);

		log.info("Add_New_01 - Step 12: Open 'Employee List' page");
		myInfoPage.openSubMenuPageHRM(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAndAjaxLoadedSuccess(driver));
		employeeListPage.enterToTextboxByIDHRM(driver, "empsearch_employee_name_empName", empFullName);
		verifyTrue(employeeListPage.isJQueryAndAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByIDHRM(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAndAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - Step 15: Verify Employee Information displayed at 'Result Table'");
		//verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "resultTable", "Id", "1"), employeeID);

	//	verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "resultTable", "First (& Middle) Name", "1"), empFirstName);

	//	verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "resultTable", "Last Name", "1"), empLastName);
	}

	//@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar_02 - Step 01: Login with Employee Role");
		loginPage = employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(driver, empUserName, empPassword);

		log.info("Upload_Avatar_02 - Step 02: Open personal Detail Page");
		dashboardPage.openMenuPageHRM(driver, "My Info");
		myInfoPage = PageGenerator.getPersonalDetailPageO(driver);

		log.info("Upload_Avatar_02 - Step 03: Click to change avatar image");
		myInfoPage.clickToChangeAvatarImag();

		log.info("Upload_Avatar_02 - Step 04: Upload new avatar image");
		myInfoPage.uploadImage(driver, avatarFilePath);

		log.info("Upload_Avatar_02 - Step 05: Click to upload button");
		myInfoPage.clickToButtonByIDHRM(driver, "btnSave");

		log.info("Upload_Avatar_02 - Step 06: Verify success message displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Uploaded"));

		log.info("Upload_Avatar_02 - Step 07: Verify new Avatar displayed correctly");
		verifyTrue(myInfoPage.isNewAvatarImageDisplayed());
	}

	//@Test
	public void Employee_03_Edit_Personal_Details() {
		log.info("Personal_Detail_03 - Step 01: Open 'Personal Details' form at Side bar");
		myInfoPage.openTabAtSideBarByName("Personal Details");

		log.info("Personal_Detail_03 - Step 02: Verify all fields at 'Personal Details' are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

		log.info("Personal_Detail_03 - Step 03: Click to 'Edit' button at 'Personal Details' form");
		myInfoPage.clickToButtonByIDHRM(driver, "btnSave");

		log.info("Personal_Detail_03 - Step 04: Verify 'Employee Id' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));

		log.info("Personal_Detail_03 - Step 05: Verify 'Driver's License Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));

		log.info("Personal_Detail_03 - Step 06: Verify 'SSN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));

		log.info("Personal_Detail_03 - Step 07: Verify 'SIN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));

		log.info("Personal_Detail_03 - Step 08: Verify 'Date of Birth' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

		log.info("Personal_Detail_03 - Step 09: Enter new value to First Name textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "personal_txtEmpFirstName", editEmpFirstName);

		log.info("Personal_Detail_03 - Step 10: Enter new value to Last Name textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "personal_txtEmpLastName", editEmpLastName);

		log.info("Personal_Detail_03 - Step 11: Select new value to 'Gender' radiobutton");
		myInfoPage.clickToRadioByLabelHRM(driver, editEmpGender);

		log.info("Personal_Detail_03 - Step 12: Select new value to 'Marital Status' dropdown");
		myInfoPage.selectItemInDropdownByIDHRM(driver, "personal_cmbMarital", editEmpMaritalStatus);

		log.info("Personal_Detail_03 - Step 13: Select new value to 'Nationality' dropdown");
		myInfoPage.selectItemInDropdownByIDHRM(driver, "personal_cmbNation", editEmpNational);

		log.info("Personal_Detail_03 - Step 14: Click to 'Save' button at 'Personal Details' form");
		myInfoPage.clickToButtonByIDHRM(driver, "btnSave");

		log.info("Personal_Detail_03 - Step 15: Verify Success message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Personal_Detail_03 - Step 16: Verify 'First Name' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "personal_txtEmpFirstName"), editEmpFirstName);

		log.info("Personal_Detail_03 - Step 17: Verify 'Last Name' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "personal_txtEmpLastName"), editEmpLastName);

		log.info("Personal_Detail_03 - Step 18: Verify 'Gender' radiobutton is updated successfully");
		verifyTrue(myInfoPage.isRadioButtonSelectedByLabel(driver, editEmpGender));

		log.info("Personal_Detail_03 - Step 19: Verify 'Marital Status' dropdown is updated successfully");
		verifyEquals(myInfoPage.getSelectedValueInDropDownByIDHRM(driver, "personal_cmbMarital"), editEmpMaritalStatus);

		log.info("Personal_Detail_03 - Step 20: Verify 'Nationality' dropdown is updated successfully");
		verifyEquals(myInfoPage.getSelectedValueInDropDownByIDHRM(driver, "personal_cmbNation"), editEmpNational);

		log.info("Personal_Detail_03 - Step 18: Verify 'EmployeeID' textbox value is displayed correctly");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "personal_txtEmployeeId"), employeeID);
	}

//	@Test
	public void Employee_04_Edit_Contact_Details() {
		log.info("Contact_Details_04 - Step 01: Open 'Contact Details' tab at Side bar");
		myInfoPage.openTabAtSideBarByName("Contact Details");

		log.info("Contact_Details_04 - Step 02: Verify all fields at 'Contact Details' form are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_city"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_province"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_country"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_zipcode"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_email"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_oth_email"));

		log.info("Contact_Details_04 - Step 03: Click to 'Edit' button at 'Contact Details' form ");
		myInfoPage.clickToButtonByIDHRM(driver, "btnSave");

		log.info("Contact_Details_04 - Step 04: Enter value to 'Address Street 1' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_street1", editConAdd1);

		log.info("Contact_Details_04 - Step 05: Enter value to 'Address Street 2' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_street2", editConAdd2);

		log.info("Contact_Details_04 - Step 06: Enter value to 'City' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_city", editConCity);

		log.info("Contact_Details_04 - Step 07: Enter value to 'State/Province' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_province", editConState);

		log.info("Contact_Details_04 - Step 08: Enter value to 'Zip/Postal Code' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_emp_zipcode", editConZip);

		log.info("Contact_Details_04 - Step 09: Select new value to 'Country' dropdown");
		myInfoPage.selectItemInDropdownByIDHRM(driver, "contact_country", editConCountry);

		log.info("Contact_Details_04 - Step 10: Enter value to 'Home Telephone' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_emp_hm_telephone", editConHomeTel);

		log.info("Contact_Details_04 - Step 11: Enter value to 'Mobile' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_emp_mobile", editConMobile);

		log.info("Contact_Details_04 - Step 12: Enter value to 'Work Telephone' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_emp_work_telephone", editConWorkTel);

		log.info("Contact_Details_04 - Step 13: Enter value to 'Work Email' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_emp_work_email", editConWorkEmail);

		log.info("Contact_Details_04 - Step 14: Enter value to 'Other Email' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "contact_emp_oth_email", editConOtherEmail);

		log.info("Contact_Details_04 - Step 15: Click to 'Save' button at 'Contact Details' form");
		myInfoPage.clickToButtonByIDHRM(driver, "btnSave");

		log.info("Personal_Detail_03 - Step 16: Verify Success message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Contact_Details_04 - Step 17: Verify 'Address Street 1' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_street1"), editConAdd1);

		log.info("Contact_Details_04 - Step 18: Verify 'Address Street 2' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_street2"), editConAdd2);

		log.info("Contact_Details_04 - Step 19: Verify 'City' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_city"), editConCity);

		log.info("Contact_Details_04 - Step 20: Verify 'State/Province' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_province"), editConState);

		log.info("Contact_Details_04 - Step 21: Verify 'Zip/Postal Code' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_emp_zipcode"), editConZip);

		log.info("Contact_Details_04 - Step 22: Verify 'Country' dropdown is updated successfully");
		verifyEquals(myInfoPage.getSelectedValueInDropDownByIDHRM(driver, "contact_country"), editConCountry);

		log.info("Contact_Details_04 - Step 23: Verify 'Home Telephone' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_emp_hm_telephone"), editConHomeTel);

		log.info("Contact_Details_04 - Step 24: Verify 'Mobile' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_emp_mobile"), editConMobile);

		log.info("Contact_Details_04 - Step 25: Verify 'Work Telephone' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_emp_work_telephone"), editConWorkTel);

		log.info("Contact_Details_04 - Step 26: Verify 'Work Email' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_emp_work_email"), editConWorkEmail);

		log.info("Contact_Details_04 - Step 27: Verify 'Other Email' textbox is updated successfully");
		verifyEquals(myInfoPage.getTextboxValueByIDHRM(driver, "contact_emp_oth_email"), editConOtherEmail);

	}

	//@Test
	public void Employee_05_Emergency_Details() {

	}

	//@Test
	public void Employee_06_Assigned_Dependents() {

	}

	//@Test
	public void Employee_07_Edit_View_Job() {

	}

	//@Test
	public void Employee_08_Edit_View_Salary() {

	}

	//@Test
	public void Employee_09_Edit_View_Tax() {

	}

	//@Test
	public void Employee_10_Qualifications() {

	}

	//@Test
	public void Employee_11_Search_Employee() {

	}

	//@Test
	public void Employee_12_Memberships() {
		log.info("Membership_12 - Step 01: Open 'Add Membership' tab at Side bar");
		myInfoPage.openTabAtSideBarByName("Memberships");

		log.info("Membership_12 - Step 01: Click 'Add' button at 'Assigned Memberships' page");
		myInfoPage.clickToButtonByIDHRM(driver, "btnAddMembershipDetail");

		log.info("Membership_12 - Step 01: Select value to 'Membership' dropdown at 'Add Membership' page");
		myInfoPage.selectItemInDropdownByIDHRM(driver, "membership_membership", memMembership);

		log.info("Membership_12 - Step 01: Select value to 'Subscription Paid By' dropdown");
		myInfoPage.selectItemInDropdownByIDHRM(driver, "membership_subscriptionPaidBy", memSubPaidBy);

		log.info("Membership_12 - Step 01: Enter value to 'Subscription Amount' textbox");
		myInfoPage.enterToTextboxByIDHRM(driver, "membership_subscriptionAmount", memAmount);

		log.info("Membership_12 - Step 01: Select value to 'Currency' dropdown");
		myInfoPage.selectItemInDropdownByIDHRM(driver, "membership_currency", memCurrency);

		log.info("Membership_12 - Step 01: Enter value to 'Subscription Commence Date' Datepicker");
		myInfoPage.enterToTextboxByIDHRM(driver, "membership_subscriptionCommenceDate", memSubCommenceDate);

		log.info("Membership_12 - Step 01: Enter value to 'Subscription Renewal Date' Datepicker");
		myInfoPage.enterToTextboxByIDHRM(driver, "membership_subscriptionRenewalDate", memSubRenewalDate);

		log.info("Membership_12 - Step 01: Click to 'Save' button");
		myInfoPage.clickToButtonByIDHRM(driver, "btnSaveMembership");

		log.info("Membership_12 - Step 01: Verify Success message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Membership_12 - Step 01: Verify Membership information displayed at 'Membership' table");
		verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "", "Membership", "1"), memMembership);
		verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "", "Subscription Paid By", "1"), memSubPaidBy);
		verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "", "Subscription Amount", "1"), memAmount);
		verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "", "Currency", "1"), "USD");
		verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "", "Subscription Commence Date", "1"), memSubCommenceDate);
		verifyEquals(employeeListPage.getValueInTableAtRowIndexAndColumnName(driver, "", "Subscription Renewal Date", "1"), memSubRenewalDate);

	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition - Close browser" + browserName);
	//	cleanBrowserAndDriver();
	}

	AddEmployeePageObject addEmployeePage;
	DashboardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	LoginPageObject loginPage;
	MyInfoPageObject myInfoPage;
}