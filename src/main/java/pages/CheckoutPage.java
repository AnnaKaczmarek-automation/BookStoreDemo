package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='newOrder']")
    private WebElement continueButton;
    @FindBy(css = "[name='order.cardType']")
    private WebElement cardTypeField;
    @FindBy(css = "[name='order.creditCard']")
    private WebElement cardNumberField;
    @FindBy(css = "[name='order.expiryDate']")
    private WebElement expireDateField;

    public void choseContinueButton() {
        waitUntilElementIsClickable(continueButton);
        clickOnElement(continueButton);
        log.info("'Continue' button was clicked");
    }


    public void verifyPaymentDetails(String cardType) {
//        Select select = new Select(cardTypeField);
//        waitUntilElementIsClickable(cardTypeField);
//        clickOnElement(cardTypeField);
//        if (cardType.equalsIgnoreCase("Visa")) {
//            select.selectByValue("Visa");
//        }
//        if (cardType.equalsIgnoreCase("MasterCard")) {
//            select.selectByValue("MasterCard");
//        }
//        if (cardType.equalsIgnoreCase("AmericanExpress")) {
//            select.selectByValue("AmericanExpress");
//        }
    }

    public void verifyBillingAddress(boolean shipToDifferentAddress) {
        if (shipToDifferentAddress) {

        } else {

        }
    }
}
