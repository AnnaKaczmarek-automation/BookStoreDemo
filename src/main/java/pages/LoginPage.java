package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#userName")
    private WebElement userNameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#newUser")
    private WebElement newUserButton;

    public void clickOnNewUserButton() {
        waitForVisibility(newUserButton);
        clickOnElement(newUserButton);
    }
}
