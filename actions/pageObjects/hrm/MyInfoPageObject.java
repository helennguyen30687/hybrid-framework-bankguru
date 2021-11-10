package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.MyInfoPageUI;

public class MyInfoPageObject extends BasePage {
	private WebDriver driver;

	public MyInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangeAvatarImag() {
		waitForElementClickable(driver, MyInfoPageUI.AVATAR_IMAGE);
		clickToElement(driver, MyInfoPageUI.AVATAR_IMAGE);
	}

	public boolean isNewAvatarImageDisplayed() {
		waitForElementVisible(driver, MyInfoPageUI.AVATAR_IMAGE);
		int imageWidth =  Integer.parseInt(getElementAttributeValue(driver, MyInfoPageUI.AVATAR_IMAGE, "width"));
		int imageHeight =  Integer.parseInt(getElementAttributeValue(driver, MyInfoPageUI.AVATAR_IMAGE, "height"));
		return (imageHeight!=200)|| (imageWidth!=200);
	}
	
	public void openTabAtSideBarByName(String tabName) {
		waitForElementClickable(driver, MyInfoPageUI.TAB_LINK_AT_SIDEBAR,tabName);
		clickToElement(driver, MyInfoPageUI.TAB_LINK_AT_SIDEBAR,tabName);
	}
}
