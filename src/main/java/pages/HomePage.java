package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends  BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Sign In']" )
    private WebElement signInButton;
    @FindBy(xpath = "//div[@id='SidebarContent']/a/img" )
    private List<WebElement> menuCategoryList;


    public void clickOnSignIn(){
        waitForVisibility(signInButton);
        clickOnElement(signInButton);
    }

    public void openCategory(String category){
        switch(category){
            case "fish":
                WebElement fishOption = menuCategoryList.stream().filter(element -> element.getAttribute("src").contains("fish")).findAny().orElse(null);
                clickOnElement(fishOption);
                wait.until(ExpectedConditions.urlContains("FISH"));
                log.info("Fish option was found and clicked");
                break;
            case "dogs":
                WebElement dogsOption = menuCategoryList.stream().filter(element -> element.getAttribute("src").contains("dogs")).findAny().orElse(null);
                clickOnElement(dogsOption);
                wait.until(ExpectedConditions.urlContains("DOGS"));
                log.info("Dogs option was found and clicked");
                break;
            case "cats":
                WebElement catsOption = menuCategoryList.stream().filter(element -> element.getAttribute("src").contains("cats")).findAny().orElse(null);
                clickOnElement(catsOption);
                wait.until(ExpectedConditions.urlContains("CATS"));
                log.info("Cats option was found and clicked");
                break;
            case "reptiles":
                WebElement reptilesOption = menuCategoryList.stream().filter(element -> element.getAttribute("src").contains("reptiles")).findAny().orElse(null);
                clickOnElement(reptilesOption);
                wait.until(ExpectedConditions.urlContains("REPTILES"));
                log.info("Reptiles option was found and clicked");
                break;
            case "birds":
                WebElement birdsOption = menuCategoryList.stream().filter(element -> element.getAttribute("src").contains("birds")).findAny().orElse(null);
                clickOnElement(birdsOption);
                wait.until(ExpectedConditions.urlContains("BIRDS"));
                log.info("birds option was found and clicked");
                break;
            default:
                log.info("Given option does not exist");
        }

    }

}
