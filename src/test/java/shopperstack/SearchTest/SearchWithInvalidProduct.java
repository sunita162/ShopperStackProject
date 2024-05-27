package shopperstack.SearchTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;

public class SearchWithInvalidProduct extends Base {
	//WebDriver driver;
	@Test
	public void verifySearchWithInvalidProduct() {
		
		driver.findElement(By.id("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		driver.findElement(By.id("searchBtn")).click();
		
		String actualSearchMessage=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/section/article/h1")).getText();
		Assert.assertEquals(actualSearchMessage,"There is no product thats matches the search creteria.","Sorry no data found message not Display");
		
	}
	

}
