package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdressPage {
    private WebDriver driver;
    
   
    
    @FindBy(xpath = "//button[@class='selectaddress_adneadd__cICdt']")
    private WebElement addNewAdressLink;
    
    @FindBy(xpath = "//button[@class='selectaddress_proceed__qiGsK']")
    private WebElement proceedButton;
    
    @FindBy(id = "Name")
    private WebElement nameField;
    
    @FindBy(id = "House/Office Info")
    private WebElement houseOfficeField;
    
    @FindBy(id = "Street Info")
    private WebElement streetInfoField;
    
    @FindBy(id = "Landmark")
    private WebElement landmarkField;
    
    @FindBy(id = "Pincode")
    private WebElement pincodeField;
    
    @FindBy(id = "Phone Number")
    private WebElement phoneNumberField;
    
    @FindBy(id = "addAddress")
    private WebElement addAdressButton;

    @FindBy(xpath = "//*[@id=\"Country\"]")
    private WebElement countryDropdown;
    
    @FindBy(xpath = "//*[@id=\"State\"]")
    private WebElement stateDropdown;
    
    @FindBy(xpath = "//*[@id=\"City\"]")
    private WebElement cityDropdown;
    
    @FindBy(xpath = "//input[@type='radio' and @name='address']")
    private WebElement addressRadioButton;
  
    @FindBy(xpath = "//input[@id='Home']")
    private WebElement addressTypeHome;
    
    @FindBy(id="Home")
    private WebElement homeField;
    
    @FindBy(id="Office")
    private WebElement officeField;
    
    @FindBy(id="Other")
    private WebElement otherField;
    
    public AdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public WebElement addNewAdressLink() {
        return addNewAdressLink;
    }
    
    public WebElement getProceedButton() {
        return proceedButton;
    }
    
    public WebElement getNameField() {
        return nameField;
    }
    
    public WebElement getHouseOfficeField() {
        return houseOfficeField;
    }
    
    public WebElement getStreetInfoField() {
        return streetInfoField;
    }
    
    public WebElement getLandmarkField() {
        return landmarkField;
    }
    
    public WebElement getPincodeField() {
        return pincodeField;
    }
    
    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }
    public WebElement getAddAdressButton() {
        return addAdressButton;
    }
    
    public WebElement getCountryDropdown() {
        return countryDropdown;
    }
    
    public WebElement getStateDropdown() {
        return stateDropdown;
    }
    
    public WebElement getCityDropdown() {
        return cityDropdown;
    }
    
    public WebElement selectAddressTypeHome() {
        return addressTypeHome;
    }

    public WebElement getHomeField() {
        return homeField;
    }

    public WebElement getOfficeField() {
        return officeField;
    }

    public WebElement getOtherField() {
        return otherField;
    }    
        
     public WebElement selectaddressRadioButton() {
        return addressRadioButton;
     }  
        
     public CartPage navigateToCartPage() {
		addAdressButton.click();
			return null;
	}

    // Method to select a country from the dropdown
    public void selectCountry(String country) {
        Select dropdown = new Select(getCountryDropdown());
        dropdown.selectByVisibleText(country);
    }
    
    // Method to select a state from the dropdown
    public void selectState(String state) {
        Select dropdown = new Select(getStateDropdown());
        dropdown.selectByVisibleText(state);
    }
    
    // Method to select a city from the dropdown
    public void selectCity(String city) {
        Select dropdown = new Select(getCityDropdown());
        dropdown.selectByVisibleText(city);
    }
    
    // Method to fill the address form, including selecting country, state, and city
    public void homefillAddress(String name,  String houseOfficeInfo, String streetInfo, String landmark, String pincode, String phoneNumber, String country, String state, String city) {
    	//addNewAdressLink().click();
    	selectAddressTypeHome().click();
        getNameField().sendKeys(name);
        getHouseOfficeField().sendKeys(houseOfficeInfo);
        getStreetInfoField().sendKeys(streetInfo);
        getLandmarkField().sendKeys(landmark);
        getPincodeField().sendKeys(pincode);
        getPhoneNumberField().sendKeys(phoneNumber);
        selectCountry(country);
        selectState(state);
        selectCity(city);
        getAddAdressButton().click();
    }
    
    public void officefillAddress(String name, String houseOfficeInfo, String streetInfo, String landmark, String pincode, String phoneNumber, String country, String state, String city) {
    	 
    	addNewAdressLink().click();
        getNameField().sendKeys(name);
        getHouseOfficeField().sendKeys(houseOfficeInfo);
        getStreetInfoField().sendKeys(streetInfo);
        getLandmarkField().sendKeys(landmark);
        getPincodeField().sendKeys(pincode);
        getPhoneNumberField().sendKeys(phoneNumber);
        selectCountry(country);
        selectState(state);
        selectCity(city);
        getAddAdressButton().click();
    }
    
    public void otherAdressfillAddress(String name, String houseOfficeInfo, String streetInfo, String landmark, String pincode, String phoneNumber, String country, String state, String city, String addressTypeValue) {
    	addNewAdressLink().click();
        getNameField().sendKeys(name);
        getHouseOfficeField().sendKeys(houseOfficeInfo);
        getStreetInfoField().sendKeys(streetInfo);
        getLandmarkField().sendKeys(landmark);
        getPincodeField().sendKeys(pincode);
        getPhoneNumberField().sendKeys(phoneNumber);
        selectCountry(country);
        selectState(state);
        selectCity(city);
        getAddAdressButton().click();
    }

	
}
