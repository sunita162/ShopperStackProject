package shopperstack.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public  WebDriver driver;
	
		@BeforeClass
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
		@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	}
	