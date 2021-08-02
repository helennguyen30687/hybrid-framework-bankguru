package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
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

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
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

	/* Element */
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendkeyToElement(WebDriver driver,WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplayed(WebDriver driver,WebElement element) {
		return element.isDisplayed();
	}
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private Alert alert;
	private long timeout = 30;
	private WebDriverWait explicitWait;
}
