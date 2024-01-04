package pages;

import com.github.javafaker.Faker;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    Logger log = LoggerFactory.getLogger("BasePage.class");

    @FindBy(xpath = "//iframe[@title='3rd party ad content']")
    private List<WebElement> adsList;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        waitForVisibility(element);
        highlightElements(element);
        element.click();
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsClickable(WebElement element) {
        highlightElements(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void sendTextToField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        log.info("Alert was accepted");
    }

    public void declineAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        log.info("Alert was declined");
    }

    public String takeTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void scrollUntilVisible(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!isDisplayed(element)) {
            js.executeScript("window.scrollBy(0,50)");
            log.info("Page is scrolled down by 50px");
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeAllAds() {
        try {
            if (adsList.stream().allMatch(WebElement::isDisplayed)) {
                log.info("Adverts are displayed");
                for (WebElement element : adsList) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].style.visibility='hidden'", element);
                    log.info("aria hidden attribute was set to 'false'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String takeWebElementText(WebElement element) {
        return element.getText();
    }

    public void highlightElements(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red;')", element);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilUrlContainsText(String text){
        wait.until(ExpectedConditions.urlContains(text));
        log.info("URL contains correct text");
        driver.switchTo().defaultContent();
    }

}