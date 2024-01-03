package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "//tbody/tr[3]/td[2]")
    private WebElement firstNameBilling;
    @FindBy(css = "//tbody/tr[4]/td[2]")
    private WebElement lastNameBilling;
    @FindBy(css = "//tbody/tr[5]/td[2]")
    private WebElement address1Billing;
    @FindBy(css = "//tbody/tr[6]/td[2]")
    private WebElement address2Billing;
    @FindBy(css = "//tbody/tr[7]/td[2]")
    private WebElement cityBilling;
    @FindBy(css = "//tbody/tr[8]/td[2]")
    private WebElement stateBilling;
    @FindBy(css = "//tbody/tr[9]/td[2]")
    private WebElement zipBilling;
    @FindBy(css = "//tbody/tr[10]/td[2]")
    private WebElement countryBilling;
    @FindBy(css = "//tbody/tr[12]/td[2]")
    private WebElement firstNameShipping;
    @FindBy(css = "//tbody/tr[13]/td[2]")
    private WebElement lastNameShipping;
    @FindBy(css = "//tbody/tr[14]/td[2]")
    private WebElement address1Shipping;
    @FindBy(css = "//tbody/tr[15]/td[2]")
    private WebElement address2Shipping;
    @FindBy(css = "//tbody/tr[16]/td[2]")
    private WebElement cityShipping;
    @FindBy(css = "//tbody/tr[17]/td[2]")
    private WebElement stateShipping;
    @FindBy(css = "//tbody/tr[18]/td[2]")
    private WebElement zipShipping;
    @FindBy(css = "//tbody/tr[19]/td[2]")
    private WebElement countryShipping;

    public String takeFirstNameBillingValueFromCheckout() {
        waitForVisibility(firstNameBilling);
        return firstNameBilling.getText();
    }

    public String takeLastNameBillingValueFromCheckout() {
        waitForVisibility(lastNameBilling);
        return lastNameBilling.getText();
    }
    public String takeAddress1BillingValueFromCheckout() {
        waitForVisibility(address1Billing);
        return address1Billing.getText();
    }
    public String takeAddress2BillingValueFromCheckout() {
        waitForVisibility(address2Billing);
        return address2Billing.getText();
    }
    public String takeCityBillingValueFromCheckout() {
        waitForVisibility(cityBilling);
        return cityBilling.getText();
    }
    public String takeStateBillingValueFromCheckout() {
        waitForVisibility(stateBilling);
        return stateBilling.getText();
    }

    public String takeZipBillingValueFromCheckout() {
        waitForVisibility(zipBilling);
        return zipBilling.getText();
    }
    public String takeCountryBillingValueFromCheckout() {
        waitForVisibility(countryBilling);
        return countryBilling.getText();
    }


    public String takeFirstNameShippingValueFromCheckout() {
        waitForVisibility(firstNameShipping);
        return firstNameShipping.getText();
    }

    public String takeLastNameShippingValueFromCheckout() {
        waitForVisibility(lastNameShipping);
        return lastNameShipping.getText();
    }
    public String takeAddress1ShippingValueFromCheckout() {
        waitForVisibility(address1Shipping);
        return address1Shipping.getText();
    }
    public String takeAddress2ShippingValueFromCheckout() {
        waitForVisibility(address2Shipping);
        return address2Shipping.getText();
    }
    public String takeCityShippingValueFromCheckout() {
        waitForVisibility(cityShipping);
        return cityShipping.getText();
    }
    public String takeStateShippingValueFromCheckout() {
        waitForVisibility(stateShipping);
        return stateShipping.getText();
    }

    public String takeZipShippingValueFromCheckout() {
        waitForVisibility(zipShipping);
        return zipShipping.getText();
    }
    public String takeCountryShippingValueFromCheckout() {
        waitForVisibility(countryShipping);
        return countryShipping.getText();
    }


    }
