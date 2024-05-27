package shopperstack.ProductCategory;

import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.UserHomePage;

public class beautyCategory extends Base {
	
	@Test
	public void ClickBeautyCategoryLink() throws InterruptedException {
		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Thread.sleep(5000);
		UserHomePage userHomePage = new UserHomePage (driver);
		Thread.sleep(3000);
		userHomePage.clickOnBeautyCategoryLink();
		Thread.sleep(3000);
		 Assert.assertTrue(driver.getPageSource().contains("lakme "), "The page source should contain 'lakme '");
		
	}
	
	
	

}
