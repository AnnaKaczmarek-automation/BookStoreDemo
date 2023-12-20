package pages;

import helpers.DataCreator;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class RegisterFormPage extends BasePage {
    public RegisterFormPage(WebDriver driver) {
        super(driver);
    }
    DataCreator dataCreator = new DataCreator();

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userIdField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='repeatedPassword']")
    private WebElement repeatPasswordField;
    Logger log = LoggerFactory.getLogger("RegisterPage.class");
    @FindBy(xpath = "//input[@name='account.firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='account.lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='account.email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='account.phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@name='account.address1']")
    private WebElement address1Field;
    @FindBy(xpath = "//input[@name='account.address2']")
    private WebElement address2Field;
    @FindBy(xpath = "//input[@name='account.city']")
    private WebElement cityField;
    @FindBy(xpath = "//input[@name='account.state']")
    private WebElement stateField;
    @FindBy(xpath = "//input[@name='account.zip']")
    private WebElement zipField;
    @FindBy(xpath = "//input[@name='account.country']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@value='Save Account Information']")
    private WebElement saveAccountInformationButton;
    @FindBy(xpath = "//select[@name='account.languagePreference']")
    private WebElement languagePreferenceField;
    @FindBy(xpath = "//select[@name='account.favouriteCategoryId']")
    private WebElement favouriteCategoryField;
    @FindBy(xpath = "//select[@name='account.favouriteCategoryId']/option")
    private List<WebElement> favouriteCategoryOptionList;
    @FindBy(xpath = "//input[@name='account.listOption']")
    private WebElement enableMyListField;
    @FindBy(xpath = "//input[@name='account.bannerOption']")
    private WebElement enableMyBannerField;


    public RegisterFormPage fillInTheRegisterForm(String language, boolean enableMyList, boolean enableMyBanner) throws InterruptedException {
        passUserInformationToTheForm();
        passAccountInformationToTheForm();
        passProfileInformationToTheForm(language, enableMyList, enableMyBanner);
        return this;
    }


    private void passUserInformationToTheForm() {
        String userId = dataCreator.createRandomIdNumber();
        waitUntilElementIsClickable(userIdField);
        sendTextToField(userIdField, userId);
        log.info("user ID was typed in");
        String password = dataCreator.createRandomPassword();
        waitForVisibility(newPasswordField);
        sendTextToField(newPasswordField, password);
        log.info("new password was typed in");
        waitForVisibility(repeatPasswordField);
        sendTextToField(repeatPasswordField, password);
        log.info("repeated password was typed in");
    }

    private void passAccountInformationToTheForm() {
        String firstName = dataCreator.createRandomFirstName();
        String lastName = dataCreator.createRandomLastName();
        String email = dataCreator.createRandomEmail(firstName);
        String phone = String.valueOf(dataCreator.createRandomPhoneNumber());
        String street = String.valueOf(dataCreator.createRandomStreet());
        String streetNumber = String.valueOf(dataCreator.createRandomStreetNumber());
        String city = String.valueOf(dataCreator.createRandomCity());
        String state = String.valueOf(dataCreator.createRandomState());
        String zipCode = String.valueOf(dataCreator.createRandomZipCode());
        String country = String.valueOf(dataCreator.createRandomCountry());


        waitForVisibility(firstNameField);
        sendTextToField(firstNameField, firstName);
        log.info("First name was set");

        waitForVisibility(lastNameField);
        sendTextToField(lastNameField, lastName);
        log.info("Last name was set");

        waitForVisibility(emailField);
        sendTextToField(emailField, email);
        log.info("Email name was set");

        waitForVisibility(phoneField);
        sendTextToField(phoneField, phone);
        log.info("Phone number name was set");

        waitForVisibility(address1Field);
        sendTextToField(address1Field, street);
        log.info("Street name was set");

        waitForVisibility(address2Field);
        sendTextToField(address2Field, streetNumber);
        log.info("Street number was set");

        waitForVisibility(cityField);
        sendTextToField(cityField, city);
        log.info("City value was set");

        waitForVisibility(stateField);
        sendTextToField(stateField, state);
        log.info("State value was set");

        waitForVisibility(zipField);
        sendTextToField(zipField, zipCode);
        log.info("Zip code value was set");

        waitForVisibility(countryField);
        sendTextToField(countryField, country);
        log.info("Country value was set");
    }

    private void passProfileInformationToTheForm(String language, boolean enableMyList, boolean enableMyBanner) {
        selectLanguagePreference(language);
        selectFavouriteCategory();
        selectEnableMyListOption(enableMyList);
        selectEnableMyBannerOption(enableMyBanner);
    }

    private void selectLanguagePreference(String language){
        Select select = new Select(languagePreferenceField);
        if (language.equalsIgnoreCase(" english")) {
            select.selectByValue("english");
            log.info("English language option was chosen");
        }
        if (language.equalsIgnoreCase(" japanese")) {
            select.selectByValue("japanese");
            log.info("Japanese language option was chosen");
        }
    }

    public void selectFavouriteCategory(){
        Select selectCategory = new Select(favouriteCategoryField);
        int index = dataCreator.createRandomNumber(0,  favouriteCategoryOptionList.size() - 1);
        selectCategory.selectByValue(favouriteCategoryOptionList.get(index).getAttribute("value"));
        log.info("Favourite category was chosen");
    }

    private void selectEnableMyListOption(boolean enableMyList){
        if(enableMyList){
            waitForVisibility(enableMyListField);
            clickOnElement(enableMyListField);
            log.info("Option for 'Enable my list' field was chosen");
        }
    }

    private void selectEnableMyBannerOption(boolean enableMyBanner){
        if(enableMyBanner){
            waitForVisibility(enableMyBannerField);
            clickOnElement(enableMyBannerField);
            log.info("Option for 'Enable my banner' field was chosen");
        }
    }
    public void saveAccountInformation() {
        try {
            scrollUntilVisible(driver, saveAccountInformationButton);
            waitUntilElementIsClickable(saveAccountInformationButton);
            clickOnElement(saveAccountInformationButton);
            log.info("Account information was saved");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
