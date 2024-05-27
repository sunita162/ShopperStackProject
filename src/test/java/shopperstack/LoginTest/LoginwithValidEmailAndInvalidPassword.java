package shopperstack.LoginTest;

import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;

public class LoginwithValidEmailAndInvalidPassword extends Base {

	@Test
    public void verifyLoginWithValidEmailAndInvalidPassword() {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.shopperLogin(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Given user ID or password is wrong");
    }
	}


