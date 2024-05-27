package shopperstack.LoginTest;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
//import genricUtilities.Utilities.AssertionUtils;
import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ShopperLoginPage;

public class Login extends Base {
    private ShopperLoginPage shopperLoginPage;
    private HomePage homePage;

    public Login() {
        super();
    }

    @Test( dataProvider = "validCredentialsSupplier")
    public void verifyLoginWithValidCredentials(String email, String password) {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        homePage = shopperLoginPage.shopperLogin(email, password);
        Assert.assertTrue(homePage.getDisplayStatusOfhomePageInformationOption(), "Login was not successful with valid credentials");
    }

    @DataProvider(name = "validCredentialsSupplier")
    public Object[][] supplyTestData() {
        return ReadTestData.getTestDataFromExcel("Login");
    }

    @Test
    public void verifyLoginWithValidEmailAndInvalidPassword() {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.shopperLogin(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Given user ID or password is wrong");
    }

    @Test
    public void verifyLoginWithInvalidEmailAndValidPassword() {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.shopperLogin(ReadTestData.generateEmailWithTimeStamp(), dataProp.getProperty("validPassword"));
        //assertErrorMessageDisplayed("Given user ID or password is wrong");
        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Given user ID or password is wrong");

    }

    @Test
    public void verifyLoginWithInvalidEmailandPassword() {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.shopperLogin(ReadTestData.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Given user ID or password is wrong");
    }

    @Test
    public void verifyLoginWithoutProvidingCredentials() {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.clickOnLoginButton();
        
        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Please enter your username and password");
       
    }

	
}
