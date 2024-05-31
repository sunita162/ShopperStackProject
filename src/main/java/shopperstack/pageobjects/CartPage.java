package shopperstack.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(xpath="//*[@id=\"cartIcon\"]")
    private WebElement cartBadge;
    
    @FindBy(xpath="//*[@id=\"cart\"]/span")
    private WebElement cartNumber;
    
    @FindBy(xpath="//*[@id=\"root\"]/div[4]/div/div/div/div[1]/img")
    private WebElement cartItem;
    
    @FindBy(xpath="//*[@id=\"root\"]/div[4]/div/div/div[2]/div[3]/div[2]/button")
    private WebElement AddToCart;
    
    //@FindBy(xpath="//*[@id=\"Buy Now\"]/span")
    //@FindBy(xpath="//span[text()='Buy Now']")
    //@FindBy(xpath="//button[@id='Buy Now' and @name='Buy Now' and contains(@class, 'ProductDisplay_buyNow__4fwjt')]/span[text()='buy now']")
    //@FindBy(xpath="//button[@id='Buy Now' and @name='Buy Now' and contains(@class, 'ProductDisplay_buyNow__4fwjt')]")
   // @FindBy(xpath="//button[@id='Buy Now' and contains(@class, 'ProductDisplay_buyNow__4fwjt')]/span[text()='buy now']")
    @FindBy(xpath="//button[@id='Buy Now' and @name='Buy Now' and contains(@class, 'ProductDisplay_buyNow__4fwjt')]")

    private WebElement BuyNow;
	private WebElement addAdressButton;
    
    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Initialize WebDriverWait with a timeout of 10 seconds
        PageFactory.initElements(driver, this);
    }    
    
    public boolean isProductInCart() {
        return cartItem.isDisplayed();
    }
        
    public WebElement getCartNumberElement() {
        return cartNumber;
    }
    
    public String cartNumberText() {
        return cartNumber.getText();
    }
    
    public String cartItemsCount() {
        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart_checkoutProductContainer__jtOKS']/div"));
        int itemCount = cartItems.size();
        return String.valueOf(itemCount);
    }
    
    public AdressPage navigateToCartPage() {
    	cartBadge.click();
		return null;
    }
    public AdressPage navigateToAdressPage() {
    	addAdressButton.click();
    	return new  AdressPage(driver);
    }
    
   /* public RegisterPage navigateToRegisterPage() {
		loginButton.click();
		CreateAccount.click();
		return new RegisterPage(driver);*/
		
    
    public void clickAddToCart() {
        AddToCart.click();
    }
    
    public void clickBuyNow() {
        BuyNow.click();
    }
    
 // Method to remove all items from the cart
 // Method to remove all items from the cart
    public void removeAllItemsFromCart() {
        List<WebElement> removeButtons;

        // Loop until no "Remove from cart" buttons are found
        do {
            removeButtons = driver.findElements(By.xpath("//button[contains(., 'Remove from cart')]"));
            for (WebElement removeButton : removeButtons) {
                // Move to the remove button
                Actions actions = new Actions(driver);
                actions.moveToElement(removeButton).perform();
                // Wait for the overlay to disappear
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));
                // Wait for the button to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(removeButton));
                // Click the remove button
                removeButton.click();
                // Wait for a short period to allow for the removal action to complete
                try {
                    Thread.sleep(2000); // 2-second wait
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Click the "Yes" button in the popup
                WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Yes')]")));
                yesButton.click();
                // Wait for the remove button to become stale
                wait.until(ExpectedConditions.stalenessOf(removeButton));
            }
        } while (!removeButtons.isEmpty());
    }





}

