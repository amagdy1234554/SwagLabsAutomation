package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void selectDropDown (By locator, int index){
        WebElement dropDown = driver.findElement(locator);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    public String getMessage (By locator){
        return driver.findElement(locator).getText();
    }
    public WebElement waitForElementVis(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClick(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickElement(By locator) {
        WebElement element;
        element = waitForElementClick(locator);
        element.click();
    }
    public void fillElement(By locator, String value){
        WebElement element;
        element = waitForElementVis(locator);
        element.sendKeys(value);
    }
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
    public boolean isVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}