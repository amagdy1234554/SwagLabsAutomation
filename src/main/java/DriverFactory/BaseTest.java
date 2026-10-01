package DriverFactory;

import Pages.CartPage.CartPageHelper;
import Pages.CheckoutPage.CheckoutPageHelper;
import Pages.InventoryPage.InventoryPageHelper;
import Pages.LoginPage.LoginPageHelper;
import Pages.OverviewPage.OverviewPageHelper;
import Pages.ProductPage.ProductPageHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    private final ConfigReader configReader = new ConfigReader();
    public LoginPageHelper  loginPageHelper;
    public InventoryPageHelper inventoryPageHelper;
    public ProductPageHelper productPageHelper;
    public CartPageHelper cartPageHelper;
    public CheckoutPageHelper checkoutPageHelper;
    public OverviewPageHelper overviewPageHelper;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(configReader.getProperty("base.url"));
        loginPageHelper = new LoginPageHelper(driver);
        inventoryPageHelper = new InventoryPageHelper(driver);
        productPageHelper = new ProductPageHelper(driver);
        cartPageHelper = new CartPageHelper(driver);
        checkoutPageHelper = new CheckoutPageHelper(driver);
        overviewPageHelper = new OverviewPageHelper(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--user-data-dir=C:/SeleniumChromeProfile");
        options.addArguments("--profile-directory=AutomationProfile");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}