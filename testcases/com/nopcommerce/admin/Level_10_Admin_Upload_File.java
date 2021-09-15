package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.DashboardPO;
import pageObjects.admin.nopCommerce.LoginPO;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductDetailPO;
import pageObjects.admin.nopCommerce.ProductSearchPO;

public class Level_10_Admin_Upload_File extends BaseTest {
	WebDriver driver;
	String uploadedProductImg = "Avatar.jpg";
	String uploadedProductAvatarAlt = "New image alt";
	String productAvatarOrder = "1";
	String uploadedProductAvatarTitle = "New image title";
	String productName = "Nikon D5500 DSLR - Red";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void productImgName(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToEmailPassword("admin");
		dashboardPage = loginPage.clickToLoginButton();
		dashboardPage.openSubMenuPageByName(driver, "Catalog", "Products");
		productSearchPage = PageGeneratorManager.getProductSearchPage(driver);
		productSearchPage.clickToExpandSearchCard();
		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();
		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);

	}

	@Test
	public void Admin_01_Upload_File() {
		productDetailPage.clickToExpandPanelByName("Pictures");
		productDetailPage.uploadFileByCardName(driver, "pictures", uploadedProductImg);
		Assert.assertTrue(productDetailPage.isPictureUploadedSuccessByFileName(uploadedProductImg));

		productDetailPage.enterToAltTextbox(uploadedProductAvatarAlt);
		productDetailPage.enterToTitleTextbox(uploadedProductAvatarTitle);
		productDetailPage.clickToUpDownInDisplayOrderTextbox("Increase");
		productDetailPage.clickToAddProductPictureButton();
		Assert.assertTrue(
				productDetailPage.isPictureImageDisplayed(productName, productAvatarOrder, uploadedProductAvatarAlt, uploadedProductAvatarTitle));

		productSearchPage = productDetailPage.clickToSaveButton();
		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));

		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();

		Assert.assertTrue(productSearchPage.isPictureUpdatedSuccess(productName, productName));
		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
		productDetailPage.clickToExpandPanelByName("Pictures");
		productDetailPage.clickToDeleteButtoAtPictureName(uploadedProductAvatarTitle);
		Assert.assertTrue(productDetailPage.isMesssageDisplayedInEmptyTable(driver, "productpictures"));
		productSearchPage = productDetailPage.clickToSaveButton();
		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureDeleteSuccess(productName,"default-image"));
	}

	public void cleanBrowser() {
		driver.quit();
	}

	LoginPO loginPage;
	DashboardPO dashboardPage;
	ProductSearchPO productSearchPage;
	ProductDetailPO productDetailPage;
}