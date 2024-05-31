package shopperstack.BuyProducts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.AdressPage;
import shopperstack.pageobjects.CartPage;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ProductCategoryPage;
import shopperstack.pageobjects.UserHomePage;

public class buyProducts extends Base {
	
	
	@Test
	public void buyNowButton() throws InterruptedException {
		
		//Login
		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		UserHomePage userHomePage = new UserHomePage (driver);
		
		//Select product catagory and select a product 
		userHomePage.clickMenCategoryLink();
		ProductCategoryPage productCategoryPage= new ProductCategoryPage(driver);
    	productCategoryPage.clickOnJeans();
    Thread.sleep(5000);
    	CartPage cartPage = new CartPage(driver);
       cartPage.clickBuyNow();
       Assert.assertTrue(driver.getPageSource().contains("Address"), "The page source should contain 'Address'");
     Thread.sleep(2000);
     
       AdressPage adressPage=new AdressPage(driver);
       adressPage.addNewAdressLink().click();
       Assert.assertTrue(driver.getPageSource().contains("addressform"), "The page source should contain 'addressform'");
      
       
       adressPage.selectAddressTypeHome().click();
       String name=dataProp.getProperty("name");
       String houseOfficeInfo=dataProp.getProperty("houseOfficeInfo");
       String streetInfoField=dataProp.getProperty("streetInfoField");
       String landmarkField=dataProp.getProperty("landmarkField");
       String pincodeField=dataProp.getProperty("pincodeField");
       String phoneNumberField=dataProp.getProperty("phoneNumberField");
       String countryDropdown=dataProp.getProperty("countryDropdown");
       String stateDropdown=dataProp.getProperty("stateDropdown");
       String cityDropdown=dataProp.getProperty("cityDropdown");

       adressPage.homefillAddress(name, houseOfficeInfo, streetInfoField, landmarkField, pincodeField, phoneNumberField, countryDropdown, stateDropdown, cityDropdown);
       adressPage.selectaddressRadioButton().click();
       Thread.sleep(7000);
       adressPage.getProceedButton().click();
       Thread.sleep(7000);

       Assert.assertTrue(driver.getPageSource().contains("Payment Method"), "The page source should contain 'Payment Method'");
       
       

	}
	
}