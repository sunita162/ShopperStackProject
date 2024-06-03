package shopperstack.SearchTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.HomePage;

public class SearchWithInvalidProduct extends Base {
	//WebDriver driver;
	@Test
	public void verifySearchWithInvalidProduct() {
		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
    	homePage = new HomePage(driver);
		driver.findElement(By.id("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		driver.findElement(By.id("searchBtn")).click();
		
		String actualSearchMessage=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/section/article/h1")).getText();
		Assert.assertEquals(actualSearchMessage,"Sorry No Data Found","Sorry no data found message not Display");
		
	}
	

}
