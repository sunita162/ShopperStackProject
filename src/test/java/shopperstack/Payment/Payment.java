package shopperstack.Payment;

import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.AdressPage;
import shopperstack.pageobjects.CartPage;
import shopperstack.pageobjects.PaymentPage;
import shopperstack.pageobjects.ProductCategoryPage;
import shopperstack.pageobjects.UserHomePage;

public class Payment extends Base {

	@Test
	public void paymentProduct() throws InterruptedException {

		login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		UserHomePage userHomePage = new UserHomePage (driver);
				
		//Select product catagory and select a product 
		userHomePage.clickMenCategoryLink();
		ProductCategoryPage productCategoryPage= new ProductCategoryPage(driver);
		productCategoryPage.clickOnJeans();
		Thread.sleep(5000);
		CartPage cartPage = new CartPage(driver);
		cartPage.clickBuyNow();
		Assert.assertTrue(driver.getPageSource().contains("Address"), "The page source should contain 'Address'");
		Thread.sleep(2000);
		
		AdressPage adressPage = new AdressPage(driver);
		adressPage.addNewAdressLink().click();

		adressPage.selectAddressTypeHome().click();
		String name=dataProp.getProperty("name"); 
		String houseOfficeInfo=dataProp.getProperty("houseOfficeInfo"); 
		String  streetInfoField=dataProp.getProperty("streetInfoField"); 
		String landmarkField=dataProp.getProperty("landmarkField"); 
		String  pincodeField=dataProp.getProperty("pincodeField"); 
		String phoneNumberField=dataProp.getProperty("phoneNumberField"); 
		String  countryDropdown=dataProp.getProperty("countryDropdown"); 
		String  stateDropdown=dataProp.getProperty("stateDropdown"); 
		String cityDropdown=dataProp.getProperty("cityDropdown");
		  
		  adressPage.homefillAddress(name, houseOfficeInfo, streetInfoField,
		  landmarkField, pincodeField, phoneNumberField, countryDropdown,
		  stateDropdown, cityDropdown); adressPage.selectaddressRadioButton().click();
		  adressPage.getProceedButton().click(); Thread.sleep(2000); PaymentPage
		  paymentPage=new PaymentPage(driver);
		  paymentPage.selectnetBankingRadioButton().click(); Thread.sleep(2000);
		  paymentPage.getAddCardButton().click(); Thread.sleep(2000);
		  Assert.assertTrue(driver.getPageSource().contains("Add Card"),
		  "The page source should contain 'Add Card'"); Thread.sleep(2000);
		  paymentPage.selectDebitRadioButton().click();
		  
		  String cardHolderName=dataProp.getProperty("cardHolderName");
		  Thread.sleep(2000);
		  
		  String cardNumber=dataProp.getProperty("cardNumber"); Thread.sleep(2000);
		  
		  String pin=dataProp.getProperty("pin"); 
		  String expiryMonth=dataProp.getProperty("expiryMonth"); 
		  String expiryYear=dataProp.getProperty("expiryYear");
		  String cvv=dataProp.getProperty("cvv");
		  
		  paymentPage.addDebitCard(cardHolderName, cardNumber, pin, expiryMonth,expiryYear, cvv); //paymentPage.selectDebitRadioButton().click();
		  Thread.sleep(2000);
		  paymentPage.getAddButton(); Thread.sleep(3000);
		  Assert.assertTrue(driver.getPageSource().contains("Payment Method"),"The page source should contain 'Payment Method'");
		  
		  
		  paymentPage.selectDebitCardRadioButton().click();
		  pin=dataProp.getProperty("pin");
		  paymentPage.enterDebitPin(pin);
		  Thread.sleep(2000);
		  
		  paymentPage.clickSubmitButton().click(); 
		  Thread.sleep(3000);

		  paymentPage.getProceedButton().click();
		  Thread.sleep(3000);
		 // Assert.assertTrue(driver.getPageSource().contains("Order Confirmation"), "The page source should contain 'Order Confirmation'"); 
		 // Thread.sleep(9000);
		 
	}
}
