package shopperstack.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    protected WebDriver driver;
    protected Properties prop;
    protected Properties dataProp;

    public Base() throws IOException {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "/src/main/java/ShoppersStack/config/config.properties");
        FileInputStream fis = new FileInputStream(propFile);
        prop.load(fis);

        dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir") + "/src/main/java/ShopperStack/testdata/testdata.properties");
        FileInputStream dataFis = new FileInputStream(dataPropFile);
        dataProp.load(dataFis);
    }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/ShopperStack1_Framework/Driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
