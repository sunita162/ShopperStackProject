package shopperstack.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShopperLoginPage {
    
	private WebDriver driver;
	//================Web elements or Property================
    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"Login\"]/span[1]")
    private WebElement loginButton;
    
   


    public ShopperLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmailId(String emailId) {
        email.sendKeys(emailId);
    }

    public void enterPassword(String passwordText) {
        password.sendKeys(passwordText);
    }

    public HomePage clickOnLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }
    
    public HomePage shopperLogin(String emailId,String passwordText) {
    	email.sendKeys(emailId);
    	 password.sendKeys(passwordText);
    	 loginButton.click();
         return new HomePage(driver);
    	 
    }
    
  //================Business Logic or Action methods or Behavior================ 
    public class LoginPageActions {
    
    private WebDriver driver;

    public LoginPageActions(WebDriver driver) {
        this.driver = driver;
    }
    
    

    public void login(String email, String password) {
        ShopperLoginPage shopperLoginPage = new ShopperLoginPage(driver);
        shopperLoginPage.enterEmailId(email);
        shopperLoginPage.enterPassword(password);
        shopperLoginPage.clickOnLoginButton();
    }
    public HomePage login1(String username, String password) throws InterruptedException {
    	
   	 Thread.sleep(5000);
   	clickOnLoginButton();
       enterEmailId(username);
       enterPassword(password);
       Thread.sleep(5000);
       clickOnLoginButton();
       return new HomePage(driver);
   }
}

}