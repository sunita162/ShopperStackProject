package shopperstack.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shopperstack.base.Base;

public class Search extends Base {

	
	 public Search() throws IOException {
	    	super();
	 }
	 public WebDriver driver;
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver=initializeBrowserAndOpenApplicationURL (prop.getProperty("browserName")); 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
   	    driver.findElement(By.id("loginBtn")).click();// Initialize WebDriverWait

		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("Password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("Login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		driver.findElement(By.name("search")).sendKeys("iphone");
		driver.findElement(By.id("searchBtn")).click();
		
		//Assert.assertTrue(driver.findElement(By.linkText("APPLE iPhone 14 Pro")).isDisplayed(),"Valid product iphone is not displayed in the search results");
		
	}
	

	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		driver.findElement(By.id("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		driver.findElement(By.id("searchBtn")).click();
		
		String actualSearchMessage=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/section/article/h1")).getText();
		Assert.assertEquals(actualSearchMessage,"There is no product thats matches the search creteria.","Sorry no data found message not Display");
		
	}
	/*@Test(priority=3)
	public void verifySearchWithoutProduct() {
		driver.findElement(By.id("search")).sendKeys("");
		driver.findElement(By.id("searchBtn")).click();
		
		//String actualSearchMessage=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/section/article/h1")).getText();
		//Assert.assertEquals(actualSearchMessage,"There is no product thats matches the search creteria.","Sorry no data found message not Display");
		
		
		
	}*/
	

}
