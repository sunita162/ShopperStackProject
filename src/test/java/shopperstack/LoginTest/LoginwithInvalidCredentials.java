package shopperstack.LoginTest;

import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;

public class LoginwithInvalidCredentials extends Base {

	 @Test
	    public void verifyLoginWithInvalidEmailandPassword() {
	        homePage = new HomePage(driver);
	        shopperLoginPage = homePage.clickOnLoginButton();
	        shopperLoginPage.shopperLogin(ReadTestData.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
	        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Given user ID or password is wrong");
	    }

	}


