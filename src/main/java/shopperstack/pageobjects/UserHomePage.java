package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	WebDriver driver;
	
	//@FindBy(xpath="//*[@id=\"root\"]/div[3]/nav/ol/li/a")
	//private WebElement UserLandingPage;
	
	@FindBy (css="body > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
	//@FindBy(id="men")
	private WebElement MenCategoryLink;
	
	@FindBy(id="women")
	private WebElement WomenCategoryLink;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/nav/ul/li[3]/a")
	private WebElement KidsCategoryLink;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/nav/ul/li[4]/a")
	private WebElement ElectronicsCategoryLink;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/nav/ul/li[5]/a")
	private WebElement BeautyCategoryLink;

		public  UserHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
		/*public String retrieveUserLandingPage() {
			String UserLandingPageText =  UserLandingPage.getText();
			return UserLandingPageText;
		}*/
		/*public ProductCategoryPage clickOnMenCategoryLink() {
			MenCategoryLink.click();
			return new ProductCategoryPage(driver);
		}*/
		public ProductCategoryPage clickMenCategoryLink() {
	        MenCategoryLink.click();
	        return new ProductCategoryPage(driver);
	    }
		public ProductCategoryPage clickOnWomenCategoryLink() {
			WomenCategoryLink.click();
			return new ProductCategoryPage(driver);
		}
		
		public ProductCategoryPage clickOnKidsCategoryLink() {
			KidsCategoryLink.click();
			return new ProductCategoryPage(driver);
		}	
			public ProductCategoryPage clickOnBeautyCategoryLink() {
				BeautyCategoryLink.click();
				return new ProductCategoryPage(driver);
			}
			
			public ProductCategoryPage clickOnElectronicCategoryLink() {
				ElectronicsCategoryLink.click();
				return new ProductCategoryPage(driver);
			}
			
	
			
	}
	
	


