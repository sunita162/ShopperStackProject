package shopperstack.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[text()='APPLE iPhone 14 Pro']")
	private WebElement validIphoneProduct;
	
	 @FindBy(xpath = "//h1[text()='Sorry No Data Found']")
	    private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	//Actions
	public boolean displayStatusOfIphoneValidProduct() {
		boolean displayStatus = validIphoneProduct.isDisplayed();
		return displayStatus;
	}
		
		 public String retrieveNoProductMessageText() {
		        return noProductMessage.getText();
		}
	}

