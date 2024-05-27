package shopperstack.AddCart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import shopperstack.base.Base;
import shopperstack.pageobjects.CartPage;
import shopperstack.pageobjects.ProductCategoryPage;
import shopperstack.pageobjects.UserHomePage;

public class addMenProduct extends Base {
    
    @Test
    public void testAddShirtToCart() throws InterruptedException {
        // Log in to the applications
        login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
        UserHomePage userHomePage = new UserHomePage(driver);
        
        userHomePage.clickMenCategoryLink();
        
        Thread.sleep(5000);
        
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToCartPage();
        Thread.sleep(5000);
        cartPage.removeAllItemsFromCart();
        
        // Retrieve the initial cart item count
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart span")));
        int initialCartItemCount = Integer.parseInt(cartBadge.getText());
        
        // Navigate to the Men's category
        userHomePage.clickMenCategoryLink();
        
        Thread.sleep(5000);

        // Check of the items in the cart and remove all the items 
        
        
        Thread.sleep(5000);
        userHomePage.clickMenCategoryLink();

        
        // Instantiate the ProductCategoryPage
        ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
        
         // Wait for the add to cart button to be clickable
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(productCategoryPage.addToCartButton));
        
        // Scroll the add to cart button into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        
        // Attempt to click the add to cart button
        try {
            addToCartButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Retry clicking using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }

        Thread.sleep(2000);

        // Retrieve the new cart item count
        cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart span")));
        int newCartItemCount = Integer.parseInt(cartBadge.getText());

        // Assert that the cart item count increased by 1
        Assert.assertEquals(newCartItemCount, initialCartItemCount + 1, "The item count in the cart badge did not increase by 1.");

        // Wait for a few seconds to observe the result (optional)
        Thread.sleep(5000);
    }
}


