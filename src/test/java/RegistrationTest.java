import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterFormPage;

public class RegistrationTest extends TestBase {
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterFormPage registerPage;
    Logger log = LoggerFactory.getLogger("RegistrationTest.class");

    @Test
    public void fillingRegistrationFormTest() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterFormPage(driver);

        homePage.clickOnSignIn();
        loginPage.chooseRegisterNowOption();
        registerPage.fillInTheRegisterForm("english", true, false)
                .saveAccountInformation();
    }
}
