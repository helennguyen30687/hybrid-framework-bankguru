package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;


public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		 this.driver = driver;
	}
	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public void enterToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX,firstname);
	}


	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX,lastname);		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,email);		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX,password);		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX,confirmPassword);	
	}
	public void clickToMaleGenderRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver,RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);		
	}

	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver,RegisterPageUI.LOGOUT_LINK);	
		return PageGeneratorManager.getHomePage(driver);
	}

}
