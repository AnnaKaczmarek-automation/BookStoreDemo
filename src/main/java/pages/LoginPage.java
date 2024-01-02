package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='signon']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Register Now!']")
    private WebElement registerNowButton;

    public void logIn(){
        waitForVisibility(userNameField);
        sendTextToField(userNameField, System.getProperty("userName"));
        log.info("User name was typed in");
        sendTextToField(passwordField, System.getProperty("password"));
        log.info("Password was typed in");
        waitForVisibility(loginButton);
        clickOnElement(loginButton);
        log.info("Login button was clicked");
    }

    public void chooseRegisterNowOption(){
        waitForVisibility(registerNowButton);
        clickOnElement(registerNowButton);
        wait.until(ExpectedConditions.urlToBe("https://petstore.octoperf.com/actions/Account.action?newAccountForm="));
    }
}
