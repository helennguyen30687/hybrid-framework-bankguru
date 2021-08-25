package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementSize;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;



public class HomePageObject extends BasePage{
	 WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		 this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String HeaderName, String value) {
		waitForElementClickable(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, HeaderName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, HeaderName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER,HeaderName);
	}

	public void clickToIconByCountryName(String countryName, String iconActions) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName,iconActions);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName,iconActions);
	}

	public boolean isRowValueDisplayed(String female, String country, String males, String total) {
		waitForElementClickable(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female,country,males,total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female,country,males,total);
	}

	public void inputToTextboxRowNumber(String HeaderName, String rowIndex, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX,HeaderName)+1;
		waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX,rowIndex,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX,value,rowIndex,String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowIndex, String iconActions) {
		waitForElementClickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex,iconActions);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex,iconActions);
	}



	

}
