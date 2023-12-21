package pages;

import helpers.DataCreator;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    DataCreator dataCreator = new DataCreator();
    @FindBy(xpath = "//a[text()='Add to Cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//input[contains(@name,'EST')]")
    private WebElement quantityInput;
    @FindBy(css = "[name='updateCartQuantities']")
    private WebElement updateCartButton;
    @FindBy(xpath = "//tr/td[7]")
    private WebElement totalCost;
    @FindBy(css = "#Cart")
    private WebElement shoppingCartSection;
    @FindBy(xpath = "//a[text()='Return to Main Menu']")
    private WebElement returnToMainMenuButton;
    @FindBy(xpath = "//tr/td/a[contains(@href,'viewItem')]")
    private WebElement itemIdField;
    @FindBy(xpath = "//tr/td[2]")
    private WebElement productIdField;
    @FindBy(xpath = "//tr/td[3]")
    private WebElement descriptionField;
    @FindBy(xpath = "//tr/td[4]")
    private WebElement inStockField;
    @FindBy(xpath = "//tr/td[5]")
    private WebElement quantityField;
    @FindBy(xpath = "//tr/td[6]")
    private WebElement listPriceField;
    @FindBy(xpath = "//tr/td[7]")
    private WebElement totalCostField;


    public void setRandomProductQuantity(List<Product> shoppingList) throws InterruptedException {
        log.info("Shopping list has size: " + shoppingList.size());
        waitForVisibility(shoppingCartSection);
        int quantity = dataCreator.createRandomNumber(2, 10);
        WebElement quantityValue = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[5]/input"));
        waitForVisibility(quantityValue);
//        String oldValue1 = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[7]")).getText();
        sendTextToField(quantityValue, String.valueOf(quantity));
        actions.sendKeys(Keys.ENTER).build().perform();
        waitUntilElementIsClickable(updateCartButton);
        clickOnElement(updateCartButton);
        Thread.sleep(3000);
        log.info("Product amount was updated into --> " + quantityInput.getAttribute("value"));
    }

    public Float takeProductsTotalCost(List<Product> shoppingList) throws InterruptedException {
        float cost = Float.parseFloat(driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[7]")).getText().substring(1));
        log.info("Total Cost of particular product is --> " + cost);
        return cost;
    }

    public void returnToMainMenu() {
        waitUntilElementIsClickable(returnToMainMenuButton);
        clickOnElement(returnToMainMenuButton);
        wait.until(ExpectedConditions.urlContains("Catalog.action"));
    }

    public Product createNewProduct(List<Product> shoppingList) {
        log.info("shopping list size is: " + shoppingList.size());
        String itemID = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td/a[contains(@href,'viewItem')]")).getText();

        String productID =driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[2]")).getText();
        String description = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[3]")).getText();
        String inStock = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[4]")).getText();
        String quantity = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[5]")).getText();
        String listPrice = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[6]")).getText();
        String totalCoast = driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[7]")).getText();
        return new Product(itemID, productID, description, inStock, quantity, listPrice, totalCoast);
    }

    public float countSubTotalValue(float updatedFishTotalCost, float updatedDogTotalCost, float updatedCatTotalCost, float updatedReptileTotalCost, float updatedBirdTotalCost) {
        return updatedFishTotalCost + updatedDogTotalCost + updatedCatTotalCost + updatedReptileTotalCost + updatedBirdTotalCost;
    }

    public Float takeSubTotalValue(List<Product> shoppingList){
        return Float.parseFloat(driver.findElement(By.xpath("//tr[" + (shoppingList.size()+2) + "]/td[1]")).getText().substring(12));
    }
}
