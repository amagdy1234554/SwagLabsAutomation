package Pages.OverviewPage;

import org.openqa.selenium.By;

public class OverviewPageElement {
    By itemSubTotal = By.xpath("//*[@class=\"summary_subtotal_label\"]");
    By itemTax = By.xpath("//*[@class=\"summary_tax_label\"]");
    By itemTotal = By.xpath("//*[@class=\"summary_total_label\"]");
    By finishBtn = By.id("finish");
    By completeOrder = By.xpath("//*[@class=\"complete-header\"]");
}
