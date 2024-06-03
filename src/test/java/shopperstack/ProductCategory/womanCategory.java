package shopperstack.ProductCategory;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.ProductCategoryPage;
import shopperstack.pageobjects.UserHomePage;

public class womanCategory extends Base {
	

  @Test
public void ClickwomanCategoryLink() {
	login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
	UserHomePage userHomePage = new UserHomePage (driver);
	userHomePage.clickOnWomenCategoryLink();
    Assert.assertTrue(driver.getPageSource().contains("Women "), "The page source should contain 'Women '");

}
    		

	
}

    



	
	
