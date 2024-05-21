package shopperstack.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ShopperLoginPage;

/***
 * This class is for browser setup, login to application, logout of application, and browser teardown.
 */
public class Base {
    protected WebDriver driver;  // Make driver protected to allow access in subclasses
    public Properties prop;      // Properties object to hold configuration properties
    public Properties dataProp;  // Properties object to hold test data properties
    protected ShopperLoginPage shopperLoginPage;
    protected HomePage homePage;
    
    // Constructor to initialize property files
    public Base() {
        prop = new Properties();
        // Path to the configuration properties file
        File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\PropertyFile\\config.properties");
        dataProp = new Properties();
        // Path to the test data properties file
        File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\testdata.properties");
        // Load test data properties
        try (FileInputStream dataFis = new FileInputStream(dataPropFile)) {
            dataProp.load(dataFis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Load configuration properties
        try (FileInputStream fis = new FileInputStream(propFile)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to initialize browser and open application URL
    
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = initializeBrowserAndOpenApplicationURL();
        //login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
    }
    
     protected WebDriver initializeBrowserAndOpenApplicationURL() {
        String browserName = prop.getProperty("browser");
        if (browserName == null) {
            throw new RuntimeException("Browser name is not specified in the configuration file.");
        }
        // Check if the browser name is Chrome
        if (browserName.equalsIgnoreCase("chrome")) {
            // Set the path for the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            Reporter.log("Successfully Launched Chrome Browser", true);
        // Check if the browser name is Firefox
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Set the path for the GeckoDriver executable
            System.setProperty("webdriver.gecko.driver", "/ShopperStack1_Framework/Driver/geckodriver.exe");
            driver = new FirefoxDriver();
            Reporter.log("Successfully Launched Firefox Browser", true);
        } else {
            throw new RuntimeException("Invalid browser name specified in the configuration file: " + browserName);
        }
        driver.manage().window().maximize();
        Reporter.log("Browser window is maximized successfully", true);
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
        
    }
    public void login(String email, String password)  {
        homePage = new HomePage(driver);
    	ShopperLoginPage shopperLoginPage = new ShopperLoginPage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.enterEmailId(email);
        shopperLoginPage.enterPassword(password);
        shopperLoginPage.clickOnLoginButton();
        Reporter.log("login Successfull", true);
    }  
    
     // Method to run after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
