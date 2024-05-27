package shopperstack.RegisterTest;

import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.RegisterPage;

public class RegisterpasswordMisMatchs extends Base {
	 private RegisterPage registerPage;
	  @Test
	    public void verifypasswordMisMatchs()  {
	        HomePage homePage = new HomePage(driver);
	        registerPage = homePage.navigateToRegisterPage();
	        String firstName = dataProp.getProperty("firstName");
	        String lastName = dataProp.getProperty("lastName");
	        String email = dataProp.getProperty("email");
	        String password = dataProp.getProperty("password");
	        String confirmPassword = "MisMatchPassword";
	        String phone = dataProp.getProperty("phoneNumber");
	        registerPage.registerFieldValidation(firstName, lastName, email, password, confirmPassword, phone);
	       
	    }
	}


