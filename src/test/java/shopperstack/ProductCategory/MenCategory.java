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

public class MenCategory extends Base {
	
@Test
public void ClickMenCategoryLink() {
	login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
	UserHomePage userHomePage = new UserHomePage (driver);
	userHomePage.clickMenCategoryLink();
    Assert.assertTrue(driver.getPageSource().contains("Skinny Men Blue Jeans"), "The page source should contain 'Skinny Men Blue Jeans'");

}
}
    		

	


    



	
	
