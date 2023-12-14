package pages;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Random;

public class BasePage{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
     private final Faker faker = new Faker();

    Logger log = LoggerFactory.getLogger("BasePage.class");


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

    public void sendTextToField(WebElement field, String text){
        field.clear();
        field.sendKeys(text);
    }

    public Integer createRandomListIndex(List<WebElement> webElementList){
        Random rand = new Random();
        return rand.nextInt(webElementList.size());
    }

    public String createRandomPassword(){
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
//        String password = RandomStringUtils.random(length, useLetters, useNumbers);
        String password = RandomStringUtils.randomAscii(8);
        return password;
    }
    public String createRandomFirstName(){
        return faker.name().firstName();
    }

    public String createRandomLastName(){
        return faker.name().lastName();
    }

    public String createRandomFullName(){
        return faker.name().fullName();
    }

    public String takeTextFromAlert(){
        String result = driver.switchTo().alert().getText();
        return result;
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void scrollUntilVisible(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!isDisplayed(element)) {
            js.executeScript("window.scrollBy(0,250)");
            log.info("Page is scrolled down by 250px");
        }
    }
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String takeWebElementText(WebElement element) {
        String value = element.getText();
        return value;
    }

    public void highlightElements(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red;')", element);
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}