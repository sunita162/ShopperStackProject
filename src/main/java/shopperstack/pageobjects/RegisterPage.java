package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	
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
	private WebElement registerField;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
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
				registerField.click();
			}
		
		
	}

	