package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	@FindBy(id = "gender-male")
	WebElement genderRadio;

	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	WebElement lastNameTextbox;

	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void enterToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstname);
	}

	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastname);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToMaleGenderRadioButton() {
		waitForElementClickable(driver, genderRadio);
		clickToElement(driver, genderRadio);
	}

	public void clickOnRegisterButton() {
		waitForElementClickable(driver,registerButton);
		clickToElement(driver, registerButton);
	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver,logoutLink);
		clickToElement(driver, logoutLink);
	}

}
