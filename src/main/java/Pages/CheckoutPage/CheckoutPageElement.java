package Pages.CheckoutPage;

import org.openqa.selenium.By;

public class CheckoutPageElement {
    By firstNameTxt = By.id("first-name");
    By lastNameTxt = By.id("last-name");
    By postalCodeTxt = By.id("postal-code");
    By continueBtn = By.id("continue");
    By errorMessage = By.xpath("//*[@data-test=\"error\" and @role=\"alert\"]");
    By subTotal = By.xpath("//*[@class=\"summary_subtotal_label\"]");
    By tax = By.xpath("//*[@class=\"summary_tax_label\"]");
    By totalFinal = By.xpath("//*[@class=\"summary_total_label\"]");
    By finishBtn = By.id("finish");
    By confirmMessage = By.xpath("//*[@class=\"complete-header\"]");
    By summaryContact = By.xpath("//*[@class=\"cart_item\"]");
}
