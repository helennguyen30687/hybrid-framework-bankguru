package pageFactory.nopCommerce;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.BasePageFactory;


public class HomePageObject extends BasePageFactory{
	 WebDriver driver;
	
	 @FindBy(id="nivo-slider")
	 WebElement homePageSlider;
	 
	 @FindBy(xpath="//a[@class='ico-register']")
	 WebElement registerLink;
	 
	 @FindBy(xpath="//a[@class='ico-login']")
	 WebElement loginLink;
	 
	public HomePageObject(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	
	

}
