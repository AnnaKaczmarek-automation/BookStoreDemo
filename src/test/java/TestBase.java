import browser.BrowsersTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import java.io.IOException;

public class TestBase {
    protected static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static ApplicationProperties applicationProperties;
    protected static DriverFactory driverFactory;
    protected static BasePage basePage;

    @BeforeAll
    static void beforeAll(){
        applicationProperties = new ApplicationProperties();
    }

    @BeforeEach
    void beforeEach() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        basePage = new BasePage(driver);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        log.info("***** Driver closed *****");
    }
}