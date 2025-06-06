package Pages;

import Utils.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrongHotelName {

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
        homePage.textDestination("НеверныйГород123");

        wait.until(driver -> homePage.isEmptySuggestVisible());

        String actualMessage = homePage.getEmptySuggestText();
        Assertions.assertEquals("Мы не знаем такое место :(", actualMessage);

    }

    @AfterAll
    public static void tearDown() {
        if (utils != null) {
            utils.quitDriver();
        }
    }
}
