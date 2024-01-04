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
    protected OrderConfirmationPage orderConfirmationPage;


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
    public void checkoutTest() {
        homePage = new HomePage(driver);
        fishCategoryPage = new FishCategoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        orderPage = new OrderPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);

        Logger log = LoggerFactory.getLogger("ShopOrderTest.class");
        homePage.clickOnSignIn();
        loginPage.logIn();
        log.info("User was logged in");
        homePage.openCategory("fish");
        fishCategoryPage.chooseRandomFish();
        List<Product> shoppingList = new ArrayList<>();
        Product fish = shoppingCartPage.createNewProduct(shoppingList);
        shoppingList.add(fish);
        log.info("list size: " + shoppingList.size());
        int quantityInShoppingCart = shoppingCartPage.takeProductsQuantity();
        float totalPriceInShoppingCart = shoppingCartPage.takeSubTotalValue(shoppingList);

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

        String firstNameBillingValueFromCheckout;
        String lastNameBillingValueFromCheckout;
        String address1BillingValueFromCheckout;
        String address2BillingValueFromCheckout;
        String cityBillingValueFromCheckout;
        String stateBillingValueFromCheckout;
        String zipBillingValueFromCheckout;
        String countryBillingValueFromCheckout;
        String firstNameShippingValueFromCheckout = null;
        String lastNameShippingValueFromCheckout = null;
        String address1ShippingValueFromCheckout = null;
        String address2ShippingValueFromCheckout = null;
        String cityShippingValueFromCheckout = null;
        String stateShippingValueFromCheckout = null;
        String zipShippingValueFromCheckout = null;
        String countryShippingValueFromCheckout = null;
        String orderHeaderInCheckout = null;

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
            orderHeaderInCheckout = orderPage.takeOrderHeaderValue();
            firstNameBillingValueFromCheckout = orderPage.takeFirstNameBillingValueFromCheckout();
            lastNameBillingValueFromCheckout = orderPage.takeLastNameBillingValueFromCheckout();
            address1BillingValueFromCheckout = orderPage.takeAddress1BillingValueFromCheckout();
            address2BillingValueFromCheckout = orderPage.takeAddress2BillingValueFromCheckout();
            cityBillingValueFromCheckout = orderPage.takeCityBillingValueFromCheckout();
            stateBillingValueFromCheckout = orderPage.takeStateBillingValueFromCheckout();
            zipBillingValueFromCheckout = orderPage.takeZipBillingValueFromCheckout();
            countryBillingValueFromCheckout = orderPage.takeCountryBillingValueFromCheckout();
            Assertions.assertThat(firstNameBillingValueFromCheckout).isEqualTo(System.getProperty("firstName"));
            Assertions.assertThat(lastNameBillingValueFromCheckout).isEqualTo(System.getProperty("lastName"));
            Assertions.assertThat(address1BillingValueFromCheckout).isEqualTo(System.getProperty("address1"));
            Assertions.assertThat(address2BillingValueFromCheckout).isEqualTo(System.getProperty("address2"));
            Assertions.assertThat(cityBillingValueFromCheckout).isEqualTo(System.getProperty("city"));
            Assertions.assertThat(stateBillingValueFromCheckout).isEqualTo(System.getProperty("state"));
            Assertions.assertThat(zipBillingValueFromCheckout).isEqualTo(System.getProperty("zip"));
            Assertions.assertThat(countryBillingValueFromCheckout).isEqualTo(System.getProperty("country"));

            firstNameShippingValueFromCheckout = orderPage.takeFirstNameShippingValueFromCheckout();
            lastNameShippingValueFromCheckout = orderPage.takeLastNameShippingValueFromCheckout();
            address1ShippingValueFromCheckout = orderPage.takeAddress1ShippingValueFromCheckout();
            address2ShippingValueFromCheckout = orderPage.takeAddress2ShippingValueFromCheckout();
            cityShippingValueFromCheckout = orderPage.takeCityShippingValueFromCheckout();
            stateShippingValueFromCheckout = orderPage.takeStateShippingValueFromCheckout();
            zipShippingValueFromCheckout = orderPage.takeZipShippingValueFromCheckout();
            countryShippingValueFromCheckout = orderPage.takeCountryShippingValueFromCheckout();
            Assertions.assertThat(firstNameShippingValueFromCheckout).isEqualTo(System.getProperty("shipToFirstName"));
            Assertions.assertThat(lastNameShippingValueFromCheckout).isEqualTo(System.getProperty("shipToLastName"));
            Assertions.assertThat(address1ShippingValueFromCheckout).isEqualTo(System.getProperty("shipToAddress1"));
            Assertions.assertThat(address2ShippingValueFromCheckout).isEqualTo(System.getProperty("shipToAddress2"));
            Assertions.assertThat(cityShippingValueFromCheckout).isEqualTo(System.getProperty("shipToCity"));
            Assertions.assertThat(stateShippingValueFromCheckout).isEqualTo(System.getProperty("shipToState"));
            Assertions.assertThat(zipShippingValueFromCheckout).isEqualTo(System.getProperty("shipToZip"));
            Assertions.assertThat(countryShippingValueFromCheckout).isEqualTo(System.getProperty("shipToCountry"));
        } else {
            checkoutPage.choseContinueButton();
            firstNameBillingValueFromCheckout = orderPage.takeFirstNameBillingValueFromCheckout();
            lastNameBillingValueFromCheckout = orderPage.takeLastNameBillingValueFromCheckout();
            address1BillingValueFromCheckout = orderPage.takeAddress1BillingValueFromCheckout();
            address2BillingValueFromCheckout = orderPage.takeAddress2BillingValueFromCheckout();
            cityBillingValueFromCheckout = orderPage.takeCityBillingValueFromCheckout();
            stateBillingValueFromCheckout = orderPage.takeStateBillingValueFromCheckout();
            zipBillingValueFromCheckout = orderPage.takeZipBillingValueFromCheckout();
            countryBillingValueFromCheckout = orderPage.takeCountryBillingValueFromCheckout();
            Assertions.assertThat(firstNameBillingValueFromCheckout).isEqualTo(System.getProperty("firstName"));
            Assertions.assertThat(lastNameBillingValueFromCheckout).isEqualTo(System.getProperty("lastName"));
            Assertions.assertThat(address1BillingValueFromCheckout).isEqualTo(System.getProperty("address1"));
            Assertions.assertThat(address2BillingValueFromCheckout).isEqualTo(System.getProperty("address2"));
            Assertions.assertThat(cityBillingValueFromCheckout).isEqualTo(System.getProperty("city"));
            Assertions.assertThat(stateBillingValueFromCheckout).isEqualTo(System.getProperty("state"));
            Assertions.assertThat(zipBillingValueFromCheckout).isEqualTo(System.getProperty("zip"));
            Assertions.assertThat(countryBillingValueFromCheckout).isEqualTo(System.getProperty("country"));
        }
        String orderHeader = orderPage.takeOrderHeaderValue();
        orderPage.choseConfirmButton();
        String firstNameBillingValueFromOrderConfirmation = orderConfirmationPage.takeFirstNameBillingValueFromOrderConfirmation();
        String lastNameBillingValueFromOrderConfirmation = orderConfirmationPage.takeLastNameBillingValueFromOrderConfirmation();
        String address1BillingValueFromOrderConfirmation = orderConfirmationPage.takeAddress1BillingValueFromOrderConfirmation();
        String address2BillingValueFromOrderConfirmation = orderConfirmationPage.takeAddress2BillingValueFromOrderConfirmation();
        String cityBillingValueFromOrderConfirmation = orderConfirmationPage.takeCityBillingValueFromOrderConfirmation();
        String stateBillingValueFromOrderConfirmation = orderConfirmationPage.takeStateBillingValueFromOrderConfirmation();
        String zipBillingValueFromOrderConfirmation = orderConfirmationPage.takeZipBillingValueFromOrderConfirmation();
        String countryBillingValueFromOrderConfirmation = orderConfirmationPage.takeCountryBillingValueFromOrderConfirmation();
        String firstNameShippingValueFromOrderConfirmation = orderConfirmationPage.takeFirstNameShippingValueFromOrderConfirmation();
        String lastNameShippingValueFromOrderConfirmation = orderConfirmationPage.takeLastNameShippingValueFromOrderConfirmation();
        String address1ShippingValueFromOrderConfirmation = orderConfirmationPage.takeAddress1ShippingValueFromOrderConfirmation();
        String address2ShippingValueFromOrderConfirmation = orderConfirmationPage.takeAddress2ShippingValueFromOrderConfirmation();
        String cityShippingValueFromOrderConfirmation = orderConfirmationPage.takeCityShippingValueFromOrderConfirmation();
        String stateShippingValueFromOrderConfirmation = orderConfirmationPage.takeStateShippingValueFromOrderConfirmation();
        String zipShippingValueFromOrderConfirmation = orderConfirmationPage.takeZipShippingValueFromOrderConfirmation();
        String countryShippingValueFromOrderConfirmation = orderConfirmationPage.takeCountryShippingValueFromOrderConfirmation();
        int quantityValueFromOrderConfirmation = Integer.parseInt(orderConfirmationPage.takeQuantityValueFromOrderConfirmation());
        float totalPriceValueFromOrderConfirmation = (Float.parseFloat(orderConfirmationPage.takeTotalPriceValueFromOrderConfirmation().substring(1)));

        Assertions.assertThat(firstNameBillingValueFromOrderConfirmation).isEqualTo(firstNameBillingValueFromCheckout);
        Assertions.assertThat(lastNameBillingValueFromOrderConfirmation).isEqualTo(lastNameBillingValueFromCheckout);
        Assertions.assertThat(address1BillingValueFromOrderConfirmation).isEqualTo(address1BillingValueFromCheckout);
        Assertions.assertThat(address2BillingValueFromOrderConfirmation).isEqualTo(address2BillingValueFromCheckout);
        Assertions.assertThat(cityBillingValueFromOrderConfirmation).isEqualTo(cityBillingValueFromCheckout);
        Assertions.assertThat(stateBillingValueFromOrderConfirmation).isEqualTo(stateBillingValueFromCheckout);
        Assertions.assertThat(zipBillingValueFromOrderConfirmation).isEqualTo(zipBillingValueFromCheckout);
        Assertions.assertThat(countryBillingValueFromOrderConfirmation).isEqualTo(countryBillingValueFromCheckout);
        Assertions.assertThat(firstNameShippingValueFromOrderConfirmation).isEqualTo(firstNameShippingValueFromCheckout);
        Assertions.assertThat(lastNameShippingValueFromOrderConfirmation).isEqualTo(lastNameShippingValueFromCheckout);
        Assertions.assertThat(address1ShippingValueFromOrderConfirmation).isEqualTo(address1ShippingValueFromCheckout);
        Assertions.assertThat(address2ShippingValueFromOrderConfirmation).isEqualTo(address2ShippingValueFromCheckout);
        Assertions.assertThat(cityShippingValueFromOrderConfirmation).isEqualTo(cityShippingValueFromCheckout);
        Assertions.assertThat(stateShippingValueFromOrderConfirmation).isEqualTo(stateShippingValueFromCheckout);
        Assertions.assertThat(zipShippingValueFromOrderConfirmation).isEqualTo(zipShippingValueFromCheckout);
        Assertions.assertThat(countryShippingValueFromOrderConfirmation).isEqualTo(countryShippingValueFromCheckout);
        Assertions.assertThat(totalPriceValueFromOrderConfirmation).isEqualTo(totalPriceInShoppingCart);
        Assertions.assertThat(quantityValueFromOrderConfirmation).isEqualTo(quantityInShoppingCart);
        Assertions.assertThat(orderHeader).isEqualTo(orderHeaderInCheckout);
    }


}
