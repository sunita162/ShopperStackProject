package shopperstack.ProductCategory;

import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.UserHomePage;

public class electronicsCategory extends Base {
	
	@Test
	public void clickElectronicCategoryLink() throws InterruptedException {
		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Thread.sleep(5000);
		UserHomePage userHomePage = new UserHomePage (driver);
		userHomePage.clickOnElectronicCategoryLink();
		Thread.sleep(3000);
		 Assert.assertTrue(driver.getPageSource().contains("apple "), "The page source should contain 'apple '");
	}

}
