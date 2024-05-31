package shopperstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryPage {
	

private WebDriver driver;

	
	
	@FindBy(xpath="//a[@href='/sub-category/men-shirt']")
	private static WebElement Shirt;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/nav/ul/li[2]/div/aside/div[1]/ul/li[4]/a")
	private WebElement Sarees;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/nav/ul/li[3]/div/aside/div[2]/ul/li[2]/a")
	private WebElement Dresses;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/nav/ul/li[4]/div/aside/div/ul/li[4]/a")
	private WebElement Watch;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/nav/ul/li[5]/div/aside/div/ul/li[11]/a")
	private WebElement Cream;
	
	@FindBy (xpath="//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[1]/span[2]")
	private static WebElement Jeans;
	
	
	@FindBy(xpath="//*[@id=\\\"root\\\"]/div[4]/div/div/div[1]/div[3]/div[2]/button")
	private static WebElement addToCart;
	
	@FindBy(xpath="//*[contains(text(),'add to cart')]")
    //@FindBy(xpath="//button[@id='Buy Now' and contains(@class, 'ProductDisplay_buyNow__4fwjt')]/span[text()='buy now']")
	public WebElement addToCartButton;
	
	
	@FindBy(xpath="//*[@id=\"root\"]/section[2]/article/div/div[2]/div[1]/h2")
    private WebElement cartItem;
	
	public ProductCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*public static boolean menProductIsDisplayed() {
		boolean displayStatus = Jeans.isDisplayed();
		return displayStatus;
	}
	/*  public static  void clickOnaddToCartButton() {
	    	try {
				addToCart.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	    	return addToCart;*/
	
	/*  public WebElement getShirtElement() {
	        return Shirt;
	    }
	
	public static WebElement  clickOnShirt() {
        Shirt.click();
		return Shirt;*/
		
	 public WebElement getShirtElement() {
	        return Shirt;
	    }
	 
	 public void clickOnShirt() {
	        Shirt.click();
	    }


    public void clickOnSarees() {
        Sarees.click();
    }

    public void clickOnDresses() {
        Dresses.click();
    }

    public void clickOnWatch() {
        Watch.click();
    }

    public void clickOnCream() {
        Cream.click();
    }

  public void clickOnJeans() {
	  Jeans.click();
  }
 
 
    
    public boolean isProductInCart() {
        return cartItem.isDisplayed();
    }
    
    public WebElement clickAddToCart() {
       // WebElement addToCartButton = driver.findElement(By.xpath("//*[contains(text(),'add to cart')]"));
        return addToCartButton;
}
}


    





	



	

	
	

