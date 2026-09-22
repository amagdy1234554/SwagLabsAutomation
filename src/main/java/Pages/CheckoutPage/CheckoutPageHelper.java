package Pages.CheckoutPage;

import utils.Actions;

public class CheckoutPageHelper extends CheckoutPageElement{
    private Actions actions;

    public void enterCustomerInfo(String firstName, String lastName, String postalCode) {
        actions.fillText(firstNameTxt, firstName);
        actions.fillText(lastNameTxt, lastName);
        actions.fillText(postalCodeTxt, postalCode);
    }

    public void continueCheckout() {
        actions.click(continueBtn);
    }

    public String getErrorMessage() {
        return actions.getText(errorMessage);
    }

    public String getSubtotal() {
        return actions.getText(subTotal);
    }

    public String getTax() {
        return actions.getText(tax);
    }

    public String getTotal() {
        return actions.getText(totalFinal);
    }

    public int getSummaryItemCount() {
        return actions.findElements(summaryContact).size();
    }

    public void finish() {
        actions.click(finishBtn);
    }

    public String getConfirmationMessage() {
        return actions.getText(confirmMessage);
    }
}

