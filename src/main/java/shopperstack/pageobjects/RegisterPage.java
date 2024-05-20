package shopperstack.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtilities.ReadTestData;



public class RegisterPage {
	// ================Web elements or Property================
	WebDriver driver;
	@FindBy(id="First Name")
	private WebElement firstNameField;
	
	@FindBy(id="Last Name")
	private WebElement lastNameField;
	
	@FindBy(id="Female")
	private WebElement femaleField;
	
	@FindBy(id="Phone Number")
	private WebElement phoneNumberField;
	
	@FindBy(id="Password")
	private WebElement passwordField;
	
	@FindBy(id="Confirm Password")
	private WebElement passwordConfirmField;
	
	@FindBy(id="Email Address")
	private WebElement emailAdressField;
	
	@FindBy(id="Terms and Conditions")
	private WebElement termsAndConditionField;
	
	@FindBy(id="btnDisabled")
	private WebElement registerButton;
   
	
	private By errorMessages = By.cssSelector("#cnfPassword-error"); 
	
	@FindBy(css="#cnfPassword-error")
	private WebElement passwordMisMatch;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//Action
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys( firstNameText);
	}
		
		public void enterLastName(String lastNameText) {
			lastNameField.sendKeys(lastNameText);	
		}
		
		public void clickOnGenderFamale() {
			femaleField.click();
		}
		
		public void enterPhoneNumber(String telephoneText) {
			 phoneNumberField.sendKeys( telephoneText);	
		}
		
		public void enterPassword(String passwordText) {
			 passwordField.sendKeys(passwordText);
		}
		
		public void enterConfirmPassword(String passwordText) {
			passwordConfirmField.sendKeys(passwordText);
		}
			
			public void enterEmailAdress(String emailText) {
				emailAdressField.sendKeys(emailText);	
			}
			
			public void clickOnTermsAndConditions() {
				termsAndConditionField.click();
		}
			public void clickOnRegister() {
				registerButton.click();
			}
			
			//================Business Logic or Action methods or Behavior================
		
		public UserHomePage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText) {
		firstNameField.sendKeys( firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAdressField.sendKeys(ReadTestData.generateEmailWithTimeStamp());
		phoneNumberField.sendKeys( ReadTestData.generatePhoneNumber());	
		 passwordField.sendKeys(passwordText);
		 passwordConfirmField.sendKeys(passwordText);
		 
		 termsAndConditionField.click();
		 
		 registerButton.click();
		 return new UserHomePage(driver);
		
		}
		public HomePage register(String firstNameText, String lastNameText, String emailText, String passwordText, String confirmPasswordText, String phone) {
			
			firstNameField.sendKeys(firstNameText);
			lastNameField.sendKeys(lastNameText);
			phoneNumberField.sendKeys( ReadTestData.generatePhoneNumber());
			emailAdressField.sendKeys(ReadTestData.generateEmailWithTimeStamp());
			passwordField.sendKeys(passwordText);
			passwordConfirmField.sendKeys(confirmPasswordText);
			termsAndConditionField.click();
			registerButton.click();
	        return new HomePage(driver);
	        
	    }
		
		
public HomePage registerFieldValidation(String firstNameText, String lastNameText, String emailText, String passwordText, String confirmPasswordText, String phone) {
			
			firstNameField.sendKeys(firstNameText);
			lastNameField.sendKeys(lastNameText);
			phoneNumberField.sendKeys( ReadTestData.generatePhoneNumber());
			emailAdressField.sendKeys(ReadTestData.generateEmailWithTimeStamp());
			passwordField.sendKeys(passwordText);
			passwordConfirmField.sendKeys(confirmPasswordText);
			termsAndConditionField.click();
			//registerButton.click();
	        return new HomePage(driver);
}


		public boolean isErrorDisplayed(String expectedErrorMessage) {
	        List<WebElement> errorElements = driver.findElements(errorMessages);
	        for (WebElement errorElement : errorElements) {
	            if (errorElement.isDisplayed() && errorElement.getText().contains(expectedErrorMessage)) {
	                return true;
	            }
	        }
	        return false;

		}	
		
		
}
	

	