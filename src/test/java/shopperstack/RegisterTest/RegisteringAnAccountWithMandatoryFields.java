package shopperstack.RegisterTest;

import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.RegisterPage;

public class RegisteringAnAccountWithMandatoryFields extends Base {

	  private RegisterPage registerPage;
    @Test
    public void verifyRegisteringAnAccountWithMandatoryFields() {
        HomePage homePage = new HomePage(driver);
        registerPage = homePage.navigateToRegisterPage();
        String firstName = dataProp.getProperty("firstName");
        String lastName = dataProp.getProperty("lastName");
        String email = dataProp.getProperty("email");
        String password = dataProp.getProperty("password");
        String confirmPassword = dataProp.getProperty("password");
        String phone = dataProp.getProperty("phoneNumber");
        registerPage.register(firstName, lastName, email, password, confirmPassword, phone);
    }


}
