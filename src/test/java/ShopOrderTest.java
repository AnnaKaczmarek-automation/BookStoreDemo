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
    protected ReptilesCategoryPage reptilesCategoryPage;
    protected BirdsCategoryPage birdsCategoryPage;
    protected LoginPage loginPage;
    protected CheckoutPage checkoutPage;
    protected OrderPage orderPage;


    @Test
    public void addingProductsToTheCartTest() throws InterruptedException {
        homePage = new HomePage(driver);
        fishCategoryPage = new FishCategoryPage(driver);
        dogsCategoryPage = new DogsCategoryPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        catsCategoryPage = new CatsCategoryPage(driver);
        reptilesCategoryPage = new ReptilesCategoryPage(driver);
        birdsCategoryPage = new BirdsCategoryPage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);

        Logger log = LoggerFactory.getLogger("ShopOrderTest.class");
        homePage.clickOnSignIn();
        loginPage.logIn();
        log.info("User was logged in");
        List<Product> shoppingList = new ArrayList<>();
        homePage.openCategory("fish");
        fishCategoryPage.chooseRandomFish();
        float initialFishTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        int quantityOfFish = shoppingCartPage.setRandomProductQuantity(shoppingList);
        float updatedFishTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedFishTotalCost).isEqualTo(initialFishTotalCost * quantityOfFish);
        Product fish = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(fish);
        log.info("fish was added to the shopping list");
        shoppingCartPage.returnToMainMenu();


        homePage.openCategory("dogs");
        dogsCategoryPage.chooseRandomDog();
        float initialDogTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        int quantityOfDog = shoppingCartPage.setRandomProductQuantity(shoppingList);
        float updatedDogTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedDogTotalCost).isEqualTo(initialDogTotalCost * quantityOfDog);
        Product dog = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(dog);
        log.info("dog was added to the shopping list");
        shoppingCartPage.returnToMainMenu();

        homePage.openCategory("cats");
        catsCategoryPage.chooseRandomCat();
        float initialCatTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        int quantityOfCat = shoppingCartPage.setRandomProductQuantity(shoppingList);
        float updatedCatTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedCatTotalCost).isEqualTo(initialCatTotalCost * quantityOfCat);
        Product cat = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(cat);
        log.info("cat was added to the shopping list");
        shoppingCartPage.returnToMainMenu();

        homePage.openCategory("reptiles");
        reptilesCategoryPage.chooseRandomReptile();
        float initialReptileTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        int quantityOfReptile = shoppingCartPage.setRandomProductQuantity(shoppingList);
        float updatedReptileTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedReptileTotalCost).isEqualTo(initialReptileTotalCost * quantityOfReptile);
        Product reptile = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(reptile);
        log.info("cat was added to the shopping list");
        shoppingCartPage.returnToMainMenu();

        homePage.openCategory("birds");
        birdsCategoryPage.chooseRandomBird();
        float initialBirdTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        int quantityOfBirds = shoppingCartPage.setRandomProductQuantity(shoppingList);
        float updatedBirdTotalCost = shoppingCartPage.takeProductsTotalCost(shoppingList);
        Assertions.assertThat(updatedBirdTotalCost).isEqualTo(initialBirdTotalCost * quantityOfBirds);
        Product bird = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(bird);
        log.info("cat was added to the shopping list");

        float expectedSubTotalValue = shoppingCartPage.countSubTotalValue(updatedFishTotalCost, updatedDogTotalCost, updatedCatTotalCost, updatedReptileTotalCost, updatedBirdTotalCost);
        float actualSubTotalValue = shoppingCartPage.takeSubTotalValue(shoppingList);
        Assertions.assertThat(actualSubTotalValue).isEqualTo(expectedSubTotalValue);
    }

    @Test
    public void checkoutTest() throws InterruptedException {
        homePage = new HomePage(driver);
        fishCategoryPage = new FishCategoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        orderPage = new OrderPage(driver);

        Logger log = LoggerFactory.getLogger("ShopOrderTest.class");
        homePage.clickOnSignIn();
        loginPage.logIn();
        log.info("User was logged in");
        homePage.openCategory("fish");
        fishCategoryPage.chooseRandomFish();

        shoppingCartPage.proceedToCheckout();
        checkoutPage.insertCardType(System.getProperty("cardType"));
        checkoutPage.insertCardNumberValue();
        Assertions.assertThat(checkoutPage.takeCardNumberValue()).isEqualTo(System.getProperty("cardNumber"));
        checkoutPage.insertExpireDateValue();
        Assertions.assertThat(checkoutPage.takeExpiryDateValue()).isEqualTo(System.getProperty("expiryDate"));
        Assertions.assertThat(checkoutPage.takeFirstNameValueFromCheckout()).isEqualTo(System.getProperty("firstName"));
        Assertions.assertThat(checkoutPage.takeLastNameValueFromCheckout()).isEqualTo(System.getProperty("lastName"));
        Assertions.assertThat(checkoutPage.takeAddress1ValueFromCheckout()).isEqualTo(System.getProperty("address1"));
        Assertions.assertThat(checkoutPage.takeAddress2ValueFromCheckout()).isEqualTo(System.getProperty("address2"));
        Assertions.assertThat(checkoutPage.takeCityValueFromCheckout()).isEqualTo(System.getProperty("city"));
        Assertions.assertThat(checkoutPage.takeStateValueFromCheckout()).isEqualTo(System.getProperty("state"));
        Assertions.assertThat(checkoutPage.takeZipValueFromCheckout()).isEqualTo(System.getProperty("zip"));
        Assertions.assertThat(checkoutPage.takeCountryValueFromCheckout()).isEqualTo(System.getProperty("country"));

        if (Boolean.parseBoolean(System.getProperty("shippingAddress"))) {
            checkoutPage.markShipToDifferentAddressOption();

            checkoutPage.choseContinueButton();
            checkoutPage.insertShippingFirstName()
                    .insertShippingLastName()
                    .insertShippingAddress1()
                    .insertShippingAddress2()
                    .insertShippingCity()
                    .insertShippingState()
                    .insertShippingZip()
                    .insertShippingCountry();
            checkoutPage.choseContinueButton();
            basePage.waitUntilUrlContainsText("Order.action");
            //pojawia sie windowsowy pop-up. trzeba go zamknąć.
            Assertions.assertThat(orderPage.takeFirstNameBillingValueFromCheckout()).isEqualTo(System.getProperty("firstName"));
            Assertions.assertThat(orderPage.takeLastNameBillingValueFromCheckout()).isEqualTo(System.getProperty("lastName"));
            Assertions.assertThat(orderPage.takeAddress1BillingValueFromCheckout()).isEqualTo(System.getProperty("address1"));
            Assertions.assertThat(orderPage.takeAddress2BillingValueFromCheckout()).isEqualTo(System.getProperty("address2"));
            Assertions.assertThat(orderPage.takeCityBillingValueFromCheckout()).isEqualTo(System.getProperty("city"));
            Assertions.assertThat(orderPage.takeStateBillingValueFromCheckout()).isEqualTo(System.getProperty("state"));
            Assertions.assertThat(orderPage.takeZipBillingValueFromCheckout()).isEqualTo(System.getProperty("zip"));
            Assertions.assertThat(orderPage.takeCountryBillingValueFromCheckout()).isEqualTo(System.getProperty("country"));

            Assertions.assertThat(orderPage.takeFirstNameShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToFirstName"));
            Assertions.assertThat(orderPage.takeLastNameShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToLastName"));
            Assertions.assertThat(orderPage.takeAddress1ShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToAddress1"));
            Assertions.assertThat(orderPage.takeAddress2ShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToAddress2"));
            Assertions.assertThat(orderPage.takeCityShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToCity"));
            Assertions.assertThat(orderPage.takeStateShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToState"));
            Assertions.assertThat(orderPage.takeZipShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToZip"));
            Assertions.assertThat(orderPage.takeCountryShippingValueFromCheckout()).isEqualTo(System.getProperty("shipToCountry"));
        }else{
            checkoutPage.choseContinueButton();
            Assertions.assertThat(orderPage.takeFirstNameBillingValueFromCheckout()).isEqualTo(System.getProperty("firstName"));
            Assertions.assertThat(orderPage.takeLastNameBillingValueFromCheckout()).isEqualTo(System.getProperty("lastName"));
            Assertions.assertThat(orderPage.takeAddress1BillingValueFromCheckout()).isEqualTo(System.getProperty("address1"));
            Assertions.assertThat(orderPage.takeAddress2BillingValueFromCheckout()).isEqualTo(System.getProperty("address2"));
            Assertions.assertThat(orderPage.takeCityBillingValueFromCheckout()).isEqualTo(System.getProperty("city"));
            Assertions.assertThat(orderPage.takeStateBillingValueFromCheckout()).isEqualTo(System.getProperty("state"));
            Assertions.assertThat(orderPage.takeZipBillingValueFromCheckout()).isEqualTo(System.getProperty("zip"));
            Assertions.assertThat(orderPage.takeCountryBillingValueFromCheckout()).isEqualTo(System.getProperty("country"));
        }


    }


}
