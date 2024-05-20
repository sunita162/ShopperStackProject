package genricUtilities;

public interface FrameworkConstants {
	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_PATH = "./src/main/resources/Drivers/chromedriver.exe";

	String FIREFOX_KEY = "webdriver.gecko.driver";
	String FIREFOX_PATH = "./src/main/resources/Drivers/geckodriver.exe";

	String EXCEL_PATH = "./src/test/resources/TestData/ShoppersStackTestData1.xlsx";
	String PROPERTYFILE_PATH = "./src/test/resources/PropertyFile/config.properties";
	String SCREENSHOT_PATH = "./errorShots/";
	
	int PAGE_LOAD_TIMEOUT = 10;
	int IMPLICIT_TIMEOUT = 10;
	int EXPLICIT_TIMEOUT = 10;

}

