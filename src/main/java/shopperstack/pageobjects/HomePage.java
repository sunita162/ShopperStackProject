package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	
	// objects 
	@FindBy (id="loginBtn")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Create Account']")
	private WebElement CreateAccount;
	
	@FindBy(id="search")
	private WebElement searchBoxField;
	
	@FindBy(id="searchBtn")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[3]/nav/ol/li/a")
	private WebElement homePageInformationOption;
	
	
	
	
	
	
	public HomePage(WebDriver driver) {
		//when we create object for homepage,this constructor will be called to initialize these webelements 
		this.driver=driver;
		PageFactory.initElements(driver,this);//this means HomePage.class
		
	}	
		
	//Actions
	
	public  ShopperLoginPage clickOnLoginButton() {
		loginButton.click();
		return new ShopperLoginPage(driver);
	}
		
		public RegisterPage clickOnCreateAccount(){
		
			CreateAccount.click();
			return new RegisterPage(driver);
		}
		
		public RegisterPage navigateToRegisterPage() {
			loginButton.click();
			CreateAccount.click();
			return new RegisterPage(driver);
			
			
		}
		public void enterProducIntoSearchBoxField(String productText) {
			searchBoxField.sendKeys(productText);
		}
		

		public SearchPage clickOnSearchButton() {
			 searchButton.click();
			 return new SearchPage(driver);
		}
		
		public SearchPage searchForAProduct(String productText) {
			
			searchBoxField.sendKeys(productText);
			searchButton.click();
			 return new SearchPage(driver);
			
		}
		
		public  boolean getDisplayStatusOfhomePageInformationOption() {
			boolean  displayStatus=homePageInformationOption.isDisplayed();
			return displayStatus;
			
		}
		
}

