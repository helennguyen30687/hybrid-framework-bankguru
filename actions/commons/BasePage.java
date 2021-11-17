package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.hrm.DashboardPageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGenerator;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.SearchPageObject;
import pageUI.admin.nopCommerce.AdminBasePageUI;
import pageUIs.hrm.BasePageUI;
import pageUIs.hrm.MyInfoPageUI;
import pageUIs.nopCommerce.RegisterPageUI;
import pageUIs.nopCommerce.UserBasePageUI;

/**
 * @author thanh
 *
 */
public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}

	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}

	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	// Dung ID chi co 2 window
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println(allWindowID);
		for (String windowID : allWindowID) {
			if (!windowID.equalsIgnoreCase(parentID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	// Dung title khi tu 3 window tro len
	public void switchToTWindowByTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		System.out.println("The total amount of windows are openning: " + allWindowIDs.size());
		for (String windowID : allWindowIDs) {
			driver.switchTo().window(windowID);
			String windowTitle = driver.getTitle();
			if (windowTitle.equals(expectedWindowTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowExceptParent(WebDriver driver, String parentID) {
		Set<String> allWindowID = driver.getWindowHandles();

		for (String windowID : allWindowID) {
			if (!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				driver.close();
			}

		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int getElementSize(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		return getElements(driver, locator).size();
	}

	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public void selectDropdownByText(WebDriver driver, String locator, String itemText, String... params) {
		locator = getDynamicLocator(locator, params);
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemDropdown(WebDriver driver, String locator, String... params) {
		select = new Select(getElement(driver, getDynamicLocator(locator, params)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, shortTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			// 1.in UI + In DOM
			// 2.Not in UI + In DOM
			return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			// 3. Not in UI + Not in DOM
			e.printStackTrace();
			return false;
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		System.out.println("Start time = " + new Date().toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, locator);
		overrideGlobalTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("In DOM and Invisible in UI");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("In DOM and Invisible in UI");
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isEnabled();
	}

	public WebDriver switchToIFrameToElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver switchToDefaultContent(WebDriver driver, String locator) {
		return driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	} // action phai dung perform

	public void hoverToElement(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String locator, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		locator = getDynamicLocator(locator, params);
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean isJQueryAndAjaxLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	// User - Nopcommerce
	public OrderPageObject openOrderPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUI.ORDER_PAGE_FOOTER);
		clickToElement(driver, UserBasePageUI.ORDER_PAGE_FOOTER);
		return PageGeneratorManager.getOrderPage(driver);
	}

	public SearchPageObject openSearchPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUI.SEARCH_PAGE_FOOTER);
		clickToElement(driver, UserBasePageUI.SEARCH_PAGE_FOOTER);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUI.MY_ACCOUNT_PAGE_FOOTER);
		clickToElement(driver, UserBasePageUI.MY_ACCOUNT_PAGE_FOOTER);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public BasePage getFooterPageByName(WebDriver driver, String pageName) {
		scrollToBottomPage(driver);
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getSearchPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrderPage(driver);
		case "My account":
			return PageGeneratorManager.getMyAccountPage(driver);
		}
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
	}

	// Admin - NopCommerce
	public void openSubMenuPageByName(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);
		clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);

		waitForElementClickable(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
		clickToElement(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
	}

	public void uploadFileByCardName(WebDriver driver, String cardName, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardName).sendKeys(fullFileName);
	}

	public boolean isMesssageDisplayedInEmptyTable(WebDriver driver, String tableName) {
		waitForAllElementVisible(driver, AdminBasePageUI.NO_DATA_MESSAGE_BY_TABLE_NAME, tableName);
		return isElementDisplayed(driver, AdminBasePageUI.NO_DATA_MESSAGE_BY_TABLE_NAME, tableName);
	}

	public void openHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_HEADER, pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_HEADER, pageName);
	}

	public void enterToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public void clickToRadioButtonByText(WebDriver driver, String radioButtonText) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_RADIO_BY_TEXT, radioButtonText);
		clickToElement(driver, UserBasePageUI.DYNAMIC_RADIO_BY_TEXT, radioButtonText);
	}

	public void clickToDropDownByName(WebDriver driver, String dropdownName, String itemText) {
		selectDropdownByText(driver, UserBasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemText, dropdownName);
	}

	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	// HRM-Menu
	public void openMenuPageHRM(WebDriver driver, String menuPageName) {
		waitForElementClickable(driver, BasePageUI.MENU_BY_PAGE_NAME, menuPageName);
		clickToElement(driver, BasePageUI.MENU_BY_PAGE_NAME, menuPageName);
		isJQueryAndAjaxLoadedSuccess(driver);
	}

	// Sub- Menu
	public void openSubMenuPageHRM(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementClickable(driver, BasePageUI.MENU_BY_PAGE_NAME, menuPageName);
		clickToElement(driver, BasePageUI.MENU_BY_PAGE_NAME, menuPageName);

		waitForElementClickable(driver, BasePageUI.MENU_BY_PAGE_NAME, subMenuPageName);
		clickToElement(driver, BasePageUI.MENU_BY_PAGE_NAME, subMenuPageName);

		isJQueryAndAjaxLoadedSuccess(driver);
	}

	// Child-Submenu
	public void openChildSubMenuPageHRM(WebDriver driver, String menuPageName, String subMenuPageName, String childSubMenuPageName) {
		waitForElementClickable(driver, BasePageUI.MENU_BY_PAGE_NAME, menuPageName);
		clickToElement(driver, BasePageUI.MENU_BY_PAGE_NAME, menuPageName);

		waitForElementInvisible(driver, BasePageUI.MENU_BY_PAGE_NAME, subMenuPageName);
		hoverToElement(driver, BasePageUI.MENU_BY_PAGE_NAME, subMenuPageName);

		waitForElementClickable(driver, BasePageUI.MENU_BY_PAGE_NAME, childSubMenuPageName);
		clickToElement(driver, BasePageUI.MENU_BY_PAGE_NAME, childSubMenuPageName);

		isJQueryAndAjaxLoadedSuccess(driver);
	}

	public void clickToButtonByIDHRM(WebDriver driver, String buttonIDName) {
		waitForElementClickable(driver, BasePageUI.BUTTON_BY_ID, buttonIDName);
		clickToElement(driver, BasePageUI.BUTTON_BY_ID, buttonIDName);
	}

	public void enterToTextboxByIDHRM(WebDriver driver, String textboxIDName, String value) {
		waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxIDName);
		sendkeyToElement(driver, BasePageUI.TEXTBOX_BY_ID, value, textboxIDName);
	}

	/**
	 * Get textbox value by textbox ID
	 * 
	 * @author thanh
	 * @param driver
	 * @param textboxIDName
	 * @return attribute value
	 */
	public String getTextboxValueByIDHRM(WebDriver driver, String textboxIDName) {
		waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxIDName);
		return getElementAttributeValue(driver, BasePageUI.TEXTBOX_BY_ID, "value", textboxIDName);
	}

	/**
	 * Select item text in dropdownlist by DropdownID
	 * 
	 * @author thanh
	 * @param driver
	 * @param dropdownID
	 * @param valueItem
	 */
	public void selectItemInDropdownByIDHRM(WebDriver driver, String dropdownID, String valueItem) {
		waitForElementClickable(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
		selectDropdownByText(driver, BasePageUI.DROPDOWN_BY_ID, valueItem, dropdownID);
	}

	/**
	 * Get value in dropdownlist
	 * 
	 * @author thanh
	 * @param driver
	 * @param dropdownID
	 * @return selected text in dropdownlist
	 */
	public String getSelectedValueInDropDownByIDHRM(WebDriver driver, String dropdownID) {
		waitForElementVisible(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemDropdown(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
	}

	/**
	 * Click to checkbox by Label text
	 * 
	 * @author thanh
	 * @param driver
	 * @param checkboxLabelName
	 */
	public void clickToCheckboxByLabelHRM(WebDriver driver, String checkboxLabelName) {
		waitForElementClickable(driver, BasePageUI.CHECKBOX_BY_LABEL, checkboxLabelName);
		checkToCheckboxOrRadio(driver, BasePageUI.CHECKBOX_BY_LABEL, checkboxLabelName);
	}

	/**
	 * Click to radio button by Label text
	 * 
	 * @author thanh
	 * @param driver
	 * @param radioLabelName
	 */
	public void clickToRadioByLabelHRM(WebDriver driver, String radioLabelName) {
		waitForElementClickable(driver, BasePageUI.RADIO_BY_LABEL, radioLabelName);
		checkToCheckboxOrRadio(driver, BasePageUI.RADIO_BY_LABEL, radioLabelName);
	}

	public boolean isRadioButtonSelectedByLabel(WebDriver driver, String radioLabelName) {
		waitForElementVisible(driver, BasePageUI.RADIO_BY_LABEL, radioLabelName);
		return isElementSelected(driver, BasePageUI.RADIO_BY_LABEL, radioLabelName);
	}

	public String getValueInTableAtRowIndexAndColumnName(WebDriver driver, String tableID, String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUI.TABLE_HEADER_BY_ID_AND_NAME, tableID, headerName) + 1;
		waitForAllElementVisible(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
	}

	public LoginPageObject logoutToSystem(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.WELCOME_USER_LINK);
		clickToElement(driver, BasePageUI.WELCOME_USER_LINK);

		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		return PageGenerator.getLoginPage(driver);
	}

	public DashboardPageObject loginToSystem(WebDriver driver, String userName, String password) {
		waitForAllElementVisible(driver, BasePageUI.USER_LOGIN_TEXTBOX);
		sendkeyToElement(driver, BasePageUI.USER_LOGIN_TEXTBOX, userName);
		sendkeyToElement(driver, BasePageUI.PASSWORD_LOGIN_TEXTBOX, password);
		clickToElement(driver, BasePageUI.LOGIN_BUTTON);

		return PageGenerator.getDashboardPage(driver);
	}

	public void uploadImage(WebDriver driver, String filePath) {
		getElement(driver, BasePageUI.UPLOAD_FILE).sendKeys(filePath);
	}

	public boolean isSuccessMessageDisplayed(WebDriver driver, String messageValue) {
		waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE_VALUE, messageValue);
		return isElementDisplayed(driver, BasePageUI.SUCCESS_MESSAGE_VALUE, messageValue);
	}

	public boolean isFieldEnabledByName(WebDriver driver, String fieldID) {
		waitForElementVisible(driver, BasePageUI.ANY_FIELD, fieldID);
		return isElementEnabled(driver, BasePageUI.ANY_FIELD, fieldID);
	}


	private Alert alert;
	private Select select;
	private Actions action;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
