package shopperstack.testcases;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ShopperLoginPage;


public class Login extends Base {
	ShopperLoginPage shopperLoginPage;
    
	public Login()  {
        super();
    }
     WebDriver driver;
    

    @BeforeMethod
    public void setUp() {
    	driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    	HomePage homePage = new HomePage(driver);
    	shopperLoginPage =homePage.clickOnLoginButton();
        
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1,dataProvider = "validCredentialsSupplier")
    public void verifyLoginWithValidCredentials (String email, String password)
    {
    	 HomePage homePage = shopperLoginPage.shopperLogin(email, password);
        Assert.assertTrue(homePage.getDisplayStatusOfhomePageInformationOption());
    }  
   
    @DataProvider(name = "validCredentialsSupplier")
    public Object[][] supplyTestData() {
    	
    	Object[][] data=  ReadTestData.getTestDataFromExcel("Login");
    	return data;
    }

    
   @Test(priority = 2)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
	   shopperLoginPage.shopperLogin(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
       

       try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
       
       boolean Error = driver.getPageSource().contains("Given user ID or password is wrong");
	    if (Error == true)
	    {
	     System.out.print(" Given user ID or password is wrong  - Error msg is displayed");
	     Assert.assertTrue(true, "Error message is not displayed as expected");
	    }
	    else
	    {
	     System.out.print(" Error msg is not dispalyed");
	     Assert.fail("Error message is not displayed");
	    }

   }
   
    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
    	shopperLoginPage.shopperLogin(ReadTestData.generateEmailWithTimeStamp(), dataProp.getProperty("validPassword"));
    	
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

        boolean Error = driver.getPageSource().contains("Given user ID or password is wrong");
	    if (Error == true)
	    {
	     System.out.print(" Given user ID or password is wrong  - Error msg is displayed");
	     Assert.assertTrue(true, "Error message is not displayed as expected");
	    }
	    else
	    {
	     System.out.print(" Error msg is not dispalyed");
	     Assert.fail("Error message is not displayed");
	    }
    }
    
    @Test(priority = 4)
    public void verifyLoginWithInvalidEmailandPassword() {
    	
   shopperLoginPage.shopperLogin(ReadTestData.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
    	   
   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    	   
    	   boolean Error = driver.getPageSource().contains("Given user ID or password is wrong");
   	    if (Error == true)
   	    {
   	     System.out.print(" Given user ID or password is wrong  - Error msg is displayed");
   	     Assert.assertTrue(true, "Error message is not displayed as expected");
   	    }
   	    else
   	    {
   	     System.out.print(" Error msg is not dispalyed");
   	     Assert.fail("Error message is not displayed");
   	    }
    }
    
    @Test(priority=5)
    public void verifyLoginWithoutProvidingCredentials() {
   shopperLoginPage.clickOnLoginButton();
}
}

    

    
    

