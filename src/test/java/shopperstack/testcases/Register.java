package shopperstack.testcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
import shopperstack.base.Base;

import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.RegisterPage;
import shopperstack.pageobjects.UserHomePage;

import static org.testng.Assert.assertTrue;




public class Register extends Base {

    public Register()  {
    	super();
    
    }
   
    public WebDriver driver;
	RegisterPage registerPage;
    
    @BeforeMethod
    public void setup()    {
    	
    	driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    	HomePage homepage=new HomePage(driver);
    	 registerPage = homepage.navigateToRegisterPage();
    	 }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    	
    }
    
    private void assertErrorDisplayed(String expectedErrorMessage) {
        assertTrue(registerPage.isErrorDisplayed(expectedErrorMessage), "Expected error message: " + expectedErrorMessage);
    }

     @Test(priority=1)
    public void verifyRegisteringAnAccountWithMandatoryFields()  {
    	 
    	
    	 String firstName = dataProp.getProperty("firstName");
         String lastName = dataProp.getProperty("lastName");
         String email = dataProp.getProperty("email");
         String password = dataProp.getProperty("password");
         String confirmPassword = dataProp.getProperty("password");
         String phone = dataProp.getProperty("phoneNumber");
    	
         registerPage.register(firstName, lastName, email, password, confirmPassword, phone);

     }
     
 /*    
    @Test(priority=2)
    public void verifyRegisteringAccountWithExistingEmailAdress() {
    	
    	
   String firstName = dataProp.getProperty("firstName");
   String lastName = dataProp.getProperty("lastName");

   String email="sunitamath.math@gmail.com";
   String password = dataProp.getProperty("password");
   String confirmPassword = dataProp.getProperty("password");
   String phone = dataProp.getProperty("password");
   //assertErrorDisplayed("Email id is already used");
   registerPage.register(firstName, lastName, email, password, confirmPassword, phone);
   
 String actualWarning=registerPage.retrieveDuplicateEmailAdressWarning();
   Assert.assertTrue(actualWarning.contains(dataProp.getProperty("Warning:Email ID or phone number already used")),"Warning message regarding duplicate email adress is not displayed"); 
        

 /*  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
  
  boolean Error = driver.getPageSource().contains("Given Email ID or Phone number already used");
   if (Error == true)
   {
    System.out.print(" Given Email ID or Phone number already used  - Error msg is displayed");
    Assert.assertTrue(true, "Error message is not displayed as expected");
   }
   else
   {
    System.out.print(" Error msg is not dispalyed");
    Assert.fail("Error message is not displayed");
   }*/


    
    
   @Test(priority=2) 
 public void verifypasswordMisMatchs() throws Exception {
    	
    	
	 String firstName = dataProp.getProperty("firstName");
     String lastName = dataProp.getProperty("lastName");
     String email = dataProp.getProperty("email");
     String password = dataProp.getProperty("password");
     String confirmPassword = "MisMatchPassword";
    String phone = dataProp.getProperty("password");
     Thread.sleep(5000);
     registerPage.registerFieldValidation(firstName, lastName, email, password, confirmPassword, phone);
     assertErrorDisplayed("password does not match");

    }
   
    
    }


	

	
	

	
		 
    	 
 




