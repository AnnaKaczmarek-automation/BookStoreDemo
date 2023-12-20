package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Random;

public class DataCreator {

    private final Faker faker = new Faker();

    public Integer createRandomListIndex(List<WebElement> webElementList) {
        Random rand = new Random();
        return rand.nextInt(webElementList.size());
    }
    public String createRandomPassword() {
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.randomAscii(8);
    }

    public String createRandomFirstName() {
        return faker.name().firstName();
    }
    public String createRandomLastName() {
        return faker.name().lastName();
    }
    public String createRandomIdNumber() {
        return faker.idNumber().toString();
    }

    public String createRandomEmail(String name) {
        return name + "@example.com";
    }

    public long createRandomPhoneNumber() {
        return faker.number().randomNumber(9, true);
    }
    public String createRandomStreet() {
        return faker.address().streetAddress();
    }
    public String createRandomStreetNumber() {
        return faker.address().streetAddressNumber();
    }
    public String createRandomCity() {
        return faker.address().city();
    }
    public String createRandomState() {
        return faker.address().state();
    }
    public String createRandomZipCode() {
        return faker.address().zipCode();
    }
    public String createRandomCountry() {
        return faker.address().country();
    }

    public Integer createRandomNumber(int minNumber, int maxNumber) {
        return faker.number().numberBetween(minNumber, maxNumber);
    }



}
