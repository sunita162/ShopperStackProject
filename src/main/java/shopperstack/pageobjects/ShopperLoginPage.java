package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopperLoginPage {
    
	private WebDriver driver;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "//span[normalize-space()='Login']")
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

    public void clickOnLoginButton() {
        loginButton.click();
    }
    
    
    
}
