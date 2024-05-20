package genricUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ShopperLoginPage;

public class InitObjects implements FrameworkConstants {

    public static WebDriver static_driver_ref;
    public WebDriver driver;
    public InitObjects initClass;
    public ReadTestData readData;
    public WebDriverWait explicitWait;
    public ShopperLoginPage loginPage;
    public HomePage homePage;
    public String url;
    public String emailId;
    public String password;

    public Actions getActionsUtil(WebDriver driver) {
        return new Actions(driver);
    }

    public ReadTestData getReadTestData() {
        return new ReadTestData();
    }
    

    public Utilities getUtilityMethods() {
        return new Utilities();
    }
}
