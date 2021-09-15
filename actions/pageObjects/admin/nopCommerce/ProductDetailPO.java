package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.admin.nopCommerce.ProductDetailUI;
import pageUIs.nopCommerce.LoginPageUI;

public class ProductDetailPO extends BasePage {

	private WebDriver driver;

	public ProductDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailUI.TOGGLE_BY_CARD_NAME, panelName);
		String ToggleIconStatus = getElementAttributeValue(driver, ProductDetailUI.TOGGLE_BY_CARD_NAME, "class", panelName);
		if (ToggleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, ProductDetailUI.TOGGLE_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailUI.TOGGLE_BY_CARD_NAME, panelName);
		}

	}

	public boolean isPictureUploadedSuccessByFileName(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailUI.PRODUCT_PICTURE_ADD_NEW_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, ProductDetailUI.PRODUCT_PICTURE_ADD_NEW_BY_FILE_NAME, fileName);
	}

	public void enterToAltTextbox(String productImageAlt) {
		waitForAllElementVisible(driver, ProductDetailUI.ALT_TEXTBOX_ADD_NEW);
		sendkeyToElement(driver, ProductDetailUI.ALT_TEXTBOX_ADD_NEW, productImageAlt);
	}

	public void enterToTitleTextbox(String productImageTitle) {
		waitForAllElementVisible(driver, ProductDetailUI.TITLE_TEXTBOX_ADD_NEW);
		sendkeyToElement(driver, ProductDetailUI.TITLE_TEXTBOX_ADD_NEW, productImageTitle);

	}

	public void clickToUpDownInDisplayOrderTextbox(String statusValue) {
		waitForElementClickable(driver, ProductDetailUI.DISPLAY_ORDER_TEXTBOX_UP_DOWN, statusValue);
		clickToElement(driver, ProductDetailUI.DISPLAY_ORDER_TEXTBOX_UP_DOWN, statusValue);

	}

	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, ProductDetailUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureImageDisplayed(String imageName, String imageOrder, String imageAlt, String imageTitle) {
		imageName = imageName.replaceAll("\\s+", "-");
		imageName = imageName.replaceAll("-+", "-").toLowerCase();
		waitForAllElementVisible(driver, ProductDetailUI.PICTURE_IN_TABLE_ALT_TITLE_ORDER_BY_NAME, imageName, imageOrder, imageAlt, imageTitle);
		return isElementDisplayed(driver, ProductDetailUI.PICTURE_IN_TABLE_ALT_TITLE_ORDER_BY_NAME, imageName, imageOrder, imageAlt, imageTitle);
	}

	public ProductSearchPO clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailUI.SAVE_BUTTON);
		sleepInSecond(2);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteButtoAtPictureName(String productTitle) {
		waitForElementClickable(driver, ProductDetailUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(driver, ProductDetailUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		sleepInSecond(2);
		acceptAlert(driver);
	}

}
