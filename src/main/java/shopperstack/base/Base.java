package shopperstack.base;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/***
 * This class  for browserSetup, loginToApplication, logoutOfApplication and browserTearDown
 */
public class Base {
    WebDriver driver;
    public Properties prop;// Properties object to hold configuration properties
    public Properties dataProp;// Properties object to hold test data properties

 // Constructor to initialize property files
    public  Base() {
        prop = new Properties();
     // Path to the configuration properties file
        File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\PropertyFile\\config.properties");
        dataProp = new Properties();
     // Path to the test data properties file
        File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\testdata.properties");
        // Load test data properties
        try {
        FileInputStream dataFis = new FileInputStream(dataPropFile);
        dataProp.load(dataFis);
        }catch(Throwable e) {
        	e.printStackTrace();
        }
        // Load configuration properties
        try {
        FileInputStream fis = new FileInputStream(propFile);
        prop.load(fis);
        }catch(Throwable e) {
        	e.printStackTrace();
        }
        }
    
 // Method to initialize browser and open application URL
      public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
    	// Check if the browser name is Chrome
        if (browserName.equalsIgnoreCase("chrome")) {
        	// Set the path for the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
         // Check if the browser name is Firefox
        } else if (browserName.equalsIgnoreCase("firefox")) {
        	// Set the path for the GeckoDriver executable
            System.setProperty("webdriver.gecko.driver", "/ShopperStack1_Framework/Driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
