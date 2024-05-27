package shopperstack.LoginTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ShopperLoginPage;

public class LoginwithValidCredential extends Base {

	
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
	}


