package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends  BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#firstname")
    private WebElement firstNameField;

    @FindBy(css = "#lastname")
    private WebElement lastNameField;

    @FindBy(css = "#userName")
    private WebElement userNameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#recaptcha-anchor")
    private WebElement captchaField;

    @FindBy(css = "#register")
    private WebElement registerButton;

    public RegisterPage fillInTheRegisterForm(){
        waitForVisibility(firstNameField);
        String firstName = createRandomFirstName();
        sendTextToField(firstNameField, firstName);

        waitForVisibility(lastNameField);
        String lastName = createRandomLastName();
        sendTextToField(lastNameField, lastName);

        waitForVisibility(userNameField);
        String userName = createRandomFullName();
        sendTextToField(userNameField, userName);

        waitForVisibility(passwordField);
        String password = createRandomPassword();
        sendTextToField(passwordField, password);
        return this;
    }

    public RegisterPage selectCaptcha(){
    waitForVisibility(captchaField);
    clickOnElement(captchaField);
    return this;
    }

    public void clickOnRegisterButton(){
    waitForVisibility(registerButton);
    clickOnElement(registerButton);
    }

}
