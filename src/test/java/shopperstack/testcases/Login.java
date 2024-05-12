package shopperstack.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ShopperLoginPage;
import shopperstack.utility.Utilities;

public class Login extends Base {

    public Login() throws IOException {
        super();
    }
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        
        homePage.clickOnLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, dataProvider = "validCredentialsSupplier")
    public void verifyLoginWithValidCredentials(String email, String password) {
       
    	ShopperLoginPage shopperLoginPage = new ShopperLoginPage(driver);
        shopperLoginPage.enterEmailId(email);
        shopperLoginPage.enterPassword(password);
        shopperLoginPage.clickOnLoginButton();
    }

    @DataProvider(name = "validCredentialsSupplier")
    public Object[][] supplyTestData() {
    	
    	Object[][] data=  Utilities.getTestDataFromExcel("Login");
    	return data;
    }

    
   @Test(priority = 2)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
	   ShopperLoginPage shopperLoginPage = new ShopperLoginPage(driver);
       shopperLoginPage.enterEmailId(dataProp.getProperty("validEmail"));
       shopperLoginPage.enterPassword(dataProp.getProperty("invalidPassword"));
       shopperLoginPage.clickOnLoginButton();
	   shopperLoginPage.enterPassword("Password");
	   }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
    	
    	ShopperLoginPage shopperLoginPage = new ShopperLoginPage(driver);
        shopperLoginPage.enterEmailId("Test123@gmail.com");
        shopperLoginPage.enterPassword(dataProp.getProperty("validPassword"));
        shopperLoginPage.clickOnLoginButton();

        
    }
}
