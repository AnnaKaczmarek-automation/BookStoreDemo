import browser.Browser;
import model.Environment;

public class Configuration {
    private Environment environment;
    private Browser browser;

    public Configuration(Environment environment, Browser browsers) {
        this.environment = environment;
        this.browser = browsers;
    }

    public Configuration(){
    }

    public Browser getBrowser() {
        return browser;
    }

    public Environment getEnvironment() {
        return environment;
    }
}