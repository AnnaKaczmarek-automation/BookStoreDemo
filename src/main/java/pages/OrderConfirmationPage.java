package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tr th[align='center']")
    private WebElement orderHeader;
    @FindBy(xpath = "//tr[3]/td[2]")
    private WebElement cardType;

    @FindBy(xpath = "//tr[4]/td[2]")
    private WebElement cardNumber;

    @FindBy(xpath = "//tr[5]/td[2]")
    private WebElement expireDate;

    @FindBy(xpath = "//tr[7]/td[2]")
    private WebElement firstNameBilling;
    @FindBy(xpath = "//tr[8]/td[2]")
    private WebElement lastNameBilling;
    @FindBy(xpath = "//tr[9]/td[2]")
    private WebElement address1Billing;
    @FindBy(xpath = "//tr[10]/td[2]")
    private WebElement address2Billing;
    @FindBy(xpath = "//tr[11]/td[2]")
    private WebElement cityBilling;
    @FindBy(xpath = "//tr[12]/td[2]")
    private WebElement stateBilling;
    @FindBy(xpath = "//tr[13]/td[2]")
    private WebElement zipBilling;
    @FindBy(xpath = "//tr[14]/td[2]")
    private WebElement countryBilling;
    @FindBy(xpath = "//tr[16]/td[2]")
    private WebElement firstNameShipping;
    @FindBy(xpath = "//tr[17]/td[2]")
    private WebElement lastNameShipping;
    @FindBy(xpath = "//tr[18]/td[2]")
    private WebElement address1Shipping;
    @FindBy(xpath = "//tr[19]/td[2]")
    private WebElement address2Shipping;
    @FindBy(xpath = "//tr[20]/td[2]")
    private WebElement cityShipping;
    @FindBy(xpath = "//tr[21]/td[2]")
    private WebElement stateShipping;
    @FindBy(xpath = "//tr[22]/td[2]")
    private WebElement zipShipping;
    @FindBy(xpath = "//tr[23]/td[2]")
    private WebElement countryShipping;
    @FindBy(xpath = "//tr[26]/td[1]/table/tbody/tr[2]/td[3]")
    private WebElement quantity;
    @FindBy(xpath = "//tr[26]/td[1]/table/tbody/tr[2]/td[4]")
    private WebElement price;
    @FindBy(xpath = "//tr[26]/td[1]/table/tbody/tr[2]/td[5]")
    private WebElement totalPrice;


    public String takeFirstNameBillingValueFromOrderConfirmation() {
        waitForVisibility(firstNameBilling);
        return firstNameBilling.getText();
    }

    public String takeLastNameBillingValueFromOrderConfirmation() {
        waitForVisibility(lastNameBilling);
        return lastNameBilling.getText();
    }
    public String takeAddress1BillingValueFromOrderConfirmation() {
        waitForVisibility(address1Billing);
        return address1Billing.getText();
    }
    public String takeAddress2BillingValueFromOrderConfirmation() {
        waitForVisibility(address2Billing);
        return address2Billing.getText();
    }
    public String takeCityBillingValueFromOrderConfirmation() {
        waitForVisibility(cityBilling);
        return cityBilling.getText();
    }
    public String takeStateBillingValueFromOrderConfirmation() {
        waitForVisibility(stateBilling);
        return stateBilling.getText();
    }

    public String takeZipBillingValueFromOrderConfirmation() {
        waitForVisibility(zipBilling);
        return zipBilling.getText();
    }
    public String takeCountryBillingValueFromOrderConfirmation() {
        waitForVisibility(countryBilling);
        return countryBilling.getText();
    }


    public String takeFirstNameShippingValueFromOrderConfirmation() {
        waitForVisibility(firstNameShipping);
        return firstNameShipping.getText();
    }

    public String takeLastNameShippingValueFromOrderConfirmation() {
        waitForVisibility(lastNameShipping);
        return lastNameShipping.getText();
    }
    public String takeAddress1ShippingValueFromOrderConfirmation() {
        waitForVisibility(address1Shipping);
        return address1Shipping.getText();
    }
    public String takeAddress2ShippingValueFromOrderConfirmation() {
        waitForVisibility(address2Shipping);
        return address2Shipping.getText();
    }
    public String takeCityShippingValueFromOrderConfirmation() {
        waitForVisibility(cityShipping);
        return cityShipping.getText();
    }
    public String takeStateShippingValueFromOrderConfirmation() {
        waitForVisibility(stateShipping);
        return stateShipping.getText();
    }

    public String takeZipShippingValueFromOrderConfirmation() {
        waitForVisibility(zipShipping);
        return zipShipping.getText();
    }
    public String takeCountryShippingValueFromOrderConfirmation() {
        waitForVisibility(countryShipping);
        return countryShipping.getText();
    }
    public String takeQuantityValueFromOrderConfirmation() {
        waitForVisibility(quantity);
        return quantity.getText();
    }
    public String takePriceValueFromOrderConfirmation() {
        waitForVisibility(price);
        return price.getText();
    }
    public String takeTotalPriceValueFromOrderConfirmation() {
        waitForVisibility(totalPrice);
        return totalPrice.getText();
    }

}
