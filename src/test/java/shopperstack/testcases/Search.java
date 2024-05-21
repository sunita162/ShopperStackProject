package shopperstack.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;
import shopperstack.pageobjects.SearchPage;

public class Search extends Base {

    private HomePage homePage;

    public Search() {
        super();
    }	

    
    @Test
    public void verifySearchWithValidProduct() throws InterruptedException {
    	login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
    	homePage = new HomePage(driver);
        SearchPage searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
        Thread.sleep(3000);
        Assert.assertTrue(searchPage.displayStatusOfIphoneValidProduct(), "Valid product iPhone is not displayed in the search results");
    }
}
