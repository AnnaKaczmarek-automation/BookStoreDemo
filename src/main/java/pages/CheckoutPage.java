package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='newOrder']")
    private WebElement continueButton;
    @FindBy(css = "[name='order.cardType']")
    private WebElement cardTypeField;
    @FindBy(css = "[name='order.cardType'] option[selected='selected']")
    private WebElement selectedCardTypeValue;
    @FindBy(css = "[name='order.creditCard']")
    private WebElement cardNumberField;
    @FindBy(css = "[name='order.expiryDate']")
    private WebElement expireDateField;

    @FindBy(css = "[name='order.billToFirstName']")
    private WebElement firstName;
    @FindBy(css = "[name='order.billToLastName']")
    private WebElement lastName;
    @FindBy(css = "[name='order.billAddress1']")
    private WebElement address1;
    @FindBy(css = "[name='order.billAddress2']")
    private WebElement address2;
    @FindBy(css = "[name='order.billCity']")
    private WebElement city;
    @FindBy(css = "[name='order.billState']")
    private WebElement state;
    @FindBy(css = "[name='order.billZip']")
    private WebElement zip;
    @FindBy(css = "[name='order.billCountry']")
    private WebElement country;

    @FindBy(css = "[name='order.shipToFirstName']")
    private WebElement shipToFirstName;
    @FindBy(css = "[name='order.shipToLastName']")
    private WebElement shipToLastName;
    @FindBy(css = "[name='order.shipAddress1']")
    private WebElement shipAddress1;
    @FindBy(css = "[name='order.shipAddress2']")
    private WebElement shipAddress2;
    @FindBy(css = "[name='order.shipCity']")
    private WebElement shipCity;
    @FindBy(css = "[name='order.shipState']")
    private WebElement shipState;
    @FindBy(css = "[name='order.shipZip']")
    private WebElement shipZip;
    @FindBy(css = "[name='order.shipCountry']")
    private WebElement shipCountry;

    @FindBy(css = "[name='shippingAddressRequired']")
    private WebElement shipToDifferentAddressCheckbox;

    public void choseContinueButton() {
        waitUntilElementIsClickable(continueButton);
        clickOnElement(continueButton);
        log.info("'Continue' button was clicked");
        wait.until(ExpectedConditions.urlContains("Order.action"));

    }

    public void insertCardType(String cardType) {
        Select select = new Select(cardTypeField);
        waitUntilElementIsClickable(cardTypeField);
        clickOnElement(cardTypeField);
        if (cardType.equalsIgnoreCase("Visa")) {
            select.selectByValue("Visa");
            actions.sendKeys(Keys.ENTER).build().perform();
            actions.sendKeys(Keys.ESCAPE).build().perform();
            log.info("Visa card was chosen");
        }
        if (cardType.equalsIgnoreCase("MasterCard")) {
            select.selectByValue("MasterCard");
            actions.sendKeys(Keys.ENTER).build().perform();
            actions.sendKeys(Keys.ESCAPE).build().perform();
            log.info("MasterCard card was chosen");
        }
        if (cardType.equalsIgnoreCase("AmericanExpress")) {
            select.selectByValue("AmericanExpress");
            actions.sendKeys(Keys.ENTER).build().perform();
            actions.sendKeys(Keys.ESCAPE).build().perform();
            log.info("AmericanExpress card was chosen");
        }
    }

    public String takeCardTypeValue() {
        waitForVisibility(selectedCardTypeValue);
        return selectedCardTypeValue.getText();
    }

    public String takeCardNumberValue() {
        waitForVisibility(cardNumberField);
        return cardNumberField.getAttribute("value");
    }

    public String takeExpiryDateValue() {
        waitForVisibility(expireDateField);
        return expireDateField.getAttribute("value");
    }

    public void insertCardNumberValue() {
        waitForVisibility(cardNumberField);
        sendTextToField(cardNumberField, System.getProperty("cardNumber"));
        log.info("Card number value was typed in");
    }

    public void insertExpireDateValue() {
        waitForVisibility(expireDateField);
        sendTextToField(expireDateField, System.getProperty("expiryDate"));
        log.info("Expire date value was typed in");
    }

    public String takeFirstNameValueFromCheckout() {
        waitForVisibility(firstName);
        return firstName.getAttribute("value");
    }

    public String takeLastNameValueFromCheckout() {
        waitForVisibility(lastName);
        return lastName.getAttribute("value");
    }

    public String takeAddress1ValueFromCheckout() {
        waitForVisibility(address1);
        return address1.getAttribute("value");
    }

    public String takeAddress2ValueFromCheckout() {
        waitForVisibility(address2);
        return address2.getAttribute("value");
    }

    public String takeCityValueFromCheckout() {
        waitForVisibility(city);
        return city.getAttribute("value");
    }

    public String takeStateValueFromCheckout() {
        waitForVisibility(state);
        return state.getAttribute("value");
    }

    public String takeZipValueFromCheckout() {
        waitForVisibility(zip);
        return zip.getAttribute("value");
    }

    public String takeCountryValueFromCheckout() {
        waitForVisibility(country);
        return country.getAttribute("value");
    }

    public CheckoutPage markShipToDifferentAddressOption(){
        waitForVisibility(shipToDifferentAddressCheckbox);
        clickOnElement(shipToDifferentAddressCheckbox);
        log.info("Option to ship on a different address was marked");
        return this;
    }
    public CheckoutPage insertShippingFirstName() {
        waitForVisibility(shipToFirstName);
        sendTextToField(shipToFirstName, System.getProperty("shipToFirstName"));
        log.info("First Name for Shipping Address was typed in");
        return this;
    }
    public CheckoutPage insertShippingLastName() {
        waitForVisibility(shipToLastName);
        sendTextToField(shipToLastName, System.getProperty("shipToLastName"));
        log.info("Last Name for Shipping Address was typed in");
        return this;
    }
    public CheckoutPage insertShippingAddress1() {
        waitForVisibility(shipAddress1);
        sendTextToField(shipAddress1, System.getProperty("shipToAddress1"));
        log.info("Address 1 for Shipping Address was typed in");
        return this;
    }
    public CheckoutPage insertShippingAddress2() {
        waitForVisibility(shipAddress2);
        sendTextToField(shipAddress2, System.getProperty("shipToAddress2"));
        log.info("Address 2 for Shipping Address was typed in");
        return this;
    }
    public CheckoutPage insertShippingCity() {
        waitForVisibility(shipCity);
        sendTextToField(shipCity, System.getProperty("shipToCity"));
        log.info("City for Shipping Address was typed in");
        return this;
    }
    public CheckoutPage insertShippingState() {
        waitForVisibility(shipState);
        sendTextToField(shipState, System.getProperty("shipToState"));
        log.info("State for Shipping Address was typed in");
        return this;
    }
    public CheckoutPage insertShippingZip() {
        waitForVisibility(shipZip);
        sendTextToField(shipZip, System.getProperty("shipToZip"));
        log.info("Zip for Shipping Address was typed in");
        return this;
    }
    public void insertShippingCountry() {
        waitForVisibility(shipCountry);
        sendTextToField(shipCountry, System.getProperty("shipToCountry"));
        log.info("Country for Shipping Address was typed in");
    }
}
