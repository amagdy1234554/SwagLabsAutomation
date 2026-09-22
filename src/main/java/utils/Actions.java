package utils;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions {
    protected WebDriver driver;
    protected final WebDriverWait wait;
    protected final org.openqa.selenium.interactions.Actions actions;

    public Actions() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait.seconds")));
        this.actions = new org.openqa.selenium.interactions.Actions(driver);
    }
    public void openWebSite() {
        driver.get(ConfigReader.getProperty("base.url"));
    }
    public void waitForPageLoad(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void click(By locator) {
        actions.moveToElement(driver.findElement(locator)).click().perform();
    }
    public void fillText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void selectByVisibleText(By locator, String text) {
        new Select(waitForClickable(locator)).selectByVisibleText(text);
    }
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait.seconds"))).
                until(driver -> {
                    List<WebElement> elements = driver.findElements(locator);
                    if (!elements.isEmpty()) {
                        WebElement element = elements.get(0);
                        if (element.isDisplayed()) {
                            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
                            return true;
                        }
                    }
                    js.executeScript("window.scrollBy(0, 500);");
                    return false;
                });
    }
}
