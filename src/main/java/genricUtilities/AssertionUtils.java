package genricUtilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssertionUtils {
    public static void assertErrorMessageDisplayed(WebDriver driver, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout

        boolean error = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getPageSource().contains(expectedMessage);
            }
        });

        if (error) {
            System.out.println(expectedMessage + " - Error message is displayed");
            Assert.assertTrue(true, "Error message is displayed as expected");
        } else {
            System.out.println("Error message is not displayed");
            Assert.fail("Error message is not displayed");
        }
    }
}
