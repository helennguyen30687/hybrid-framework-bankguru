package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.ProductDetailUI;
import pageUI.admin.nopCommerce.ProductSearchUI;
import pageUIs.nopCommerce.LoginPageUI;

public class ProductSearchPO extends BasePage {

	private WebDriver driver;

	public ProductSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductSearchUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchUI.SEARCH_BUTTON);
		sleepInSecond(2);
	}

	public boolean isSuccessMessageDisplayed(String successSaveMessage) {
		waitForElementVisible(driver, ProductSearchUI.SUCCESS_MESSAGE, successSaveMessage);
		sleepInSecond(2);
		return isElementDisplayed(driver, ProductSearchUI.SUCCESS_MESSAGE, successSaveMessage);
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductSearchUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductSearchUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public ProductDetailPO clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, ProductSearchUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		sleepInSecond(2);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isPictureUpdatedSuccess(String productName, String productImgName) {
		productImgName = productName.replaceAll("\\s+", "-");
		productImgName = productImgName.replaceAll("-+", "-").toLowerCase();
		waitForElementVisible(driver, ProductSearchUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, productImgName);
		return isElementDisplayed(driver, ProductSearchUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, productImgName);
	}

	public void clickToExpandSearchCard() {
		waitForElementVisible(driver, ProductSearchUI.SEARCH_PRODUCT_CARD_PANEL);
		String CardIconStatus = getElementAttributeValue(driver, ProductSearchUI.SEARCH_PRODUCT_CARD_PANEL, "class");
		if (CardIconStatus.contains("fa-angle-up")) {
			waitForElementClickable(driver, ProductSearchUI.SEARCH_PRODUCT_CARD_PANEL);
			clickToElement(driver, ProductSearchUI.SEARCH_PRODUCT_CARD_PANEL);
		}
	}

	public boolean isPictureDeleteSuccess(String productName, String defautImageName) {
		sleepInSecond(2);
		waitForElementVisible(driver, ProductSearchUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, defautImageName);
		return isElementDisplayed(driver, ProductSearchUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, defautImageName);
	}

}
