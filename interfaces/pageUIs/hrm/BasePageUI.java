package pageUIs.hrm;

public class BasePageUI {
	public static final String MENU_BY_PAGE_NAME = "//div[@id='mainMenu']//a[string()='%s']";
	public static final String BUTTON_BY_ID = "//input[@id='%s']";
	public static final String TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String CHECKBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input";
	public static final String RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
	public static final String TABLE_HEADER_BY_ID_AND_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//table[@id='%s']/tbody/tr[%s]/td[%s]";
	public static final String SUCCESS_MESSAGE_VALUE = "//div[@class='inner']/div[contains(text(),'%s')]";
	public static final String ANY_FIELD = "//*[@id='%s']";
	
	public static final String WELCOME_USER_LINK = "//a[@id='welcome']";
	public static final String LOGOUT_LINK = "//div[@id='welcome-menu']//a[text()='Logout']";
	public static final String USER_LOGIN_TEXTBOX = "//input[@id='txtUsername']";
	public static final String PASSWORD_LOGIN_TEXTBOX = "//input[@id='txtPassword']";
	public static final String LOGIN_BUTTON= "//input[@id='btnLogin']";
	public static final String UPLOAD_FILE= "//input[@type='file']";
	public static final String SAVE_BUTTON= "//input[@id='btnSave']";
}
