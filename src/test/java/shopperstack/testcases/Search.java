package shopperstack.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

//import org.automation.element_repository.Home_Page;

//import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genricUtilities.ReadTestData;
import genricUtilities.Utilities;
import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.SearchPage;
import shopperstack.pageobjects.ShopperLoginPage;
//import shopperstack.utility.Utilities;



public class Search extends Base {
	HomePage homePage;
	ShopperLoginPage shopperLoginPage;
	 public Search()  {
	    	super();
	 }
	 public WebDriver driver;
	
	 @BeforeMethod
	public void setUp() {
       
		 driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	    homePage = new HomePage(driver);
	    shopperLoginPage =homePage.clickOnLoginButton();
	   HomePage homePage = shopperLoginPage.shopperLogin( prop.getProperty("validEmail"),  prop.getProperty("validPassword"));
	 }  	
	    	 
	     	
	 @AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() throws InterruptedException {
		Thread.sleep(5000);
		SearchPage searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		Thread.sleep(3000);
		Assert.assertTrue(searchPage.displayStatusOfIphoneValidProduct(),"Valid product iphone is not displayed in the search results");
		
	}
}
	


		
	
	
	
	
	


