package shopperstack.SearchTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.SearchPage;

public class SearchWithValidProduct extends Base{
	
	  @Test
	    public void verifySearchWithValidProduct() throws InterruptedException   {
	    	login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
	    	homePage = new HomePage(driver);
	        SearchPage searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
	        Thread.sleep(5000);
	       Assert.assertTrue(searchPage.displayStatusOfIphoneValidProduct(), "Valid product iPhone is not displayed in the search results");
	        
}

}
