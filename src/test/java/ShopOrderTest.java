import model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class ShopOrderTest extends TestBase {
    protected HomePage homePage;
    protected FishCategoryPage fishCategoryPage;
    protected DogsCategoryPage dogsCategoryPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CatsCategoryPage catsCategoryPage;


    @Test
    public void addingProductsToTheCartTest() throws InterruptedException {
        homePage = new HomePage(driver);
        fishCategoryPage = new FishCategoryPage(driver);
        dogsCategoryPage = new DogsCategoryPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        catsCategoryPage = new CatsCategoryPage(driver);

        Logger log = LoggerFactory.getLogger("ShopOrderTest.class");

        List<Product> shoppingList = new ArrayList<>();
        homePage.openCategory("fish");
        fishCategoryPage.chooseRandomFish();
        double initialFishTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        shoppingCartPage.setRandomProductQuantity(shoppingList);
        double updatedFishTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedFishTotalCost).isGreaterThan(initialFishTotalCost);
        Product fish = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(fish);
        log.info("fish was added to the shopping list");
        shoppingCartPage.returnToMainMenu();


        homePage.openCategory("dogs");
        dogsCategoryPage.chooseRandomDog();
        double initialDogTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        shoppingCartPage.setRandomProductQuantity(shoppingList);
        double updatedDogTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedDogTotalCost).isGreaterThan(initialDogTotalCost);
        Product dog = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(dog);
        log.info("dog was added to the shopping list");
        shoppingCartPage.returnToMainMenu();

        homePage.openCategory("cats");
        catsCategoryPage.chooseRandomCat();
        double initialCatTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        shoppingCartPage.setRandomProductQuantity(shoppingList);
        double updatedCatTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedCatTotalCost).isGreaterThan(initialCatTotalCost);
        Product cat = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(cat);
        log.info("cat was added to the shopping list");
        shoppingCartPage.returnToMainMenu();
    }
}
