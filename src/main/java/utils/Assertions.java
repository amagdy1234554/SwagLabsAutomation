package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Assertions {
    private Actions actions;

    //    public void assertPageDisplay(By locator){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement pageContainer = actions.waitForPageLoaded(locator);
//        Assert.assertNotNull(locator, "Page container was not found.");
//        Assert.assertTrue(pageContainer.isDisplayed());
//    }
    public void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }
}
