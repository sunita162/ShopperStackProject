package shopperstack.LoginTest;

import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;

public class LoginWithoutProvidingCredentials extends Base {


    @Test
    public void verifyLoginWithoutProvidingCredentials() {
        homePage = new HomePage(driver);
        shopperLoginPage = homePage.clickOnLoginButton();
        shopperLoginPage.clickOnLoginButton();
        
        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Please enter your username and password");
       
    }


	}


