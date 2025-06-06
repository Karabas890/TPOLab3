package Pages;

import Utils.Utils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorngTransferName {
    private static Utils utils;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static HomePage homePage;
    private static HotelPage hotelPage;

    @BeforeAll
    public static void setUp() {
        utils = new Utils();
        utils.setupDriver();
        driver = utils.getDriver();
        wait = utils.getWaitTime();
        homePage = new HomePage(driver);
        hotelPage = new HotelPage(driver);
    }

    @Test
    public void testInvalidDestinationShowsError() {
        homePage.openTransfers();
        homePage.textTransferFromInput("НеверныйГород123");

        // Ожидаем появления ошибки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'EmptySuggest-module__emptySuggestText') and contains(text(), 'Мы не знаем такое место')]")
        ));

        // Проверка: текст ошибки соответствует ожидаемому
        String actualText = errorMessage.getText();
        Assertions.assertEquals("Мы не знаем такое место :(", actualText);
    }


    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}
