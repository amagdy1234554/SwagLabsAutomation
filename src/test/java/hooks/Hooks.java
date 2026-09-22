package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }
    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        if (scenario.isFailed() && driver != null) {
            ScreenshotUtil.capture(driver, "failure_" + scenario.getName());
        }
        DriverFactory.quitDriver();
    }
}
