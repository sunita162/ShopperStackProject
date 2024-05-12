package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	
	//Page objects 
	@FindBy (id="loginBtn")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Create Account']")
	private WebElement CreateAccount;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	//Actions 
	public  void clickOnLoginButton() {
		loginButton.click();
	}
		
		public void clickOnCreateAccount(){
		
			CreateAccount.click();
		}
	}

