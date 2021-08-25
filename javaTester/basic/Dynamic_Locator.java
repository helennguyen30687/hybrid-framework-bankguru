package basic;

public class Dynamic_Locator {
	public static void main(String[] args) {
		String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
		String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
		String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";

		String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
		String DYNAMIC_PAGE_SIDEBAR = "//div[@class='%s']//a[text()='%s']//a[@id='%s']";
		
		clickToElement(MY_ACCOUNT_PAGE_FOOTER);
		clickToElement(DYNAMIC_PAGE_FOOTER, "Search");
		clickToElement(DYNAMIC_PAGE_SIDEBAR, "Home Page","abc","xyz");
		
	}

	public static void clickToElement(String locator) {
		System.out.println(String.format(locator));
	}
	public static void clickToElement(String locator, String pageName) {
		System.out.println(String.format(locator, pageName));
	}
	public static void clickToElement(String locator,String firstParam, String secondParam, String thirdParam) {
		System.out.println(String.format(locator, firstParam, secondParam,thirdParam));
	}
}
