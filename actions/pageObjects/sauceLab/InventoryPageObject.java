package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectDropdownByText(driver, InventoryPageUI.SORT_DROPDOWN, itemText);
	}

	public boolean isProductNameSortAscending() {
		List<WebElement> productNameElement = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();

		for (WebElement productName : productNameElement) {
			productNameText.add(productName.getText());
		}

		System.out.println("Before sort asc-----------");
		for (String product : productNameText) {
			System.out.println(product);
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		
		System.out.println("After sort asc-----------");
		for (String product : productNameTextClone) {
			System.out.println(product);
		}
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElement = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElement) {
			productNameText.add(productName.getText());
		}
		
		System.out.println("Before sort desc-----------");
		for (String product : productNameText) {
			System.out.println(product);
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		
		System.out.println("After sort desc-----------");
		for (String product : productNameTextClone) {
			System.out.println(product);
		}
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductPriceSortAscending() {
		List<WebElement> productPriceElement = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		List<Float> productPriceNumber = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElement) {
			productPriceNumber.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		System.out.println("Before sort Asc-----------");
		for (Float product : productPriceNumber) {
			System.out.println(product);
		}
		
		List<Float> productPriceNumberClone = new ArrayList<Float>(productPriceNumber);
		Collections.sort(productPriceNumberClone);
		
		System.out.println("After sort Asc-----------");
		for (Float product : productPriceNumberClone) {
			System.out.println(product);
		}
		return productPriceNumber.equals(productPriceNumberClone);
	}

	public boolean isProductPriceSortDescending() {
		List<WebElement> productPriceElement = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		List<Float> productPriceNumber = new ArrayList<Float>();
		for (WebElement productPrice : productPriceElement) {
			productPriceNumber.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		System.out.println("Before sort Desc-----------");
		for (Float product : productPriceNumber) {
			System.out.println(product);
		}
		
		List<Float> productPriceNumberClone = new ArrayList<Float>(productPriceNumber);
		Collections.sort(productPriceNumberClone);
		Collections.reverse(productPriceNumberClone);
		
		System.out.println("After sort Desc-----------");
		for (Float product : productPriceNumberClone) {
			System.out.println(product);
		}
		return productPriceNumber.equals(productPriceNumberClone);
	}
}
