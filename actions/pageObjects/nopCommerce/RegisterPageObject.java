package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify the successful messsage is displayed")
	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	@Step("Enter to First Name textbox with value {0}")
	public void enterToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
	}

	@Step("Enter to Last Name textbox with value {0}")
	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	@Step("Enter to Email textbox with value {0}")
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Enter to Password textbox with value {0}")
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to Confirm password textbox with value {0}")
	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassword);
	}

	@Step("Click to Male Gender RadioButton")
	public void clickToMaleGenderRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	@Step("Click on Register Button")
	public void clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Enter to logout link")
	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		if (driver.toString().contains("chrome")) {
			sleepInSecond(3);
		}
		return PageGeneratorManager.getHomePage(driver);
	}

}
