package shopperstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	
	private WebDriver driver;
	
@FindBy(xpath="//*[@id=\"root\"]/section[2]/article/div/form/div[1]/div/label[1]/span[1]/input")
private WebElement netBankingRadioButton;

@FindBy(xpath="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='radio-buttons-group' and @type='radio' and @value='COD']")
private WebElement cashOnDeliveryRadioButton;

@FindBy(xpath="//button[text()='Add Card']")
private WebElement addCardButton;
//@FindBy(xpath="//label[contains(text(),'Card  Holder Name')]")
@FindBy(xpath = "//label[contains(@for, ':r')]/following-sibling::div/input")
private WebElement cardHolderNameField;
//*[@id=":rp:-label"]/text()

@FindBy(xpath = "//label[contains(text(), 'Card Number')]/following-sibling::div/input")
private WebElement cardNumberField;

@FindBy(xpath = "//label[contains(text(), 'PIN')]/following-sibling::div/input")
private WebElement pinField;

@FindBy(xpath = "//label[contains(text(), 'Expiry Month')]/following-sibling::div/input")
private WebElement expiryMonthField;

@FindBy(xpath = "//label[contains(text(), 'Expiry Year')]/following-sibling::div/input")
private WebElement expiryYearField;

@FindBy(xpath = "//label[contains(text(), 'CVV')]/following-sibling::div/input")
private WebElement cvvField;

@FindBy(xpath="//input[@name='radio-buttons-group' and @type='radio' and @value='DEBIT']")
private WebElement debitRadioButton;

@FindBy(xpath="//input[@name='radio-buttons-group' and @type='radio' and @value='CREDIT']")
private WebElement creditRadioButton;

@FindBy(xpath = "//div[contains(@class, 'payment_actionBtn__2KSX+')][1]//button[@type='submit']")
private WebElement addButton;

//@FindBy(xpath="//*[@id=\"root\"]/section[2]/article/div/form/div[3]/button")
//@FindBy(xpath="//div[contains(@class, 'payment_actionBtn__2KSX+')]/button[text()='Proceed']")



//@FindBy(xpath="//input[@name='radio-buttons-group' and @type='radio' and @value='[object Object]']")
//private WebElement radioButton;

@FindBy(xpath="//input[@name='radio-buttons-group']")
private WebElement debitCardRadioButton;

@FindBy(xpath="//input[@id='PIN']")
private WebElement debitPinField;

@FindBy(xpath="//button[@id='Submit']")
private WebElement submitButton;

@FindBy(xpath = "/html/body/div[1]/section[2]/article/div/form/div[3]/button")
private WebElement proceedButton;

@FindBy(xpath="//h1[text()='Order Confirmed']")
private WebElement orderConfirmedHeading;




public PaymentPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public WebElement selectnetBankingRadioButton() {
	return netBankingRadioButton;
}

public WebElement selectcashOnDeliveryRadioButton() {
	return cashOnDeliveryRadioButton;
}

public WebElement getAddCardButton() {
    return addCardButton;
}
public WebElement getCardHolderNameField() {
    return cardHolderNameField;
}


public WebElement getCardNumberField() {
    return cardNumberField;
}

public WebElement getPinField() {
    return pinField;
}

public WebElement getExpiryMonthField() {
    return expiryMonthField;
}

public WebElement getExpiryYearField() {
    return expiryYearField;
}

public WebElement getCvvField() {
    return cvvField;
}

public WebElement selectDebitRadioButton() {
    return debitRadioButton;
}

public WebElement selectCreditRadioButton() {
    return creditRadioButton;
}

public WebElement getAddButton() {
    return addButton;
}

public WebElement getProceedButton() {
	return proceedButton;
}
public  WebElement selectDebitCardRadioButton() {
    return debitCardRadioButton;
}
public void enterDebitPin(String pin) {
    debitPinField.clear();
    debitPinField.sendKeys(pin);
}
public WebElement clickSubmitButton() {
	return submitButton;
}

public void orderConfirmedMessage() {
	orderConfirmedHeading.click();
}


		
public void addDebitCard(String cardHolderName,String cardNumber,String pin,String expiryMonth,String expiryYear,String cvv) {
	//WebDriverWait wait = new WebDriverWait(driver, 10);
    //wait.until(ExpectedConditions.visibilityOf(cardHolderNameField));
    //WebDriverWait wait = new WebDriverWait(driver, 10);
    //WebElement popupTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-modal-title")));

    // Click on the popup title
    //popupTitle.click();
	getCardHolderNameField().sendKeys(cardHolderName);
	getCardNumberField().sendKeys(cardNumber);
	getPinField().sendKeys(pin);
	getExpiryMonthField().sendKeys(expiryMonth);
	 getExpiryYearField().sendKeys(expiryYear);
	 getCvvField().sendKeys(cvv);
	 selectDebitRadioButton().click();
	 getAddButton().click();
}
public void addCreditCard(String cardHolderName,String cardNumber,String pin,String expiryMonth,String expiryYear,String cvv) {
	getCardHolderNameField().sendKeys(cardHolderName);
	getCardNumberField().sendKeys(cardNumber);
	getPinField().sendKeys(pin);
	getExpiryMonthField().sendKeys(expiryMonth);
	 getExpiryYearField().sendKeys(expiryYear);
	 getCvvField().sendKeys(cvv);
	 selectCreditRadioButton().click();
	 getAddButton().click();
}

public String getDebitPinValue() {
    return debitPinField.getAttribute("value");
}



	
}


