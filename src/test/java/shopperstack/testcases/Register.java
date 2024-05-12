package shopperstack.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.RegisterPage;
import shopperstack.utility.Utilities;

public class Register extends Base {
   
    public Register() throws IOException {
    	super();
    
    }
   
    public WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException   {
    	driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    	HomePage homepage=new HomePage(driver);
    	homepage.clickOnLoginButton();
    	homepage.clickOnCreateAccount();
    	 }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    	
    }

     @Test(priority=1)
    public void verifyRegisteringAnAccountWithMandatoryFields()  {
    	 
    	 RegisterPage registerPage=new RegisterPage(driver);
    	 registerPage.enterFirstName(dataProp.getProperty("firstName"));
    	 registerPage.enterLastName(dataProp.getProperty("lastName"));
    	 registerPage.clickOnGenderFamale();
        registerPage.enterPhoneNumber(dataProp.getProperty("phoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.enterEmailAdress(Utilities.generateEmailWithTimeStamp());
        registerPage.clickOnTermsAndConditions();
        registerPage.clickOnRegister();
          }
     
     @Test(priority=2)
    public void verifyRegisteringAccountWithExistingEmailAdress() {
    	System.out.println("verifyRegisteringAccountWithExistingEmailAdress");
    }
     @Test
     public void verifyRegisteringAccountWithoutFillingAnyDetails(){
     	System.out.println("verifyRegisteringAccountWithExistingEmailAdress");
    }
}

