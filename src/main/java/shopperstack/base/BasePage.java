package shopperstack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtilities.InitObjects;
	
public abstract class BasePage extends  InitObjects {

	public void Base_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//================Web elements or Property================
	@FindBy (id="loginBtn")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Create Account']")
	private WebElement CreateAccount;
	
	@FindBy(id="search")
	private WebElement searchBoxField;
	
	@FindBy(id="searchBtn")
	private WebElement searchButton;
	
	//================Getters or Public services================
	
	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getCreateAccount() {
		return CreateAccount;
	}

	public WebElement getSearchBoxField() {
		return searchBoxField;
	}

	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}

	}