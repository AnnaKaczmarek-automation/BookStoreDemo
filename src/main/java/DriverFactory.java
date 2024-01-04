import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    Logger log = LoggerFactory.getLogger("DriverFactory.class");
    private WebDriver driver;

    public DriverFactory() {
    }

    public WebDriver getDriver() {
        WebDriver driver;
//        switch (this.browserName) {
        switch (System.getProperty("browserName")) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                optionsChrome.addArguments("disable-infobars");
                optionsChrome.addArguments("--disable-extensions");
                optionsChrome.addArguments("disable-notifications");
                optionsChrome.addArguments("autofill.profile_enabled");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("autofill.profile_enabled", false);
                optionsChrome.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(optionsChrome);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                optionsFirefox.addArguments("disable-infobars");
                optionsFirefox.addArguments("--disable-extensions");
                optionsFirefox.addArguments("disable-notifications");
                optionsFirefox.addArguments("autofill.profile_enabled");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(System.getProperty("appUrl"));
                break;
            default:
                InternetExplorerOptions optionsdefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsdefault);
                driver.get(System.getProperty("appUrl"));
        }
        this.driver = driver;
        return this.driver;
    }


//    public void setPropertiesValuesForBrowserFromYamlFileToSystem() {
////        YamlReader yamlReader = new YamlReader();
//////        List<BrowsersTemplate> listOfBrowsers = yamlReader.getConfiguration().getBrowser();
////        boolean isActive = false;
////        for (BrowsersTemplate browsers : listOfBrowsers) {
////            if (browsers.isActive() == true) {
////                isActive = true;
////                Map<String, Object> browserProperties = browsers.getProperties();
////                log.info("Amount of loaded browser properties is: " + browserProperties.size());
////                for (Map.Entry entry : browserProperties.entrySet()) {
////                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
////                }
////            }
////            break;
////        }
////        if (isActive == false) {
////            setSampleValuesForBrowserProperties();
////        }
//    }

    private void setSampleValuesForBrowserProperties() {
        YamlReader yamlReader = new YamlReader();
        Map<String, Object> browserProperties = yamlReader.getConfiguration().getBrowser().getProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.getProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
