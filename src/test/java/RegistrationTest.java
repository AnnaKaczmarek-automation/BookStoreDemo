import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegistrationTest extends TestBase {
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    Logger log = LoggerFactory.getLogger("RegistrationTest.class");

    @Test
    public void fillingRegistrationForm() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

        homePage.clickOnLoginButton();
        loginPage.clickOnNewUserButton();
        registerPage.fillInTheRegisterForm()
                .selectCaptcha()
                .clickOnRegisterButton();


    }
}
