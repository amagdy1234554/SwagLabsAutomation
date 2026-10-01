package Pages.CheckoutPage;

import org.openqa.selenium.WebDriver;
import utils.Actions;

public class CheckoutPageHelper extends Actions {
    private final CheckoutPageElement checkoutPageElement;

    public CheckoutPageHelper(WebDriver driver) {
        super(driver);
        checkoutPageElement = new CheckoutPageElement();
    }
    public void enterValidCustomerInformation(String firstName, String lastName, String postalCode) {
        fillFirstNameTxt(firstName);
        fillLastNameTxt(lastName);
        fillPostalCodeTxt(postalCode);
    }
    public void clickContinueBtn() {
        clickElement(checkoutPageElement.continueBtn);
    }
    public void fillFirstNameTxt(String firstName) {
        fillElement(checkoutPageElement.firstNameTxt, firstName);
    }
    public void fillLastNameTxt(String lastName) {
        fillElement(checkoutPageElement.lastNameTxt, lastName);
    }
    public void fillPostalCodeTxt(String postalCode) {
        fillElement(checkoutPageElement.postalCodeTxt, postalCode);
    }
}
