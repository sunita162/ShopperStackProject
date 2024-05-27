package shopperstack.LoginTest;

import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;

public class LoginwithInvalidEmailAndValidPassword extends Base{

	 
		// TODO Auto-generated method stub
		 @Test
		    public void verifyLoginWithInvalidEmailAndValidPassword() {
		        homePage = new HomePage(driver);
		        shopperLoginPage = homePage.clickOnLoginButton();
		        shopperLoginPage.shopperLogin(ReadTestData.generateEmailWithTimeStamp(), dataProp.getProperty("validPassword"));
		        //assertErrorMessageDisplayed("Given user ID or password is wrong");
		        genricUtilities.AssertionUtils.assertErrorMessageDisplayed(driver, "Given user ID or password is wrong");

		    }
	}


