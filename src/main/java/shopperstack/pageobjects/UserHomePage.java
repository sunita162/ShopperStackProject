package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[3]/nav/ol/li/a")
	private WebElement UserLandingPage;

		public  UserHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
		public String retrieveUserLandingPage() {
			
			String UserLandingPageText =  UserLandingPage.getText();
			return UserLandingPageText;
		}
	
	}
	
	


