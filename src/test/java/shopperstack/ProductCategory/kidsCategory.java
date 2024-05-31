package shopperstack.ProductCategory;

import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.UserHomePage;

public class kidsCategory extends Base {

	@Test
	public void ClickKidsCategoryLink() throws InterruptedException {
		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Thread.sleep(5000);
		UserHomePage userHomePage = new UserHomePage (driver);
		
		userHomePage.clickOnKidsCategoryLink();
		
	    Assert.assertTrue(driver.getPageSource().contains("cutiekins "), "The page source should contain 'cutiekins '");

	}	

}
