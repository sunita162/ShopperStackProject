package shopperstack.BuyProducts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	//private WebDriver driver;
   // private ProductCategoryPage productCategoryPage;
   // private CartPage cartPage;
private AdressPage adressPage;
	
	@Test
	public void buyNowButton() throws InterruptedException {
		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		UserHomePage userHomePage = new UserHomePage (driver);
		userHomePage.clickMenCategoryLink();
		ProductCategoryPage productCategoryPage= new ProductCategoryPage(driver);
    	productCategoryPage.clickOnJeans();
    Thread.sleep(5000);
    	CartPage cartPage = new CartPage(driver);
       cartPage.clickBuyNow();
       Assert.assertTrue(driver.getPageSource().contains("Address"), "The page source should contain 'Address'");
     Thread.sleep(5000);
       AdressPage adressPage=new AdressPage(driver);
       adressPage.getAddNewAdress();
       Assert.assertTrue(driver.getPageSource().contains("addressform"), "The page source should contain 'addressform'");
       
       adressPage=cartPage.navigateToAdressPage();
       String name=dataProp.getProperty("name");
       String houseOfficeInfo=dataProp.getProperty("houseOfficeInfo");
       
       
    }

	
	
}